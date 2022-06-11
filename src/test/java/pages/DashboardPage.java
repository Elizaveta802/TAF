package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";//

    public TopMenuPage topMenuPage;

    // Блок описания селекторов для элементов
    @FindBy(xpath = "//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]")
    public WebElement headerTitleLabel;
    @FindBy(xpath = "//a[contains(@class, 'sidebar-button') and contains(text(), 'Add Project')]")
    public WebElement addProject;
    @FindBy(xpath = "//a[contains(@style, 'padding-left: 25px') and contains(text(), 'New project')]")
    public WebElement nameProject;
    @FindBy(xpath = "//a[contains(@style, 'padding-left: 25px') and contains(text(), 'My Project')]")
    public WebElement nameProjectMyProjectOnDashboard;


    //Блок инициализации драйвера
    public DashboardPage(WebDriver driver) {
        super(driver);//вызываем конструктор из базового пейджа с передачей в него драйвера

        topMenuPage = new TopMenuPage(driver);
    }

    @Override//(активна ли страница в данный момент, открылась ли страница )
    protected WebElement getPageIdentifier() {
        return headerTitleLabel;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
