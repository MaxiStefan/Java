package CosCumparaturi.Flyweight;

public class ElementeGrafice implements FlyweightInterface{
	String sursa;
	String pixeli;

	
	public ElementeGrafice(String sursa, String pixeli) {
		super();
		this.sursa = sursa;
		this.pixeli = pixeli;
	}


	@Override
	public void afisareEcran(DetaliiAfisare detalii) {
		System.out.println("Se afiseaza " + sursa);
		System.out.println("\t Pentru produsul " + detalii.produs + " la " + pixeli);
	}

}
