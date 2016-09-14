package test.spring.mvc.model;

import org.springframework.stereotype.Repository;

@Repository
public class Person {
	private String name;
	private String pass;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
