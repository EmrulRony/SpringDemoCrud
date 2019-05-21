package com.solutionia.springcrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/showTest")
	public String testShow() {
		
		return "test";
	}

}
