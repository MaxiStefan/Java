package Hospital.ChainMax;

public class NoProblemsPatient extends AbstractPatientFilter {

	@Override
	public void processPatient(Patient patient) {
		System.out.println("Sending " + patient.name + " home.");
		
	}

}
