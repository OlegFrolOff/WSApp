package com.orakul0187.wsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import com.orakul0187.wsapp.checkrequest.CheckTextRequestFactory;
import com.orakul0187.wsapp.checkrequest.CheckTextRequestProp;
import wsapp.wsdl.CheckTextResponse;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WSApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WSApp.class, args);
        SpellService spellService = context.getBean(SpellService.class);
        CheckTextRequestFactory requestFactory = context.getBean(CheckTextRequestFactory.class);

        List<CheckTextRequestProp> requestProps = new ArrayList<>();
        requestProps.add(new CheckTextRequestProp("В лесу родилась родилась ёлочка", "ru", 8, "plain"));
        requestProps.add(new CheckTextRequestProp("В лесу родилась родилась ёлачка", "ru", 8, "plain"));
        requestProps.add(new CheckTextRequestProp("В лесу родилась родилась ёлачка", "ru", 0, "plain"));

        requestProps.forEach(p -> {
            System.out.println(p.getText());
            CheckTextResponse response = spellService.getCheckTextResponse(requestFactory.createCheckTextRequest(p));
            System.out.println(spellService.printCheckTextResponse(response));
        });

        ((ConfigurableApplicationContext) context).close();
    }
}
