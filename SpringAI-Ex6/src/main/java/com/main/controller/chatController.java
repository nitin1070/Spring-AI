package com.main.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class chatController {
	@Autowired
	@Qualifier("openAIChatClient") 
	private ChatClient openAIChatClient;
	@Autowired
	@Qualifier("OllamaChatClient") 
	private ChatClient ollamaChatClient;



	@GetMapping("/askOpenAI")
	public ResponseEntity<String> askOpenAI(@RequestParam("message") String message) {
		try {
			String responseString = "";
			responseString = openAIChatClient.prompt(message).call().content();
			return ResponseEntity.ok(responseString);
		} catch (Exception e) {
			System.out.println("error in open ai " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("AI provider error" + e.getMessage());

		}

	}

	@GetMapping("/askOllama")
	public ResponseEntity<String> askOllama(@RequestParam("message") String message) {
		try {
			String responseString = "";
			responseString = ollamaChatClient.prompt(message).call().content();
			return ResponseEntity.ok(responseString);
		} catch (Exception e) {
			System.out.println("error in open ai " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("AI provider error" + e.getMessage());

		}

	}
}
