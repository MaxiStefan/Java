package Adapter;

import java.util.ArrayList;

public class ShoppingCart2CosCumparaturi implements ICosCumparaturi {
	
	ShoppingCart cart;
	ArrayList<String> produse = new ArrayList<>();
	
	public ShoppingCart2CosCumparaturi(ShoppingCart cart) {
		this.cart = cart;
	}
	
	@Override
	public void plataCard() {
		this.cart.pay();
		
	}

	@Override
	public void plataCash() {
		this.cart.pay();
		
	}
	
	public void scoatereProdus(String produs) {
		this.cart.removeItem(produs);
	}

	@Override
	public void adaugareCos() {
		this.cart.addItem("Samsung TV");
		
	}
}
