package ru.site;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.site.pages.BasePage;
import ru.site.pages.ContributionsPage;
import ru.site.steps.BaseSteps;
import ru.site.steps.ContributionsSteps;
import ru.site.steps.MainSteps;

public class AllureTest {
    private BaseSteps baseSteps = new BaseSteps();
    private MainSteps mainSteps = new MainSteps();
    private ContributionsSteps contributionsSteps = new ContributionsSteps();
    private ContributionsPage contributionsPage = new ContributionsPage();

    @Before
    public void setUp(){
        BaseSteps.setUp();
    }

    @Test
    public void siteTest() throws InterruptedException {
        BasePage basePage = new BasePage();
        baseSteps.goToUrl("https://rencredit.ru");

        mainSteps.clickContributions();

        contributionsSteps
                .selectСurrency("Рубли")
                .sendSumContr("300000")
                .selectMonth("9")
                .sensReplenish("50000")
                .clickCapital()
                .checkResults("18 056,35", "400 000", "718 056,35");

    }

    @After
    public void tearDown(){
        BaseSteps.tearDown();
    }
}
