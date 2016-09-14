package test.spring.mvc.control;

import java.io.PrintWriter;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.mvc.model.Person;

@Controller
public class CheckName {
	@Autowired
	Person p;
	
	@RequestMapping("/check")
	public void check(PrintWriter pWriter){
		System.out.println(p.getName()+" "+p.getPass());
		pWriter.write("welcome");
	}
}
