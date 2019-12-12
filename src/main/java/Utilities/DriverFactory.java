package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverFactory {//This returns a WebDriver instance

    private static DriverFactory seleniumDriver;
    private static WebDriver driver;
    private static WebDriverWait waitDriver;
    private static String cwd = System.getProperty("user.dir") + "\\src\\drivers\\";
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    private DriverFactory(String browser) {
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",cwd+"geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver",cwd+"chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver(String browser) {
        if(seleniumDriver == null) {
            seleniumDriver = new DriverFactory(browser);
        }
    }

    public static void tearDown() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
}
