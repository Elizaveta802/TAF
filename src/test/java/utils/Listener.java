package utils;

import baseEntities.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult tr) {
        Object currentClass = tr.getInstance();//получаем текущий инстс
        try {
            WebDriver driver = ((BaseTest) currentClass).driver;//забираем драйвер
            byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);//сделать скриншот
            saveScreenshot(srcFile);//сохраняем в какой-то файл
        } catch (Exception ex) {

        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")//сохраняет в виде картинки в image/png, создает линку
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
