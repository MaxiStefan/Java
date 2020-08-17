package AutoService.Factory;

public class LoyalClient extends AbstractCustomer{
	int points;
	
	public LoyalClient(int points) {
		this.points = points;
	}

	@Override
	public void display() {
		System.out.println("I am a loyalClient with " + points + " points!");
		
	}
}
