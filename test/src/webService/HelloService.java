package webService;

public class HelloService {
	public String sayHello() {
		return "hello";
	}

	public String sayHelloToPerson(String name) {
		if (name == null) {
			name = "nobody";
		}
		return "hello," + name;
	}
}