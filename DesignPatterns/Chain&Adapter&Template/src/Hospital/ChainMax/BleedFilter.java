package Hospital.ChainMax;

public class BleedFilter extends AbstractPatientFilter {

	@Override
	public void processPatient(Patient patient) {
		if(patient.isBleeding)
			System.out.println("Sending " + patient.name + " to surgical unit.");
		else
		if(this.next != null)
			this.next.processPatient(patient);
	}

}
