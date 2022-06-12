package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    public TopMenuPage topMenuPage;//появление страницы топ меню

    // Блок описания селекторов для элементов
    private By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'All Projects')]");
    private By addProjectLocator = By.xpath("//a[contains(@class, 'sidebar-button') and contains(text(), 'Add Project')]");
    private By nameProjectLocator = By.xpath("//a[contains(@style, 'padding-left: 25px') and contains(text(), 'New project')]");
    private By nameProjectMyProjectOnDashboardLocator = By.xpath("//a[contains(@style, 'padding-left: 25px') and contains(text(), 'My Project')]");


    //Блок инициализации драйвера
    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitleLabel() {
        return driver.findElement(headerTitleLabelLocator);
    }

    public WebElement getAddProject(){
        return driver.findElement(addProjectLocator);
    }

    public WebElement getNameProject(){
        return driver.findElement(nameProjectLocator);
    }

    public WebElement getNameProjectMyProjectOnDashboard(){
        return driver.findElement(nameProjectMyProjectOnDashboardLocator);
    }

    //блок комплексных методов

    public ProjectsPage openProject(String projectName){
        //Todo: implement actions
        return new ProjectsPage(driver);
    }
}
