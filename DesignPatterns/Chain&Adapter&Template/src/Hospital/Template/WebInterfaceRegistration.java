package Hospital.Template;

public class WebInterfaceRegistration extends PatientRegistration {

	public WebInterfaceRegistration(int codClient) {
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
