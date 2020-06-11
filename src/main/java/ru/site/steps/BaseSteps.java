package ru.site.steps;

import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.site.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriverWait wait;

    public static void setUp(){
        Properties properties = TestProperties.getInstance().getProperties();

        String browser = properties.getProperty("browser", "chrome");
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

    }

    @When("переходим по ссылке {string}")
    public void goToUrl(String url){

        driver.get(url);
    }

    public static void tearDown(){
        driver.quit();
    }
}
