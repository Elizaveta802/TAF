package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitialPage {
    private WebDriver driver;

    //Блок описания селекторов для элементов

    @FindBy(css = "#gk-cookie-proceed")
    public WebElement cookieButton;
    @FindBy(linkText = "Try for Free")
    public WebElement tryForFreeButton;

    //Блок инициализации
    public InitialPage(WebDriver driver) {
        this.driver = driver;
    }
}

