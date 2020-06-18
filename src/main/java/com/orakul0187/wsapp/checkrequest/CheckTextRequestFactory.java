package com.orakul0187.wsapp.checkrequest;

import wsapp.wsdl.CheckTextRequest;
import wsapp.wsdl.ObjectFactory;

public class CheckTextRequestFactory extends ObjectFactory {
    public CheckTextRequest createCheckTextRequest(CheckTextRequestProp props) {
        CheckTextRequest checkTextRequest = createCheckTextRequest();
        checkTextRequest.setText(props.getText());
        checkTextRequest.setLang(props.getLang());
        checkTextRequest.setOptions(props.getOptions());
        checkTextRequest.setFormat(props.getFormat());
        return checkTextRequest;
    }
}
