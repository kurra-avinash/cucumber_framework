package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = true,
features = {".\\Feature\\ERP.feature"},monochrome = true,glue = {"stepDefination"})

public class AppTest extends AbstractTestNGCucumberTests{

}
