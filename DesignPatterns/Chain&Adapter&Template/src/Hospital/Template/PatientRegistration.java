package Hospital.Template;

public abstract class PatientRegistration {
	int codClient;
		
	public PatientRegistration( int codClient) {
		this.codClient = codClient;
	}
	
	public abstract void requestDetails(int codClient);
	public abstract void checkConditions(int codClient);
	public abstract void checkInsurance(int codClient);
	
	public final void registerPatient() {
		requestDetails(this.codClient);
		checkConditions(this.codClient);		
		checkInsurance(this.codClient);
	}
}
