package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {//конструктор
        this.driver = driver;//конструктор
    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();//
    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}
