package CarService.Proxy;

public class InspectionScheduler implements IVehicle {

	@Override
	public void inspectCar(String car, int weight) {
		System.out.println("Inspecting car " + car + " of weight " + weight);
		
	}

}
