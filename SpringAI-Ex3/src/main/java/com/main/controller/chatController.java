package com.main.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     
     public ResponseEntity<String> ask(@RequestParam("message") String message) {
    	 try {
    		 String responseString="";
    		 responseString= chatClient.prompt(message).call().content();
    		 return ResponseEntity.ok(responseString);
    	 }
    	catch (Exception e) {
    		System.out.println("error in open ai "+e.getMessage());
    		 return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("AI provider error"+e.getMessage());
			
		}
		
    	 
    	
     }
     
     

}
