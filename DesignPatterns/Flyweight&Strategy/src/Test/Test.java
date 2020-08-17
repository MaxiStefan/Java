package Test;

import CosCumparaturi.Flyweight.DetaliiAfisare;
import CosCumparaturi.Flyweight.ElementType;
import CosCumparaturi.Flyweight.ElementeGrafice;
import CosCumparaturi.Flyweight.FactoryFlyweight;
import CosCumparaturi.Singleton.CosCumparaturi;
import CosCumparaturi.Singleton.ProduseIgiena;
import CosCumparaturi.Singleton.ProduseVestimentare;
import CosCumparaturi.Strategy.PlataBitcoin;
import CosCumparaturi.Strategy.PlataCard;
import CosCumparaturi.Strategy.PlataCash;

public class Test {

	public static void main(String[] args) {
		
		ProduseIgiena p1 = new ProduseIgiena("Maximilian");
		ProduseVestimentare p2 = new ProduseVestimentare("Maximilian");
		
		CosCumparaturi cos = CosCumparaturi.getCos("Maximilian");
		cos.setStrategiePlata(new PlataCard());
		cos.finalizareComanda();
		System.out.println("\n");
		cos.setStrategiePlata(new PlataCash());
		cos.finalizareComanda();
		System.out.println("\n");
		cos.setStrategiePlata(new PlataBitcoin());
		cos.finalizareComanda();
		
		
		
		
		ElementeGrafice pictogramaElectronics = (ElementeGrafice) FactoryFlyweight.getElement(ElementType.ELECTRONICS);
		ElementeGrafice pictogramaToys= (ElementeGrafice) FactoryFlyweight.getElement(ElementType.TOYS);

		pictogramaElectronics.afisareEcran(new DetaliiAfisare("Samsung", "La dreapta"));
		pictogramaToys.afisareEcran(new DetaliiAfisare("catelusDePlush", "La dreapta"));
		pictogramaElectronics.afisareEcran(new DetaliiAfisare("Iphone", "Sus"));
		pictogramaToys.afisareEcran(new DetaliiAfisare("Barbie", "La dreapta"));


	}

}
