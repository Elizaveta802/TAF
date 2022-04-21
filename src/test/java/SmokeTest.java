import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrouserService brouserService = new BrouserService();
        driver = brouserService.getDriver();

    }
    @Test
    public void CalculatorOfTheTotalThermalFloor() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement weight = driver.findElement(By.id("el_f_width"));
        WebElement length = driver.findElement(By.id("el_f_lenght"));
        WebElement buttonRoom = driver.findElement(By.id("room_type"));
        WebElement kitchenOrBedroom = driver.findElement(By.cssSelector("#room_type option[value='2']"));
        WebElement buttonHeatingType = driver.findElement(By.id("heating_type"));
        WebElement heatingForComfort = driver.findElement(By.cssSelector("#heating_type option[value='3']"));
        WebElement heatLoss = driver.findElement(By.id("el_f_losses"));
        WebElement button = driver.findElement(By.className("buttHFcalc"));


        //height.sendKeys(Keys.END); эмуляция  нажатия стандартных клавишь типа F12 и др

        weight.sendKeys("40");
        length.sendKeys("20");
        kitchenOrBedroom.click();
        buttonRoom.click();
        buttonHeatingType.click();
        heatingForComfort.click();
        heatLoss.sendKeys("10");
        button.click();

        Thread.sleep(3000);
        WebElement result = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(result.getText(), "6");
    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");


        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);



        selectSex.selectByIndex(1);
        Thread.sleep(2000);
        selectSex.selectByValue("0");
        Thread.sleep(2000);
        selectSex.selectByVisibleText("мужской");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
