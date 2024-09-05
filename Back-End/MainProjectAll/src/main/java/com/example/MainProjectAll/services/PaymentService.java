package com.example.MainProjectAll.services;

import com.example.MainProjectAll.entity.Payment;
import com.example.MainProjectAll.entity.Receipt;
import com.example.MainProjectAll.repository.PaymentRepository;
import com.example.MainProjectAll.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private EmailService emailService;

    @Transactional
    public void processPayment(Payment payment) {
        // Save payment details
        paymentRepository.save(payment);

        // Generate receipt
        Receipt receipt = new Receipt();
        receipt.setPayment(payment);
        receipt.setReceiptContent("Receipt for payment of rupees" + payment.getAmount());
        receipt.setReceiptDate(LocalDateTime.now());
        receiptRepository.save(receipt);

        // Send receipt via email
        emailService.sendEmail(payment.getCustomerEmail(), "Payment Receipt", receipt.getReceiptContent());
    }
}


