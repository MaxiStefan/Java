package AutoService.Observer;

public class Client extends InterfaceCustomerNotifications {
	String name;
	
	public Client(String name) {
		this.name = name;
	}

	@Override
	public void receivedNotification(String msg) {
		System.out.println(this.name + " has received " + msg);
		
	}

}
