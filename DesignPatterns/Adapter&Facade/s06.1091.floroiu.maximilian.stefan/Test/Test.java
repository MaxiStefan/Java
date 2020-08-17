package Test;

import java.util.ArrayList;

import Adapter.ICosCumparaturi;
import Adapter.ShoppingCart;
import Adapter.ShoppingCart2CosCumparaturi;
import Facade.CosCumparaturi;
import Facade.CosCumparaturiFacade;

public class Test {
	public static void main(String[] args) {
		
		CosCumparaturiFacade cos = new CosCumparaturiFacade("Floroiu Maximilian Stefan");
		cos.proceduraFacade();
		System.out.println("\n");

		
		ArrayList<ICosCumparaturi> cumparaturi = new  ArrayList<>();
		cumparaturi.add(new CosCumparaturi("Bascheti"));
		cumparaturi.add(new CosCumparaturi("Iphone"));
		cumparaturi.add(new CosCumparaturi("OnePLus"));
		
		for(ICosCumparaturi produs : cumparaturi) {
			produs.plataCard();
		}
		
		ShoppingCart cart = new ShoppingCart("IceCream");
		ShoppingCart2CosCumparaturi adapterCart = new ShoppingCart2CosCumparaturi(cart);
		
		cumparaturi.add(adapterCart);
		System.out.println("\n");
		for(ICosCumparaturi produs : cumparaturi) {
			produs.plataCard();
		}
	}
}
