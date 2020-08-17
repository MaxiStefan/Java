package Hospital.ChainMax;

public class TempFilter extends AbstractPatientFilter {

	@Override
	public void processPatient(Patient patient) {
		if(patient.temperature >= 40)
			System.out.println("Asking a general doctor to investigate " + patient.name + " further.");
		else
		if(this.next != null)
			this.next.processPatient(patient);
	}

}
