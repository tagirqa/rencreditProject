package ru.site.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='service__title-text'][contains(text(), 'Вклады')]/..")
    public WebElement menuContribution;
}
