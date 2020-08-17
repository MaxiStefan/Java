package ro.ase.csie.cts;

import ro.ase.csie.cts.Builder.SuperHero;
import ro.ase.csie.cts.Singleton.DBConnection;
import ro.ase.csie.cts.Singleton.ProfileModule;
import ro.ase.csie.cts.Singleton.SettingsModule;

public class TestGameClient {
	public static void main(String[] args) {
		
		//Singleton
		
		DBConnection dbCon = DBConnection.getConnection();
		
		SettingsModule settings = new SettingsModule();
		ProfileModule profile = new ProfileModule();

		
		//Builder
/*		//create & init
		SuperHero superman = 
				new SuperHero("Superman", 1000, true, false, "", "", "Fly", "");
		SuperHero batman = 
				new SuperHero("Batman", 1000, true, false, "", "", "", "");
		
		
		
		//1. create
		SuperHero joker = 
				new SuperHero();
		//2. init
		//TO DO: don't forget to init the attributes
		joker.setPositive(false);
		//.....
*/
		
		//create & init
		SuperHero superman = 
				new SuperHero.SuperHeroBuilder("Superman", 1000)
				.isPositive()
				.setSuperPower("Fly")
				.build();
		
		SuperHero joker = 
				new SuperHero.SuperHeroBuilder("Joker", 1000)
				.isNegativeCharacter()
				.setSuperPower("Fly")
				.setRightHandWeapon("Pistol")
				.build();
		
		//superman.setPositive(true);
		
	}
}
