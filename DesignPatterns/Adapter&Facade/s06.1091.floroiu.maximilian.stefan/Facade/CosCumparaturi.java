package Facade;

import Adapter.ICosCumparaturi;

public class CosCumparaturi implements ICosCumparaturi {
	String produs;
	
	public CosCumparaturi(String produs) {
		this.produs = produs;
	}
	public void finalizeazaComanda(int valoare) {
		System.out.println("Comanda de " + valoare + " let a fost finalizata.");
	}

	@Override
	public void plataCard() {
		System.out.println("Plata este efectuata cu cardul.");
		
	}

	@Override
	public void plataCash() {
		System.out.println("Plata este efectuata cu cash la livrare.");
		
	}

	@Override
	public void adaugareCos() {
		System.out.println("Produsul " + this.produs + " a fost adaugat in cos.");
		
	}
}
