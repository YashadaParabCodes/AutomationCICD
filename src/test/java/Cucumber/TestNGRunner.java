package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue="YashadaParabAutomation.stepdefination",
monochrome=true,tags="@ErrorMsg",plugin= {"html:target/Cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
