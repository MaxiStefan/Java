package Facade;

public class User {
	String nume;
	
	public User(String name) {
		this.nume = name;
	}
	
	public void creareUser( String pass) {
		System.out.println("Welcome " + this.nume);
	}
}
