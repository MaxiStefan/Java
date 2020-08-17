package CosCumparaturi.Singleton;

public class ProduseVestimentare {
	CosCumparaturi cos;
	
	public ProduseVestimentare(String user) {
		cos = CosCumparaturi.getCos(user);
	}
}
