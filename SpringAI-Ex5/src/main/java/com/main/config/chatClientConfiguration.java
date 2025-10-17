package com.main.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class chatClientConfiguration {

	@Bean  
	public ChatClient chatClient(ChatClient.Builder builder) {
		 ChatOptions chatOptions=ChatOptions.builder()
				 				.model("gpt-4o-mini")
				 				.temperature(0.2)
				 				.maxTokens(500)
				 				.build();
		 return builder.defaultOptions(chatOptions).build();
		 
		 
	  }

}
