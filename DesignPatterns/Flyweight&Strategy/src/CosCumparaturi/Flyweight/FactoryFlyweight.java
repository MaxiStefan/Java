package CosCumparaturi.Flyweight;

import java.util.HashMap;

public class FactoryFlyweight {
	
	private static HashMap<ElementType, FlyweightInterface> elemente = new HashMap<>();
	
	public static FlyweightInterface getElement(ElementType type) {
		FlyweightInterface model = elemente.get(type);
		
		if(model == null) {			
			
			switch(type) {
			case ELECTRONICS:
				model = new ElementeGrafice("ELECTRONICS.png", "400px");
				break;
			case TOYS:
				model = new ElementeGrafice("TOYS.png", "800px");
				break;
			default:
				throw new UnsupportedOperationException();
			}
			
		elemente.put(type, model);
		
		}
		return model;
	}
}
