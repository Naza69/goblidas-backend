package com.example.goblidas_backend.services;

import com.example.goblidas_backend.DTOs.CartItemDTO;
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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {


    //@Value("${mercadopago.access.token}")
    //private String accessToken;

    public String createPreference(List<CartItemDTO> cartItems) throws MPException, MPApiException {


        List<PreferenceItemRequest> items = cartItems.stream()
                .map(item -> PreferenceItemRequest.builder()
                        .title(item.getName())
                        .quantity(item.getQuantity())
                        .unitPrice(item.getPrice())
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
                .build();

        PreferenceClient preferenceClient = new PreferenceClient();

        Preference preference = preferenceClient.create(preferenceRequest);

        return preference.getInitPoint();
    }
}
