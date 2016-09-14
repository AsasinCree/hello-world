package test.reflect;

public class PersonChina implements China{
	 public PersonChina() {
         
	    }
	    public PersonChina(String sex){
	        this.sex=sex;
	    }
	    public String getSex() {
	        return sex;
	    }
	    public void setSex(String sex) {
	        this.sex = sex;
	    }
	    @Override
	    public void sayChina(){
	        System.out.println("hello ,china");
	    }
	    @Override
	    public void sayHello(String name, int age){
	        System.out.println(name+"  "+age);
	    }
	    private String sex;
}
