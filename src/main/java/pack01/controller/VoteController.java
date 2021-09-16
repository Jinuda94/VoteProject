package pack01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/vote")
public class VoteController {
	
	@RequestMapping(value = "/votecheck")
	public String votecheck() {
		System.out.println("votecheck 옴");
		return "Vote";
	}
	
	@RequestMapping(value = "/voteinsert")
	public String voteinsert() {
		System.out.println("voteinsert 옴");
		return "redirect:/index.jsp";
	}
	
	

}
