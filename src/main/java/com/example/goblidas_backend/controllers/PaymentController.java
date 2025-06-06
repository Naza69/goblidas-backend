package com.example.goblidas_backend.controllers;


import com.example.goblidas_backend.DTOs.CartItemDTO;
import com.example.goblidas_backend.services.PaymentService;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.MercadoPagoClient;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.resources.preference.PreferenceItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;



    public PaymentController(PaymentService paymentService) throws MPException {

        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPayment(@RequestBody List<CartItemDTO> cartItems) {
        try {
            String initPoint = paymentService.createPreference(cartItems);
            return ResponseEntity.ok(initPoint);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al generar el pago" + e.getMessage());
        }
    }

}
