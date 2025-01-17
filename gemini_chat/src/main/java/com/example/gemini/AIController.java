package com.example.gemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AIController {
	
	@Autowired
	public  QnaService qnaService;
	
	
	
	@RequestMapping("/home")
	public String askQuestion() {
		
		
		return"index";
	}
	
	@GetMapping("/ask/{question}")
	@ResponseBody
	public String askquestion( @PathVariable String question , Model model) {
		
		
		String answer = qnaService.getAnswer(question);
	
		return answer;
	}

}