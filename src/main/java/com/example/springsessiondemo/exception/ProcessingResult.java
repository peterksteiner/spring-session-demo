package com.example.springsessiondemo.exception;

import java.util.List;

public class ProcessingResult {
    private List<ErrorInfo> errors;

    public ProcessingResult(List<ErrorInfo> errors) {
        this.errors = errors;
    }

    public List<ErrorInfo> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorInfo> errors) {
        this.errors = errors;
    }
}
