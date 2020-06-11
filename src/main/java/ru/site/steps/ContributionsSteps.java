package ru.site.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.site.pages.BasePage;
import ru.site.pages.ContributionsPage;



public class ContributionsSteps {

    @When("выбираем: {string}")
    public ContributionsSteps selectСurrency(String currency){
        By locator = By.xpath(String.format(ContributionsPage.contributionsTemplate, currency));
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(locator));
        BaseSteps.getDriver().findElement(locator).click();
        return this;
    }
    @When("сумма вклада = {string}")
    public ContributionsSteps sendSumContr(String sum){
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.sumContr.sendKeys(sum);
        return this;
    }

    @When("срок = {string} мес.")
    public ContributionsSteps selectMonth(String month){
        ContributionsPage contributionsPage = new ContributionsPage();
        Select select = new Select(contributionsPage.selectMonth);
        select.selectByValue(month);
        return this;
    }

    @When("ежемесячное пополнение {string}")
    public ContributionsSteps sensReplenish(String sum){
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.replenish.sendKeys(sum);
        return this;
    }

    @When("отмечаем – ежемесячная капитализация")
    public ContributionsSteps clickCapital(){
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.capital.click();
        return this;
    }

    @Then("сверяем рассчеты: начислено % - {string}, пополнение за месяцы - {string}, к снятию - {string}")
    public ContributionsSteps checkResults(String procentSum, String replenish, String cash)  {

        BasePage basePage = new BasePage();

        ContributionsPage contributionsPage = new ContributionsPage();
        String price = contributionsPage.fieldProcent.getText();
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(contributionsPage.fieldProcent));
        basePage.waitRefreshing(price);
        Assert.assertEquals("Сумма не сходится",
                procentSum,
                contributionsPage.fieldProcent.getText());

        Assert.assertEquals("Сумма не сходится",
                replenish,
                contributionsPage.fieldReplenish.getText());

        Assert.assertEquals("Сумма не сходится",
                cash,
                contributionsPage.fieldTakeCash.getText());

        return this;
    }






}
