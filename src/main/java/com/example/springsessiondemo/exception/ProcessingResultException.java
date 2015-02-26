package com.example.springsessiondemo.exception;

import org.springframework.http.HttpStatus;

public class ProcessingResultException extends RuntimeException {
    private final ProcessingResult processingResult;
    private final HttpStatus status;

    public ProcessingResultException(ProcessingResult processingResult, HttpStatus status) {
        this.processingResult = processingResult;
        this.status = status;
    }

    public ProcessingResult getProcessingResult() {
        return processingResult;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
