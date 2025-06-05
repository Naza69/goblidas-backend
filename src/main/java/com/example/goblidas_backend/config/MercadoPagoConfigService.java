package com.example.goblidas_backend.config;

import com.mercadopago.MercadoPagoConfig;
import org.eclipse.sisu.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoConfigService {
    @PostConstruct
    public void init(){
        MercadoPagoConfig.setAccessToken("TEST-5526674981794431-060517-4ce4e1a53f659e8c6068c09202013ec8-2109126111");
    }
}
