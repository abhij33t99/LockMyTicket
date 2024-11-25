package com.ticketbooking.notificationservice.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.ticketbooking.notificationservice.dto.InvoiceDto;
import com.ticketbooking.notificationservice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceGeneratorService {

    private final InvoiceRepository invoiceRepository;
    private final EmailService emailService;

    public void generateInvoice(long bookingId) {
        // fetch necessary details for invoice
        var invoiceDto = fetchInvoiceDetails(bookingId);
        // generate pdf
        log.info("Invoice generated: {}", invoiceDto);
        generateInvoicePdf(invoiceDto);
    }

    private InvoiceDto fetchInvoiceDetails(long bookingId) {
        return invoiceRepository.fetchNecessaryDetailsForInvoice(bookingId);
    }

    private void generateInvoicePdf(InvoiceDto invoiceDto) {
        Document document = new Document();
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter.getInstance(document, baos);
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
            Image logo = Image.getInstance(new File("/app/resources/static/logo.png").toString());
            logo.scaleToFit(500, 300);
            document.add(logo);
            document.add(new Paragraph("Thank you for purchase, %s!!".formatted(invoiceDto.getName()), font));
            font.setSize(16);
            document.add(new Paragraph(invoiceDto.getMovieName(), font));
            document.add(new Paragraph(invoiceDto.getTheatreName()+","+invoiceDto.getCityName(), font));
            document.add(new Paragraph("Quantity: " + invoiceDto.getSeats(), font));
            font.setSize(20);
            font.setColor(BaseColor.GREEN);
            document.add(new Paragraph("SEATS: " + invoiceDto.getSeatNames(), font));
            font.setColor(BaseColor.BLACK);
            document.add(new Paragraph("Total Price: " + invoiceDto.getShowPrice() * invoiceDto.getSeats(), font));
            document.close();

            emailService.sendMessage(invoiceDto, baos.toByteArray());
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
