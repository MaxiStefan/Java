package AutoService.Observer;

public class NotificationAds extends InterfaceCustomerNotifications {
	public String msg;
	
	
	public NotificationAds(String msg) {
		super();
		this.msg = msg;
	}


	@Override
	public void receivedNotification(String msg) {
		System.out.println(msg);
		
	}

}
