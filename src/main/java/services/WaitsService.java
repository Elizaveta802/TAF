package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitsService {
    private WebDriverWait wait;

    public WaitsService(WebDriver driver, Duration timeout) {
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibility(WebElement element){//хочу дождаться визуализации элемента
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForVisibilityLocatedBy(By locator){//хочу дождаться визуализации элемента по локатору
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public List<WebElement> waitForAllVisibilityLocatedBy(By locator){//он находит все элементы отображаемые по локатору и возвращает коллекцию
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForExists(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForElementInvisible(WebElement element) {//невидимость элемента
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }


}

