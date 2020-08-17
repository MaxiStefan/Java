package CarService.Template;

public class AutoServiceCluj extends ServiceProcedure {

	public AutoServiceCluj(int codMasina) {
		super(codMasina);
	}

	@Override
	public void visualCheck(int codMasina) {
		System.out.println("Visual Check of the car is done" + codMasina);
		
	}

	@Override
	public void exhaustCheck(int codMasina) {
		System.out.println("Doing the exhaust check of the car" + codMasina);
		
	}

	@Override
	public void brakesCheck(int codMasina) {
		System.out.println("Brakes for " + codMasina + " are good to go");
		
	}

	@Override
	public void mechanicalPartsCheck(int codMasina) {
		System.out.println("Doing the mechanical check of the car" + codMasina + ". All good!");
		
	}

}
