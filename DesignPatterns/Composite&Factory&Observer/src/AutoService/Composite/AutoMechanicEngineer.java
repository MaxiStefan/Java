package AutoService.Composite;

import java.util.ArrayList;

public class AutoMechanicEngineer extends AbstractNode {
	
	private String name;
	private ArrayList<AbstractNode> team;
	
	public AutoMechanicEngineer(String name) {
		this.name = name;
		this.team =  new ArrayList<AbstractNode>();
	}

	@Override
	public void switchTeams(AutoMechanicEngineer team1, AutoMechanicEngineer team2) {
		throw new UnsupportedOperationException();
	}	
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void addNode(AbstractNode node) {
		this.team.add(node);
	}

	@Override
	public void remove(String name) {
		AbstractNode reference = null;
		for(AbstractNode node : team) {
			if(node.getName().equals(name)) {
				reference = node;
			}
		}
		
		if(reference != null)
			this.team.remove(reference);
	}

	@Override
	public AbstractNode getNode(int index) {
		if(index > 0 && index < this.team.size())
			return this.team.get(index);
		else
			return null;
	}



	@Override
	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Auto Mechanic Engineer " + this.getName());
		if(team.size() != 0) {
			sb.append(" and his team: \n");
		}
		for(AbstractNode mechanic : team) {
			sb.append("\t" + mechanic.getInfo() + "\n");
		}
		
		return sb.toString();
	}


}
	
	
	
