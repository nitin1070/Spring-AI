package com.main.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class chatClientConfiguration {

	@Bean
	public  ChatClient openAIChatClient(OpenAiChatModel model) {
		return ChatClient.create(model);
	}
	@Bean
	public  ChatClient OllamaChatClient(OllamaChatModel model) {
		return ChatClient.create(model);
	}


	

}
