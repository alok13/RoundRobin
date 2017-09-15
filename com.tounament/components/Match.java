package components;

import utility.TeamFactory;

public class Match {
	private Team team1;
	private Team team2;

	@Override
	public String toString() {
		if (team1.getName().equals(TeamFactory.DUMMY) || team2.getName().equals(TeamFactory.DUMMY)) {
			return "No match today";
		}
		return "Match at " + team1 + " home between " + team1 + " and" + team2;
	}

	public Match() {
		this.team1 = null;
		this.team2 = null;
	}

	public Match(Team team1, Team team2) {
		super();
		this.team1 = team1;
		this.team2 = team2;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

}
