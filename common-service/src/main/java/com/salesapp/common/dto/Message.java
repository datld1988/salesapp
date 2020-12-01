package com.salesapp.common.dto;

import lombok.Data;

@Data
public class Message {
    private String code;
    private String message;

    public Message() {
    }

    public Message(String code) {
        this.code = code;
    }

    public Message(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
