package utility;

import java.util.ArrayList;
import java.util.List;

import components.Match;
import components.Team;

public class FixturesGenerator {

	public static List<Match> createFixture(List<Team> listofTeam) {
		List<Match> homeMatchList = new ArrayList<Match>();
		List<Match> awayMatchList = new ArrayList<Match>();

		// Creating a second list keeping first fixed and rotating it.
		List<Team> movingList = new ArrayList<Team>();
		movingList.addAll(listofTeam);
		movingList.remove(0);

		Team fixedTeam = listofTeam.get(0);

		int numberofDays = (listofTeam.size() - 1);

		int halfSize = listofTeam.size() / 2;

		int teamsSize = movingList.size();

		// Generating the schedule for fixed team with other teams
		for (int day = 0; day < numberofDays; day++) {

			Team teamAgainstFixed = movingList.get(day % teamsSize);

			if (isValidmatch(teamAgainstFixed, fixedTeam)) {
				homeMatchList.add(new Match(teamAgainstFixed, fixedTeam));
				awayMatchList.add(new Match(fixedTeam, teamAgainstFixed));

			}

			for (int i = 1; i < halfSize; i++) {
				Team firstTeam = movingList.get((day + i) % teamsSize);
				Team secondTeam = movingList.get((day + teamsSize - i) % teamsSize);

				if (isValidmatch(firstTeam, secondTeam)) {
					homeMatchList.add(new Match(firstTeam, secondTeam));
					awayMatchList.add(new Match(secondTeam, firstTeam));

				}
			}
		}

		homeMatchList.addAll(awayMatchList);

		return homeMatchList;

	}

	private static boolean isValidmatch(Team firstTeam, Team secondTeam) {
		return !isDummy(firstTeam) && !isDummy(secondTeam);

	}

	private static boolean isDummy(Team team) {
		return team.getName().equals(String.valueOf(TeamFactory.DUMMY));
	}

}
