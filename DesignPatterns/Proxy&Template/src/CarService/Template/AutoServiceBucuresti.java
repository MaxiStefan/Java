package CarService.Template;

public class AutoServiceBucuresti extends ServiceProcedure {

	public AutoServiceBucuresti(int codMasina) {
		super(codMasina);
	}

	@Override
	public void visualCheck(int codMasina) {
		System.out.println("Doing the visual check of the car" + codMasina);
		
	}

	@Override
	public void exhaustCheck(int codMasina) {
		System.out.println("Doing the exhaust check of the car" + codMasina);
		
	}

	@Override
	public void brakesCheck(int codMasina) {
		System.out.println("Doing the brakes check of the car" + codMasina);
		
	}

	@Override
	public void mechanicalPartsCheck(int codMasina) {
		System.out.println("Doing the mechanical check of the car" + codMasina);
		
	}

}
