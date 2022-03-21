package com.example.project.service;

import com.example.project.dto.ApiResponse;
import com.example.project.dto.PaymentDTO;
import com.example.project.entity.Invoice;
import com.example.project.entity.Payment;
import com.example.project.repository.InvoiceRepository;
import com.example.project.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    final PaymentRepository paymentRepository;
    final InvoiceRepository invoiceRepository;


    public ApiResponse add(PaymentDTO dto) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(dto.getInvoiceId());
        Invoice invoice = optionalInvoice.get();
        Payment payment = new Payment();
        payment.setAmount(BigDecimal.valueOf(dto.getAmount()));
        payment.setInvoice(invoice);

        paymentRepository.save(payment);
        return new ApiResponse("To'landi", true);
    }


}
