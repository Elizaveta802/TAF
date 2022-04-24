package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

import java.time.Duration;

public class Task_6 {

        private WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = new BrowsersService().getDriver();}//создает экземпляр хрома (открытие драйвера)

        @AfterMethod
        public void tearDown() {
            driver.quit();}//закрытие браузера

        @Test
        public void basicLocatorTest() {
            driver.get(ReadProperties.getUrl());

            // Find webElement by ID
            driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());

            // Find webElement by Name
            driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Поиск по className
            driver.findElement(By.cssSelector(".submit-button")).click();

            //Поиск по xpath
            driver.findElement(By.xpath("button[@data-test='add-to-cart-sauce-labs-backpack']")).click();




        }
    }
