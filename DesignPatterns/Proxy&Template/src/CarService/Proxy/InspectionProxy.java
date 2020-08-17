package CarService.Proxy;

public class InspectionProxy implements IVehicle{
	
	IVehicle inspection = null;
	
	public static final int MAX_WEIGHT = 500;
	
	public InspectionProxy(IVehicle inspection) {
		super();
		this.inspection = inspection;
	}

	@Override
	public void inspectCar(String car, int weight) {
		if(weight < MAX_WEIGHT)
			inspection.inspectCar(car, weight);
		else
			System.out.println("Car " + car + " has a weight over " + MAX_WEIGHT + ". Cannot inspect!");
		
	}

}
