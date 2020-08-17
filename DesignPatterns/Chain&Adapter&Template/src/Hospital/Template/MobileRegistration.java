package Hospital.Template;

public class MobileRegistration extends PatientRegistration {

	public MobileRegistration(int codClient) {
		super(codClient);
	}

	@Override
	public void requestDetails(int codClient) {
		System.out.println("Requesting personal information from " + codClient);
		
	}

	@Override
	public void checkConditions(int codClient) {
		System.out.println("Checking conditions for " + codClient);
		
	}

	@Override
	public void checkInsurance(int codClient) {
		System.out.println("Checking health insurance for " + codClient);
		
	}

}
