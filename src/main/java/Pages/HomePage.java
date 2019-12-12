package Pages;

import PageLocators.HomePageLocators;
import Utilities.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    HomePageLocators homePageLocators = null;
    public HomePage(){
        this.homePageLocators = new HomePageLocators();
        PageFactory.initElements(DriverFactory.getDriver(), homePageLocators);
    }
    public void addRemoveElementclick(){
        homePageLocators.addRemoveElement.click();
    }
    public String verifyText(){
       return homePageLocators.headerText.getText();
    }
    public void BasicAuthLinkClick(){
        homePageLocators.basicAuthLink.click();
    }
}
