package com.example.springsessiondemo.exception;

public class ErrorInfo {
    private final String code;

    public ErrorInfo(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
