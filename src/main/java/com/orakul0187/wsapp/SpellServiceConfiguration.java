package com.orakul0187.wsapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import com.orakul0187.wsapp.checkrequest.CheckTextRequestFactory;


@Configuration
public class SpellServiceConfiguration {

    @Bean
    public CheckTextRequestFactory requestFactory() {
        return new CheckTextRequestFactory();
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("wsapp.wsdl");
        return marshaller;
    }

    @Bean
    public SpellService spellService(Jaxb2Marshaller marshaller) {
        SpellService spellService = new SpellService();
        spellService.setDefaultUri("http://speller.yandex.net/services/spellservice/checkText");
        spellService.setMarshaller(marshaller);
        spellService.setUnmarshaller(marshaller);
        return spellService;
    }
}
