package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;
import java.util.List;

public class ActionsTestPractica extends BaseTest {

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);//класс Actions
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElements = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));//получить все элементы по локатору в виде массива
        actions
                .moveToElement(targetElements.get(0), 10, 10)
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()//создает объект на основании ваших предыдущих параметров(собирает объект)
                .perform();//начинаем выполненять
              //.click(WebElement target) - клик с конечным элементом
        //moveByOffset - смещение вверх вниз
        //clickAndHold - нажать и удерживать(находишься на нужном элементе)
        //contextClick - нажатие правой кнопки мыши
        //contextClick(WebElement target) - нажатие правой кнопки мыши c конечным элементом
        //doubleClick - двойной клик правой кнопкой мыши
        //dragAndDropBy -перетаскивание
        //keyDown(Keys.Left_CONTROL) - нажать клавишу LEFT CONTROL
        //keyDown(A) - нажать клавишу А
        //keyUp - отпустить клавишу
        //release - отпустить клашиву

        Thread.sleep(2000);
    }

    @Test
    public void ContextMenuTest() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);//класс Actions
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("You selected a context menu");
        alert.accept();


        WebElement targetElement = wait.waitForVisibilityLocatorBy(By.id("hot-spot"));
        actions

                .contextClick(targetElement);
    }
}
