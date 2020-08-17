package AutoService.Observer;

import java.util.ArrayList;

public class MonitorizareNotificari {
	ArrayList<InterfaceCustomerNotifications> observers = new ArrayList<>();
 
 	public void registerObserver(InterfaceCustomerNotifications observer) {
 		observers.add(observer);
 	}
 	
 	public void unregisterObserver(InterfaceCustomerNotifications observer) {
 		observers.remove(observer);
 	}
 	
 	public void notifyCustomer(String msg) {
 		for(InterfaceCustomerNotifications observer : observers) {
 			observer.receivedNotification(msg);
 		}
 	}
 	
 	public void sendAds(NotificationAds ads) {
 		notifyCustomer(ads.msg);
 	}
 	
 	public void carUpdate(NotificationUpdate update) {
 		notifyCustomer(update.msg);
 	}
}
