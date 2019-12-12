package StepDefinitions;

import Utilities.DriverFactory;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class StepHooks {
    @Before
    public void setup(){
        DriverFactory.setUpDriver("chrome");
    }
    @After
    public void tearDown(Scenario sc){
        WebDriver driver = DriverFactory.getDriver();
        System.out.println(sc.isFailed());
        if(sc.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(
                    OutputType.BYTES);
            sc.embed(screenshotBytes, "image/png");

        }
        DriverFactory.tearDown();
    }
}
