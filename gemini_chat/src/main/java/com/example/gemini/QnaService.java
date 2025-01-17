package com.example.gemini;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class QnaService {

	//Access to API KEY and URL[Gemini]	
	@Value("${gemini.api.url}")
	private String geminiApiUrl;
	
	@Value("${gemini.api.key}")
	private String geminiApiKey;
	
	private WebClient webClient;
	
	public QnaService(WebClient.Builder webClient) {
		this.webClient = webClient.build();
	}
	
	
	public String getAnswer(String question) {
		//construct request payload
//		 "contents": [{"parts":[{"text": "Explain how AI works"}]}] }'
		//requests will be sent in above format
		
		Map<String , Object> requestBody = Map.of(
				"contents" , new Object[] {
						Map.of("parts" , new Object[] {
							Map.of("text" ,question)
						})
				}
				);		
		
		//make api calls
	String response = 	webClient.post()
		.uri(geminiApiUrl )
		.header("Content-Type", "application/json")
		.bodyValue(requestBody)
		.retrieve()
		.bodyToMono(String.class).block();
		
		System.out.println(geminiApiKey);
		System.out.println(geminiApiUrl);
		
		//return response
		return response;
	}

}
