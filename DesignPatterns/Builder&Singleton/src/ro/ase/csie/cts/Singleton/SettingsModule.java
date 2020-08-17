package ro.ase.csie.cts.Singleton;

public class SettingsModule {
	
	DBConnection con;
	
	public SettingsModule() {
		//con = DBConnection.getConnection();
		con = DBConnection.getConnection("10.0.0.1","Settings", "dev");
	}

}
