package ru.site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.site.steps.BaseSteps;

public class BasePage {


    public BasePage(){


        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


//    private Actions actions = new Actions(BaseSteps.getDriver());

    public void clickElement(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void visibilityElement(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitRefreshing(String str){
        ContributionsPage contributionsPage = new ContributionsPage();
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
        wait.until(driver -> {


            return !str.equals(contributionsPage.fieldCheck.getText());
        });
    }

}
