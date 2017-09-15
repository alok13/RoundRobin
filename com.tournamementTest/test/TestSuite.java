package test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestFixtureGenerator.class, 
	TestScheduler.class,
	TestTeamFactory.class
})
public class TestSuite {
	//normally, this is an empty class
}