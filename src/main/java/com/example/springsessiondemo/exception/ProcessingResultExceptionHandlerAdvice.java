package com.example.springsessiondemo.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProcessingResultExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
    private static final Log LOG = LogFactory.getLog(ProcessingResultExceptionHandlerAdvice.class);

    @ExceptionHandler(ProcessingResultException.class)
    protected ResponseEntity<Object> handleInvalidRequest(
            ProcessingResultException processingResultException, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        ProcessingResult processingResult = processingResultException.getProcessingResult();
        HttpStatus status = processingResultException.getStatus();
        log(processingResult, status, request);
        return handleExceptionInternal(processingResultException, processingResult, headers, status,
                request);
    }

    private void log(ProcessingResult processingResult, HttpStatus status, WebRequest request) {
        if (LOG.isInfoEnabled()) {
            ToStringBuilder builder = new ToStringBuilder(this);
            builder.append(processingResult);
            builder.append(status);
            builder.append(request);
            String stringValue = builder.toString();
            LOG.info(stringValue);
        }
    }
}
