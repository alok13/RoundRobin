package application;

import java.util.List;

import components.Match;
import components.Team;
import exception.InsufficientTeamException;
import utility.FixturesGenerator;
import utility.TeamFactory;
import utility.Scheduler;
/*
 * Application to get the schedule without rest service
 * 
 */

public class Main {

	public static void main(String[] args) throws InsufficientTeamException {
		int n = 2;
		List<Team> teams = TeamFactory.createTeams(n);
		List<List<Match>> list = Scheduler.generateScheduler(FixturesGenerator.createFixture(teams));

	}

}
