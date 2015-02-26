package com.example.springsessiondemo.model;

import java.io.Serializable;

public class Token implements Serializable {
    private static final long serialVersionUID = -4835673390404539052L;
    private final String tokenId;

    public Token(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenId() {
        return tokenId;
    }
}
