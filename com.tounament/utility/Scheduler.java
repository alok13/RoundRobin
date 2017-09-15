package utility;

import java.util.ArrayList;
import java.util.List;

import components.Match;
import components.Team;

public class Scheduler {

	public static List<List<Match>> generateScheduler(List<Match> listofFixtures) {
		List<List<Match>> scheduleList = new ArrayList<List<Match>>();
		List<Match> currentMatchList = new ArrayList<Match>();
		while (listofFixtures.size() > 0) {
			currentMatchList = getDayMatch(listofFixtures, currentMatchList);
			getFixture(currentMatchList, scheduleList);
		}
		return scheduleList;

	}

	private static List<Match> getDayMatch(List<Match> listofFixtures, List<Match> currentMatchList) {
		List<String> teamsNotPlaying = new ArrayList<String>();
		List<Match> dayMatch = new ArrayList<Match>();
		for (int i = 0; i < currentMatchList.size(); i++) {
			teamsNotPlaying.add(currentMatchList.get(i).getTeam1().getName());
			teamsNotPlaying.add(currentMatchList.get(i).getTeam2().getName());
		}

		Match match1 = listofFixtures.get(0);
		Match match2 = null;
		if (listofFixtures.size() > 1) {
			match2 = listofFixtures.get(1);
		}

		if (nextGamePossible(teamsNotPlaying, match1)) {
			dayMatch.add(match1);
			teamsNotPlaying.add(match1.getTeam1().getName());
			teamsNotPlaying.add(match1.getTeam2().getName());
			removeFixture(listofFixtures);

		}
		if (match2 != null && nextGamePossible(teamsNotPlaying, match2)) {
			dayMatch.add(match2);
			teamsNotPlaying.add(match2.getTeam1().getName());
			teamsNotPlaying.add(match2.getTeam2().getName());
			removeFixture(listofFixtures);
		}

		return dayMatch;
	}

	private static void removeFixture(List<Match> listofFixtures) {
		listofFixtures.remove(0);

	}

	private static boolean nextGamePossible(List<String> teamsNotPlaying, Match match) {

		return !teamsNotPlaying.contains(match.getTeam1().getName())
				&& !teamsNotPlaying.contains(match.getTeam2().getName());
	}

	private static void getFixture(List<Match> currentMatchList, List<List<Match>> scheduleList) {
		List<Match> daySchedule = new ArrayList<Match>();

		if (currentMatchList.isEmpty()) {
			daySchedule.add(new Match(new Team(TeamFactory.DUMMY), new Team(TeamFactory.DUMMY)));
			System.out.println("No match");
		} else {
			for (int i = 0; i < currentMatchList.size(); i++) {

				daySchedule.add(currentMatchList.get(i));
				System.out.println(currentMatchList.get(i));

			}

		}
		scheduleList.add(daySchedule);

	}

}
