package CarService.Command;

public class InspectionProcess implements CarInspectionProcess {
	
	CarInspectionInterface inspection;
	String task;
	
	
	public InspectionProcess(CarInspectionInterface inspection, String task) {
		super();
		this.inspection = inspection;
		this.task = task;
	}

	@Override
	public void processInspection() {
		System.out.println(task);
		inspection.inspect();
	}

}
