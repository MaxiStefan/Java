package Adapter;

import java.util.ArrayList;

public class ShoppingCart implements IShoppingCart {
	ArrayList<String> produse = new ArrayList<>();
	
	public ShoppingCart(String produs) {
		produse.add(produs);
	}
	@Override
	public void pay() {
		System.out.println("Payment processing...");
		
	}

	@Override
	public void addItem(String produs) {
		produse.add(produs);
		System.out.println(produs + " has been added to the cart.");
		
	}

	@Override
	public void removeItem(String produs) {
		produse.remove(produs);
		System.out.println(produs + " has been removed from the cart.");

	}
	

}
