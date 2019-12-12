package PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
    @FindBy(linkText = "Add/Remove Elements")
    public WebElement addRemoveElement;
    @FindBy(linkText = "Basic Auth")
    public WebElement basicAuthLink;
    @FindBy(tagName = "h3")
    public WebElement headerText;
}
