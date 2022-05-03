package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SwagLabsHW {

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

            driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());

            driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

            driver.findElement(By.cssSelector(".submit-button")).click();

            driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();

            driver.findElement(By.cssSelector(".shopping_cart_link")).click();

            WebElement basketButton = driver.findElement(By.cssSelector("div.inventory_item_price"));
            Assert.assertEquals(basketButton.getText(), "$29.99");

            WebElement itemName = driver.findElement(By.cssSelector(".inventory_item_name"));
            Assert.assertEquals(itemName.getText(), "Sauce Labs Backpack");
        }
    }

