package BDD;

//import cucumber.api.CucumberOptions;
//import cucumber.api.SnippetType;
//import cucumber.api.junit.Cucumber;
//import org.junit.runner.RunWith;


//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/features",
//        glue = "BDD",
//        tags = "@all",
//        dryRun = false,
//        strict = false,
//        snippets = SnippetType.UNDERSCORE)
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("BDD")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "BDD")
public class RunnerTest {
}
