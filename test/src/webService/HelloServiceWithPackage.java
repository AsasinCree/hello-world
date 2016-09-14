package webService;

public class HelloServiceWithPackage {
	public String sayHello() {
		return "hello";
	}

	public String sayHelloToPerson(String name) {
		if (name == null) {
			name = "nobody";
		}
		return "hello," + name;
	}

	public void updateData(String data) {
		System.out.println(data + " ÒÑ¸üÐÂ¡£");
	}
}