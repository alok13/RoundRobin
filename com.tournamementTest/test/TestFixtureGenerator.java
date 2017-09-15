package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import components.Match;
import components.Team;
import utility.FixturesGenerator;

public class TestFixtureGenerator {

	static List<Team> team = new ArrayList<Team>();

	@BeforeClass
	public static void setUp() {
		team.add(new Team(1));
		team.add(new Team(2));
	}

	@Test
	public void testNumberofDayPositive() {
		List<Match> matchList = FixturesGenerator.createFixture(team);
		assert (matchList.size() == 2);
	}
}
