import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // Instructs JUnit to use Cucumber as the test runner
@CucumberOptions(
        features = "src/test/resources/features",  // Path to the feature files
        glue = "stepDefs",                         // Package where step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Plugins for formatted console output and an HTML report
        monochrome = true                          // Clean and readable console output
)
public class RunCucumberTest {
    // This class is needed to run all your Cucumber scenarios as JUnit tests.
    // It initiates the execution of all scenarios in the feature files that match the step definitions.
}
