package Hospital.ChainMax;

public abstract class AbstractPatientFilter {
	
	AbstractPatientFilter next;
	
	public void setNext(AbstractPatientFilter next) {
		this.next = next;
	}
	
	public abstract void processPatient(Patient patient);
}
