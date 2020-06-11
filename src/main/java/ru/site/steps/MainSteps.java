package ru.site.steps;

import cucumber.api.java.en.When;
import ru.site.pages.MainPage;

public class MainSteps {

    @When("переходим в меню - вклады")
    public void clickContributions(){
        MainPage mainPage = new MainPage();
        mainPage.menuContribution.click();
    }
}
