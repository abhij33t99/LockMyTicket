package com.ticketbooking.notificationservice.kafka;

import com.ticketbooking.notificationservice.service.InvoiceGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final InvoiceGeneratorService invoiceGeneratorService;

    @KafkaListener(topics = "invoice-topic", groupId = "invoice-group", concurrency = "4")
    public void invoiceConsumer(Invoice invoice) {
        log.info("Invoice received: {}", invoice);
        invoiceGeneratorService.generateInvoice(invoice.getBookingId());
    }
}
