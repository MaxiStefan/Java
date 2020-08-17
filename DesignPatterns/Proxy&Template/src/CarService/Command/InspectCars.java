package CarService.Command;

public class InspectCars implements CarInspectionInterface{
	String car;
	
	public InspectCars(String car) {
		super();
		this.car = car;
	}

	@Override
	public void inspect() {
		System.out.println(" for " + car);
		
	}
	
}
