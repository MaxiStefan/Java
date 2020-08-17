package Facade;

public class Sesiune {
	User user;

	public void setUser(User user) {
		this.user = user;
	}
	public void messageOfTheDay() {
		System.out.println("Hello " + this.user.nume);
	}
}
