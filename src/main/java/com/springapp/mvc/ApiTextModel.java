package com.springapp.mvc;

/**
 * Created by dengjing on 15/3/26.
 */
public class ApiTextModel {
    int error_code;
    String text;

    public ApiTextModel() {
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
