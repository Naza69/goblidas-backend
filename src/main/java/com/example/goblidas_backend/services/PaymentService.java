package com.example.goblidas_backend.services;

import com.example.goblidas_backend.DTOs.CartItemDTO;
import com.example.goblidas_backend.entities.Order;
import com.example.goblidas_backend.repositories.OrderRepository;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.resources.preference.PreferenceItem;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {


    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    //@Value("${mercadopago.access.token}")
    //private String accessToken;

    public String createPreferenceFromOrder(Long orderId) throws MPException, MPApiException {

        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Orden no encontrada"));



        List<PreferenceItemRequest> items = order.getOrderDetails().stream()
                .map(detail -> PreferenceItemRequest.builder()
                        .title(detail.getDetailId().getProductIdj().getName())
                        .quantity(detail.getQuantity())
                        .unitPrice(detail.getUnitPrice())
                        .currencyId("ARS")
                        .build())
                .collect(Collectors.toList());

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(PreferenceBackUrlsRequest.builder()
                        .success("http://localhost:5173/success")
                        .failure("http://localhost:5173/failure")
                        .pending("http://localhost:5173/pending")
                        .build())
                .autoReturn("approved")
                .externalReference(orderId.toString())
                .build();

        PreferenceClient preferenceClient = new PreferenceClient();

        Preference preference = preferenceClient.create(preferenceRequest);

        return preference.getInitPoint();
    }
}
