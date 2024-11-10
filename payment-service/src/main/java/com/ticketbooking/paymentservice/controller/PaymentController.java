package com.ticketbooking.paymentservice.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.ticketbooking.paymentservice.dto.OrderDto;
import com.ticketbooking.paymentservice.service.RazorPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private RazorPayService razorpayService;

    @PostMapping("/createOrder")
    public Order createOrder(OrderDto orderDto) {
        try {
            // Create the order with the specified amount and currency
            return razorpayService.createOrder(orderDto.getAmount(), orderDto.getCurrency());  // Return order details to the frontend
        } catch (RazorpayException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create Razorpay order", e);
        }
    }
}
