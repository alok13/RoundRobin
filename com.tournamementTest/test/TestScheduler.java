package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import components.Match;
import components.Team;
import utility.Scheduler;

public class TestScheduler {

	static List<Match> matches = new ArrayList<Match>();

	@BeforeClass
	public static void setUp() {
		matches.add(new Match(new Team(1), new Team(2)));
		matches.add(new Match(new Team(2), new Team(1)));
	}

	@Test
	public void testNumberofDayForTeams() {
		List<List<Match>> schedule = Scheduler.generateScheduler(matches);
		assert (schedule.size() == 3);
	}
}
