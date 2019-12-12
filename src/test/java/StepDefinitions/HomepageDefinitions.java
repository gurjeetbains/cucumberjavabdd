package StepDefinitions;

import Pages.HomePage;
import Utilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomepageDefinitions {
    HomePage homePage = new HomePage();
    @Given("^I am on ([^\"]*)$")
    public void open_page(String link){
        DriverFactory.openPage(link);
        System.out.println("Given ran");
    }
    @When("I click on \"link 1\"$")
    public void test_text(){
        homePage.addRemoveElementclick();
        System.out.println("When ran");
    }
    @Then("^The page opens and I ([^\"]*) text$")
    public void finish_clicked(String verify){
        Assert.assertEquals(verify, homePage.verifyText(), "We are at right page");
        System.out.println("Then Ran");
    }
}
