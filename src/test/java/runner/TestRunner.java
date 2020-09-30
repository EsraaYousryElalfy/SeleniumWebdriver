package runner;

import cucumber.api.CucumberOptions;
import tests.TestBase;

// to run feature file using steps in file by pretty design with file name "cucumber html report in target folder"
@CucumberOptions(features="src/test/java/features",
glue= {"stepDefinition"},
plugin={"pretty","html:target/cucumber-reports"})
public class TestRunner extends TestBase{

}
