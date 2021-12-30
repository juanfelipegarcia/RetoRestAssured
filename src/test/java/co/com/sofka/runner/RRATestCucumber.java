package co.com.sofka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "co.com.sofka.stepdefinition",
        features = {"src/test/resources/features/Get.feature",
                    "src/test/resources/features/Post.feature"},
        publish = true
)



public class RRATestCucumber {
}
