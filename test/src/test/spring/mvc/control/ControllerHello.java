package test.spring.mvc.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/mvc")
public class ControllerHello {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("11");
		return "hello";
	}
}
