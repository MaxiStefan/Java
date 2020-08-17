
public class Test {

	public static void main(String[] args) {
		
		CaracterJoc superman = new CaracterJoc("Superman", 250);
		superman.esteLovit(100);
		MementoCaraterJoc supermanSave = superman.salvare();
		superman.esteLovit(250);
		System.out.println("" + superman.puncteViata);
		superman.reincarcaStare(supermanSave);
		System.out.println("" + superman.puncteViata);

	}

}
