package alo.java.basic01;

public class Manager extends Employee {
	private String type;
	
	public Manager(String name, String type) {
		super(name);
		this.type = type;
	}
	public String getType() {
		return type;
	}
	@Override
	public void test() {
		System.out.println("매니저");
	}

}
