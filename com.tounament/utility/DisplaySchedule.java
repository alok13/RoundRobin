package utility;

import java.util.List;

import components.Match;

public class DisplaySchedule {

	public static String display(List<List<Match>> schedule) {
		String match = "";
		int day = 1;
		for (int i = 0; i < schedule.size(); i++) {

			match = match + "Day: " + (day + i) + "\n";
			List<Match> matchList = schedule.get(i);
			for (Match m : matchList) {
				match = match + m.toString() + "\n";
			}
		}
		return match;

	}

}
