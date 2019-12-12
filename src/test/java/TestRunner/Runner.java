package TestRunner;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
//mvn test -Dcucumber.options=" --tags '@SmokeTest'" //Run from CMD
@CucumberOptions(
        strict = true,
        monochrome = true,
        features = {"src/test/features/"},
        glue = "StepDefinitions",
        plugin = {"pretty",
                "html:target/cucumber-html-report", "json:target/cucumber-report.json",                     //})
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})
public class Runner extends AbstractTestNGCucumberTests{
    @BeforeClass
    public static void setup() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
        Date curDate = new Date();
        String strDate = sdf.format(curDate);
        String fileName = System.getProperty("user.dir") + "/target/Extent_Reports/" + strDate + ".html";
        File newFile = new File(fileName);
//        ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile, false);
//
//        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));
//
//        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
//        ExtentCucumberFormatter.addSystemInfo("Browser version", "v.74.0");
//        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v.3.141.59");
//
//        Map systemInfo = new HashMap();
//        systemInfo.put("Cucumber version", "4.7.1");
//        systemInfo.put("Extent Cucumber Reporter version", "1.1.1");
//        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }
    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
