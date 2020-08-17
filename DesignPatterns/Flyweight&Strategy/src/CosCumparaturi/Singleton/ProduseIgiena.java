package CosCumparaturi.Singleton;

public class ProduseIgiena {
	CosCumparaturi cos;
	
	public ProduseIgiena(String user) {
		cos = CosCumparaturi.getCos(user);
	}
}
