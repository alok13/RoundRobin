package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import components.Team;
import exception.InsufficientTeamException;

import utility.TeamFactory;

public class TestTeamFactory {

	static List<Team> team = new ArrayList<Team>();

	@Test(expected = InsufficientTeamException.class)
	public void testExpcetionForTeamFactory() throws InsufficientTeamException {
		TeamFactory.createTeams(0);

	}
}
