package Hospital.Adapter;

public abstract class AbstractUnconsciousPatient {
	protected String condition = "unconscious";
	protected String companionPersonName;
	
	public AbstractUnconsciousPatient(String companionPersonName) {
		this.companionPersonName = companionPersonName;
	}
	
	public abstract void getDescription();
}
