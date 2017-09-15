package components;

public class Team {

	private String name;

	public Team(int name) {
		this.name = Integer.toString(name);
	}

	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team " + name;
	}

}
