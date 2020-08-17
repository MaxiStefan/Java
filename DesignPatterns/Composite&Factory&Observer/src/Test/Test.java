package Test;

import java.util.ArrayList;

import AutoService.Composite.AbstractNode;
import AutoService.Composite.AutoMechanic;
import AutoService.Composite.AutoMechanicEngineer;
import AutoService.Factory.AbstractCustomer;
import AutoService.Factory.ClientType;
import AutoService.Factory.CustomerFactory;
import AutoService.Observer.Client;
import AutoService.Observer.MonitorizareNotificari;
import AutoService.Observer.NotificationAds;
import AutoService.Observer.NotificationUpdate;

public class Test {
	public static void main(String[] args) {
	ArrayList<AbstractCustomer> customers = new ArrayList<>();
	
	customers.add(CustomerFactory.getCustomer(ClientType.CUSTOMER));
	customers.add(CustomerFactory.getCustomer(ClientType.LOYALCLIENT));
	customers.add(CustomerFactory.getCustomer(ClientType.VIPCLIENT));
	
	for(AbstractCustomer customer : customers) {
		customer.display();
	}

	MonitorizareNotificari monitorObserveri = new MonitorizareNotificari();
	Client client1 = new Client("Popescu");
	Client client2 = new Client("Ionescu");
	Client client3 = new Client("Fratescu");
	
	monitorObserveri.registerObserver(client1);
	monitorObserveri.registerObserver(client2);
	monitorObserveri.registerObserver(client3);
	
	NotificationUpdate update = new NotificationUpdate("we Fixed your bumper");
	NotificationAds ad = new NotificationAds("You won a tesla");
	
	monitorObserveri.sendAds(ad);
	monitorObserveri.carUpdate(update);
	
	System.out.println("\n");
	System.out.println("==============Composite=============");
	AutoMechanicEngineer autoMechanicEngi1 = new AutoMechanicEngineer("MechanicEngi1");
	AutoMechanicEngineer autoMechanicEngi2 = new AutoMechanicEngineer("MechanicEngi2");
	AutoMechanicEngineer autoMechanicEngi3 = new AutoMechanicEngineer("MechanicEngi3");
	autoMechanicEngi1.addNode(autoMechanicEngi2);
	autoMechanicEngi1.addNode(autoMechanicEngi3);
	System.out.println("FIRST TEAM --------------\n" + autoMechanicEngi1.getInfo());


	AutoMechanicEngineer autoMechanicEngi4 = new AutoMechanicEngineer("MechanicEngi4");
	AutoMechanic mechanic1 = new AutoMechanic("Mechanic1");
	AutoMechanic mechanic2 = new AutoMechanic("Mechanic2");
	autoMechanicEngi4.addNode(mechanic1);
	autoMechanicEngi4.addNode(mechanic2);
	System.out.println("SECOND TEAM --------------\n" + autoMechanicEngi4.getInfo());


	}
}
