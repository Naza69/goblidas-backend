package com.example.goblidas_backend.config;

import com.mercadopago.MercadoPagoConfig;
import org.eclipse.sisu.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoConfigService {

    @Value("${mercadopago.access.token}")
    private String accessToken;

    @PostConstruct
    public void init(){
        MercadoPagoConfig.setAccessToken(accessToken);
    }
}
