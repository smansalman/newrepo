package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Features", // features tells Cucumber options where features are located
		glue = { "stepDefinitions" }, // glue tells cucumber options where Step Definitions are located
		tags = {"@TestScenario"}, 
		dryRun = false, //dry run if sets to false it will scan all steps in scenario and scenario outline to find associated steps 
				// step definitions in step definitions class. if steps are missing it will print out them in console
		monochrome = true, // if set to true, makes the console output readable.
		strict = false, // if set to false will fail if there are pending undefined steps.
		format = {"pretty",
		        "html:target/cucumber-reports/cucumber-pretty",
		        "json:target/cucumber-reports/CucumberTestReport.json",
		        "rerun:target/cucumber-reports/rerun.txt"		
		},
		plugin = "json:target/cucumber-reports/CucumberTestReport.json"
)

public class TestRunner {
	

}
