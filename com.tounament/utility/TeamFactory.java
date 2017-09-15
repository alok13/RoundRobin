package utility;

import java.util.ArrayList;
import java.util.List;

import components.Team;
import exception.InsufficientTeamException;

public class TeamFactory {
	public final static String DUMMY = "-1";

	public static List<Team> createTeams(int numberofTeams) throws InsufficientTeamException {
		List<Team> teamList = new ArrayList<Team>();
		if (numberofTeams < 2)
			throw new InsufficientTeamException();
		else {
			for (int i = 1; i <= numberofTeams; i++) {
				teamList.add(new Team(i));
			}
		}
		if (numberofTeams % 2 != 0) {
			teamList.add(new Team(DUMMY));
		}
		return teamList;

	}
}
