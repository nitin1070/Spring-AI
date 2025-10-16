package com.main.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class chatController {
     private ChatClient chatClient;
     
     public chatController(ChatClient.Builder builder) {
    	 chatClient=builder.build();
     }
     @GetMapping("/ask")
     public String ask(@RequestParam("message") String message) {
    	 return chatClient.prompt(message).call().content();
     }
     
     

}
