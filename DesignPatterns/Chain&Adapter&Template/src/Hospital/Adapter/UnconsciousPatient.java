package Hospital.Adapter;

public class UnconsciousPatient extends AbstractUnconsciousPatient{

	public UnconsciousPatient(String companionPersonName) {
		super(companionPersonName);
	}

	@Override
	public void getDescription() {
		System.out.println("Patient's companion is " + this.companionPersonName + " and has " + this.condition);
		
	}

}
