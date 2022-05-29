package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InitialPage {
    private WebDriver driver;

    //Блок описания селекторов для элементов

    private By cookieButtonLocator = By.cssSelector("#gk-cookie-proceed");
    private By tryForFreeButtonLocator = By.linkText("Try for Free");

    //Блок инициализации

    public InitialPage(WebDriver driver) {

        this.driver = driver;
    }

    //Блок атомарных методов

    public WebElement getCookieButton(){
        return driver.findElement(cookieButtonLocator);
    }

    public WebElement getTryForFreeButton(){
        return driver.findElement(tryForFreeButtonLocator);
    }

}

