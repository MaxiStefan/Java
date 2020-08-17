package AutoService.Factory;

public class CustomerFactory {
	
	public static AbstractCustomer getCustomer(ClientType client) {
		
		switch(client) {
		case CUSTOMER:
			return new Customer();
		case LOYALCLIENT:
			return new LoyalClient(250);
		case VIPCLIENT:
			return new VipClient();
		default:
			throw new UnsupportedOperationException();
			
		}
	}
}
