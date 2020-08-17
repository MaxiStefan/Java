package AutoService.Composite;

public abstract class AbstractNode {
	
	public abstract String getName();
	public String getInfo() {
		return this.getName();
	}
	
	public abstract void switchTeams(AutoMechanicEngineer team1, AutoMechanicEngineer team2);

	public void addNode(AbstractNode node) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(String name){
		throw new UnsupportedOperationException();
	}
	
	public AbstractNode getNode(int index) {
		throw new UnsupportedOperationException();
	}
}
