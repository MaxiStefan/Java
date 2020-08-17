package AutoService.Observer;

public class NotificationUpdate extends InterfaceCustomerNotifications {
	public String msg;
	
	
	public NotificationUpdate(String msg) {
		super();
		this.msg = msg;
	}
	
	@Override
	public void receivedNotification(String msg) {
		System.out.println(msg);
		
	}

}
