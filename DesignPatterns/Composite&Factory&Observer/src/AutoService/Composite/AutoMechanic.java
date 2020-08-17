package AutoService.Composite;


public class AutoMechanic extends AbstractNode {
	private String name;
	
	public AutoMechanic(String name) {
		this.name = name;
	}

	@Override
	public void switchTeams(AutoMechanicEngineer team1, AutoMechanicEngineer team2) {
		System.out.println(name + " joined team " + team2.toString());
		team1.remove(this.name);
		team2.addNode(this);
		
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	
	

}
