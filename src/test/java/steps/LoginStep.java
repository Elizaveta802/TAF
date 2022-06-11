package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    //функциональная составляющая

    public LoginStep(WebDriver driver) {
        super(driver);//опракидывание драйвера
    }

    public DashboardPage successLogin(String email, String psw) {
        login(email, psw);

        return dashboardPage;
    }

    public LoginPage incorrectLogin(String email, String psw) {
        login(email, psw);

        return loginPage;
    }

    private void login(String email, String psw) {
        loginPage.emailInput.sendKeys(email);
        loginPage.pswInput.sendKeys(psw);
        loginPage.logInButton.click();
    }

    public LoginPage logout() {

        return loginPage;
    }
}
