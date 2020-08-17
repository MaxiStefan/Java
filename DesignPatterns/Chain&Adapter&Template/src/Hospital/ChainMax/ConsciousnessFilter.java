package Hospital.ChainMax;

public class ConsciousnessFilter extends AbstractPatientFilter {

	@Override
	public void processPatient(Patient patient) {
		if(patient.isUnconscious)
			System.out.println("Sending " + patient.name + " to neurology.");
		else
		if(this.next != null)
			this.next.processPatient(patient);
	}

}
