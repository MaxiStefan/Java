package CarService.Command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class InspectionManager {
	ArrayList<CarInspectionProcess> inspections = new ArrayList<>();
	
	public void addInspection(InspectionProcess process) {
		this.inspections.add(process);
	}
	
	public void executeInspection() {
		for(CarInspectionProcess process : inspections) {
			process.processInspection();
		}
	}
}
