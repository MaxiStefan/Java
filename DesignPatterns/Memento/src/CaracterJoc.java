
public class CaracterJoc {
	String nume;
	int puncteViata;
	
	public CaracterJoc(String nume, int puncteViata) {
		super();
		this.nume = nume;
		this.puncteViata = puncteViata;
	}
	
	public void merge() {
		System.out.println(this.nume);
	}
	
	public void ataca(String inamic, int puncteAtac) {
		System.out.println(this.nume);
	}
	
	public void esteLovit(int puncte) {
		System.out.println("Este lovit cu " + puncte);
		this.puncteViata -= puncte;
	}
	
	public void seVindecaTotal() {
		this.puncteViata = 1000;
	}
	
	
	public MementoCaraterJoc salvare() {
		return new MementoCaraterJoc(this.nume, this.puncteViata);
	}
	
	public void reincarcaStare(MementoCaraterJoc salvareAnterioara) {
		this.nume = salvareAnterioara.getNume();
		this.puncteViata = salvareAnterioara.getPuncteViata();
	}
}
