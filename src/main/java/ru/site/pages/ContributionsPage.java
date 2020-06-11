package ru.site.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContributionsPage extends BasePage {
    public static final String contributionsTemplate = "//span[@class='calculator__currency-field-text'][contains(text(), '%s')]";

    @FindBy(xpath = "//input[@name='amount']")
    public WebElement sumContr;

    @FindBy(xpath = "//div[@class='jq-selectbox__select']/preceding-sibling::select")
    public WebElement selectMonth;

    @FindBy(xpath = "//input[@name='replenish']")
    public WebElement replenish;

    @FindBy(xpath = "//input[@name='capitalization']/..")
    public WebElement capital;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    public WebElement fieldProcent;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    public WebElement fieldReplenish;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    public WebElement fieldTakeCash;

    @FindBy(xpath = "//span[@class='js-calc-result js-calc-result-noanim']")
    public WebElement fieldCheck;

    @FindBy(xpath = "//span[@class='js-calc-currency']")
    public WebElement value;






}
