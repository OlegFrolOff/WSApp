package com.orakul0187.wsapp.checkrequest;

import lombok.Data;

@Data
public class CheckTextRequestProp {
    private String text;
    private String lang;
    private int options;
    private String format;

    public CheckTextRequestProp(String text, String lang, int options, String format) {
        this.text = text;
        this.lang = lang;
        this.options = options;
        this.format = format;
    }
}
