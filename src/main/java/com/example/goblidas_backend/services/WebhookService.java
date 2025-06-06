package com.example.goblidas_backend.services;

import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WebhookService {

    public void processPayment(Long paymentId) {
        try {
            PaymentClient paymentClient = new PaymentClient();
            Payment payment = paymentClient.get(paymentId);

            String status = payment.getStatus();
            BigDecimal amount = payment.getTransactionAmount();
            String payerEmail = payment.getPayer().getEmail();

            System.out.println("Pago recibido - Estado: " + status + ", Email: " + payerEmail);
        } catch (MPException e) {
            e.printStackTrace();
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }

}
