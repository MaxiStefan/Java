package Hospital.Adapter;

public class PleaseHelpPatient implements PatientDescriptionInterface {
	String condition;

	public PleaseHelpPatient(String condition) {
		this.condition = condition;
	}

	@Override
	public void getDescription() {
		System.out.println("Patient is " + this.condition);
		
	}
	
	
}
