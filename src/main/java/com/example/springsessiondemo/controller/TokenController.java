package com.example.springsessiondemo.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springsessiondemo.exception.ErrorInfo;
import com.example.springsessiondemo.exception.ProcessingResult;
import com.example.springsessiondemo.exception.ProcessingResultException;
import com.example.springsessiondemo.model.Token;

@Controller
public class TokenController {
    private long nextTokenId = 10000;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<Token> createToken(HttpSession session) {
        String tokenId = getNextTokenId();
        Token token = new Token(tokenId);
        session.setAttribute("token", token);
        ResponseEntity<Token> responseEntity = new ResponseEntity<Token>(token, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public ResponseEntity<Token> getToken(HttpSession session) {
        Token token = (Token) session.getAttribute("token");
        if (token == null) {
            ErrorInfo errorInfo = new ErrorInfo("token not in session");
            List<ErrorInfo> errorInfoList = Arrays.asList(errorInfo);
            ProcessingResult processingResult = new ProcessingResult(errorInfoList);
            throw new ProcessingResultException(processingResult, HttpStatus.NOT_FOUND);
        }
        ResponseEntity<Token> responseEntity = new ResponseEntity<Token>(token, HttpStatus.OK);
        return responseEntity;
    }

    private String getNextTokenId() {
        nextTokenId = nextTokenId + 17;
        return String.valueOf(nextTokenId);
    }
}
