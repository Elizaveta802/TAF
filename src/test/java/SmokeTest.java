import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.Keys.DELETE;

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
        heatLoss.sendKeys("40000");
        button.click();

        Thread.sleep(3000);
        WebElement heatingCablePower = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(heatingCablePower.getAttribute("value"), "22260");
        WebElement specificPowerOfHeatingCable = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(specificPowerOfHeatingCable.getAttribute("value"), "28");
        //driver.close();
    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");

        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);

        selectSex.selectByIndex(1);
        Thread.sleep(3500);
        //selectSex.selectByValue("0");
        //Thread.sleep(2000);
        //selectSex.selectByVisibleText("женский");
        //Thread.sleep(2000);
        WebElement creatinine = driver.findElement(By.cssSelector("[name='nCr']"));
        creatinine.sendKeys("80");
        WebElement age = driver.findElement(By.id("oAge"));
        age.sendKeys("38");
        WebElement oWeight = driver.findElement(By.id("oWeight"));
        oWeight.sendKeys("55");
        WebElement growth = driver.findElement(By.id("oHeight"));
        growth.sendKeys("163");
        WebElement buttonCalculate = driver.findElement(By.cssSelector("[value='Рассчитать']"));
        buttonCalculate.click();
        WebElement result1 = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(result1.getText(), "MDRD: 74 (мл/мин/1,73кв.м)");
        WebElement result2 = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(result2.getText(), "ХБП: 2 стадия (при наличии почечного повреждения)");
        WebElement result3 = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(result3.getText(), "Cockroft-Gault: 70 (мл/мин)");
        WebElement result4 = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(result4.getText(), "Поверхность тела:1.58 (кв.м)");
        //driver.close();
    }

    @Test
    public void laminateCalculator() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        //Thread.sleep(2000);

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
        roomLength.sendKeys("500");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
        roomWidth.sendKeys("400");

        WebElement LaminatePanelLength = driver.findElement(By.id("ln_lam_id"));
        LaminatePanelLength.sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
        LaminatePanelLength.sendKeys("2000");

        WebElement laminatePanelWidth = driver.findElement(By.id("wd_lam_id"));
        laminatePanelWidth.sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
        laminatePanelWidth.sendKeys("200");

        WebElement laminateDirection = driver.findElement(By.cssSelector("[for='direction-laminate-id1']"));
        laminateDirection.click();

        WebElement calculateLaminate = driver.findElement(By.cssSelector("[class='calc-btn']"));
        calculateLaminate.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement result5 = driver.findElement(By.cssSelector("[class='calc-result'] div:first-child"));
        Assert.assertEquals(result5.getText(), "Требуемое количество досок ламината: 53");

        WebElement result6 = driver.findElement(By.cssSelector("[class='calc-result'] div:nth-child(2)"));
        Assert.assertEquals(result6.getText(), "Количество упаковок ламината: 7");




    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
