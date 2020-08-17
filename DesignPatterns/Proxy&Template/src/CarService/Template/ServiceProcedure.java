package CarService.Template;

public abstract class ServiceProcedure {
	int codMasina;

	public ServiceProcedure(int codMasina) {
		this.codMasina = codMasina;
	}
	
	public abstract void visualCheck(int codMasina);
	public abstract void exhaustCheck(int codMasina);
	public abstract void brakesCheck(int codMasina);
	public abstract void mechanicalPartsCheck(int codMasina);
	
	public final void serviceProcedure() {
		visualCheck(this.codMasina);
		exhaustCheck(this.codMasina);
		brakesCheck(this.codMasina);
		mechanicalPartsCheck(this.codMasina);

	}
}
