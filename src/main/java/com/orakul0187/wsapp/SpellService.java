package com.orakul0187.wsapp;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import wsapp.wsdl.CheckTextRequest;
import wsapp.wsdl.CheckTextResponse;
import wsapp.wsdl.SpellError;
import wsapp.wsdl.SpellResult;

import java.util.List;

public class SpellService extends WebServiceGatewaySupport {

    public CheckTextResponse getCheckTextResponse(CheckTextRequest checkTextRequest) {
        CheckTextResponse checkTextResponse = (CheckTextResponse) getWebServiceTemplate()
                .marshalSendAndReceive(checkTextRequest
                        , new SoapActionCallback("http://speller.yandex.net/services/spellservice/checkText"));
        return checkTextResponse;
    }

    public String printCheckTextResponse(CheckTextResponse response){
        List<SpellError> errors = response.getSpellResult().getError();
        StringBuilder res = new StringBuilder();
            errors.forEach(e -> {
                res.append("Ошибка: ");
                switch (e.getCode()){
                    case 1 : res.append("ERROR_UNKNOWN_WORD"); break;
                    case 2 : res.append("ERROR_REPEAT_WORD"); break;
                    case 3 : res.append("ERROR_CAPITALIZATION"); break;
                    case 4 : res.append("ERROR_TOO_MANY_ERRORS"); break;
                }
                res.append("\n").append("pos = ").append(e.getPos()).append(", ");
                res.append("row = ").append(e.getRow()).append(", ");
                res.append("col = ").append(e.getCol()).append(", ");
                res.append("len = ").append(e.getLen()).append("\n");
                res.append("error word : ").append(e.getWord()).append("\n");
                if(!e.getS().isEmpty()){
                    res.append("s : ");
                    e.getS().forEach(s->{
                        res.append(s).append("\n\t");
                    });
                }
            });
        return res.toString();
    }

}
