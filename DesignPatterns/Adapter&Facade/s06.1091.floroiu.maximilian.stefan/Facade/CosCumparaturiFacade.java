package Facade;

public class CosCumparaturiFacade {
	String numeClient;
	
	public CosCumparaturiFacade(String client) {
		this.numeClient = client;
	}
	
	public void proceduraFacade() {
		User user = new User(this.numeClient);
		user.creareUser("1234");
		
		Sesiune sesiune = new Sesiune();
		sesiune.setUser(user);
		sesiune.messageOfTheDay();
		
		ConexiuneBD con = new ConexiuneBD();
		con.conexiuneDB(user.nume);
		
		CosCumparaturi cos = new CosCumparaturi("ball");
		cos.finalizeazaComanda(255);
	}
}
