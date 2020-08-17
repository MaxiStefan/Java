package Hospital.Adapter;

public class AdapterUnconsciousPatient implements PatientDescriptionInterface {
	AbstractUnconsciousPatient patient = null;
	
	public AdapterUnconsciousPatient(AbstractUnconsciousPatient patient) {
		this.patient = patient;
	}

	@Override
	public void getDescription() {
		patient.getDescription();
		
	}

}
