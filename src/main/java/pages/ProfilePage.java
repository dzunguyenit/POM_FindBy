package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilitys.ActionUtility;

public class ProfilePage {
    private WebDriver driver;
    private ActionUtility waitU;

    @FindBy(how = How.XPATH, using = "//a[@id='btnMenuMore']//img[@class='sc-bxivhb bUZGRr']")
    protected WebElement menuMore;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Đăng xuất')]")
    protected WebElement logout;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        initComponents();
    }

    private void initComponents() {
        PageFactory.initElements(driver, this);
        waitU = new ActionUtility(driver);
    }

    public void logout() {
        waitU.waitUntilToBeClickAble(menuMore);
        menuMore.click();
        logout.click();
    }
}