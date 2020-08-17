package ro.ase.csie.cts.Singleton;

public class ProfileModule {
	
	DBConnection con;
	
	public ProfileModule() {
		con = DBConnection.getConnection();
		DBConnection localCon = DBConnection.getConnection("10.0.0.1","Settings", "dev");
	}
}
