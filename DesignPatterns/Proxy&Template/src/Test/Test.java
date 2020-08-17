package Test;

import CarService.Command.CarInspectionProcess;
import CarService.Command.InspectCars;
import CarService.Command.InspectionManager;
import CarService.Command.InspectionProcess;
import CarService.Proxy.IVehicle;
import CarService.Proxy.InspectionProxy;
import CarService.Proxy.InspectionScheduler;
import CarService.Template.AutoServiceBucuresti;
import CarService.Template.AutoServiceCluj;
import CarService.Template.ServiceProcedure;

public class Test {

	public static void main(String[] args) {
		ServiceProcedure serviceBuc = new AutoServiceBucuresti(5);
		serviceBuc.serviceProcedure();
		System.out.println("\n");
		ServiceProcedure serviceCluj = new AutoServiceCluj(5);
		serviceCluj.serviceProcedure();
		
		IVehicle inspection = new InspectionScheduler();
		InspectionProxy proxyInspection = new InspectionProxy(inspection);
		System.out.println("\n");
		proxyInspection.inspectCar("BMW", 800);
		proxyInspection.inspectCar("BMW", 250);

		
		System.out.println("\n");
		InspectionManager manager = new InspectionManager();
		InspectCars car1 = new InspectCars("BMW");
		InspectCars car2 = new InspectCars("Mercedes");
		InspectCars car3 = new InspectCars("Toyota");
		
		InspectionProcess proces1 = new InspectionProcess(car1, "inspecting brakes");
		InspectionProcess proces2 = new InspectionProcess(car2, "inspecting exhaust");
		InspectionProcess proces3 = new InspectionProcess(car3, "visual inspection");

		manager.addInspection(proces1);	
		manager.addInspection(proces2);
		manager.addInspection(proces3);
		
		manager.executeInspection();

	}

}
