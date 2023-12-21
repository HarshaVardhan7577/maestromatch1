package com.stackroute.contentmanagementservice.chatbot;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class ChatGPTRequest {

    private String model;
    private List<Message> messages;
    private Integer max_tokens;

    public ChatGPTRequest(String model, String prompt){
        this.model=model;
        this.messages=new ArrayList<>();
        this.messages.add(new Message("user",prompt));
    }

}
