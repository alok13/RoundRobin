package application;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import components.Match;
import components.Team;
import exception.InsufficientTeamException;
import utility.DisplaySchedule;
import utility.FixturesGenerator;
import utility.TeamFactory;
import utility.Scheduler;

@Path("/tournamment")
public class SchedulerService {

	@GET
	@Path("/schedule")
	@Produces("text/plain")
	public String sheduleTournament(@QueryParam("team") Integer numberofTeams) {

		List<Team> teamList;
		try {
			teamList = TeamFactory.createTeams(numberofTeams);
		} catch (InsufficientTeamException e) {
			return "Match not possbile with given number of teams";
		}
		List<Match> matchList = FixturesGenerator.createFixture(teamList);
		List<List<Match>> schedule = Scheduler.generateScheduler(matchList);
		String result = DisplaySchedule.display(schedule);
		return result;
	}

}
