package com.stackroute.contentmanagementservice.controller;

import com.stackroute.contentmanagementservice.chatbot.ChatGPTRequest;
import com.stackroute.contentmanagementservice.chatbot.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/content/chatbot")
public class ChatBotController {

    @Autowired
    private RestTemplate template;
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;


    @GetMapping("/ask")
    public String chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request=new ChatGPTRequest(model,prompt);
        ChatGPTResponse chatGPTResponse =template.postForObject(apiUrl,request,ChatGPTResponse.class);
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }
}
