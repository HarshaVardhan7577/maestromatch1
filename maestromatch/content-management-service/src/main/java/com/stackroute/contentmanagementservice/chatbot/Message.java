package com.stackroute.contentmanagementservice.chatbot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    public String role;
    public String content;

    // Constructors, Getters and Setters
}