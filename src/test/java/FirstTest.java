import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest {

    private WebDriver driver;

    @Test
    public void browserTests() {
        SimpleDriver simpleDriver = new SimpleDriver();
        driver = simpleDriver.getDriver();

    }

    //@Test
    //public void advancedTests() {
        //AdvancedDriver simpleDriver = new AdvancedDriver();
        //driver = simpleDriver.getDriver();

    //}

    @Test//топчик_будем использовать
    public void browserServiceTests() {
        BrouserService brouserService = new BrouserService();
        driver = brouserService.getDriver();

    }
}
