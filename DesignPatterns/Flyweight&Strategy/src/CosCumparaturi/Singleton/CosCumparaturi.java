package CosCumparaturi.Singleton;

import java.util.ArrayList;
import java.util.HashMap;

import CosCumparaturi.Strategy.IPlata;

public class CosCumparaturi implements ICosCumparaturi {
	
	String user;
	private static HashMap<String, CosCumparaturi> cosProduse = new HashMap<>();
	private static CosCumparaturi instance;
	
	IPlata strategiePlata = null;
	
	private CosCumparaturi(String user) {
		this.user = user;
		System.out.println("Creating a Basket to  " + user);

	}
	
	public static synchronized CosCumparaturi getCos(String user) {
		
		CosCumparaturi cos = cosProduse.get(user);
		
		if(cos == null) {
			cos = new CosCumparaturi(user);
			cosProduse.put(user, cos);
		}
		return cos;
	}
	
	@Override
	public void adaugaCos() {
		System.out.println("Avem produse in cos");
	}
	
	public void setStrategiePlata(IPlata strategie) {
		this.strategiePlata = strategie;
	}
	
	public void finalizareComanda() {
		if(this.strategiePlata != null) {
			this.strategiePlata.pay();
		}
		else
			throw new UnsupportedOperationException();
	}
}
