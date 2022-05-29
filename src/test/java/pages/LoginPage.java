package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Блок описания селекторов для элементов
    private By emailInputLocator = By.id("name");
    private By pswInputLocator = By.id("password");
    private By logInButtonLocator = By.id("button_primary");
    private By errorTextLocator = By.className("error-text");

    // Блок иницализации драйвера
    public LoginPage(WebDriver driver) {
        super(driver);//опракидывание драйвера
    }

    @Override//(активна ли страница в данный момент)
    protected By getPageIdentifier() {
        return emailInputLocator;//вернуть эл-т для контретно этой страницы(возвращаем локатор)
    }

    // Блок атомарных методов
    public WebElement getEmailInput() {
        return driver.findElement(emailInputLocator);}//создать метод, возвращают вебэлемент, отдать наружу

    public WebElement getPswInput() {
        return driver.findElement(pswInputLocator);
    }

    public WebElement getLogInButton() {
        return driver.findElement(logInButtonLocator);
    }

    public WebElement getErrorTextElement() {
        return driver.findElement(errorTextLocator);
    }
}
