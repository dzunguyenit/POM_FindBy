package pages;
import entilies.LoginEntilies;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilitys.ActionUtility;

public class LoginPage {
    private WebDriver driver;
    private ActionUtility waitU;

    /**
     * Element Login by Phone Number
     */
    @FindBy(how = How.XPATH, using = "//a[@title='Đăng nhập ngay']")
    protected WebElement logintbn;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Nhập số điện thoại']")
    protected WebElement phone;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Nhập mật khẩu']")
    protected WebElement pwd;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    protected WebElement submit;
    @FindBy(how = How.XPATH, using = "//div[@class='errorMessage']")
    protected WebElement error;
    @FindBy(how = How.XPATH, using = "//a[@class='sc-jKJlTe loXQau']")
    //a[@class='sc-jKJlTe loXQau']
    //div[@class='_15VgJROes5LE5HvjEuuj8i']
    protected WebElement weAcount;

    /**
     * Element Login by Facebook
     */
    @FindBy(how = How.XPATH, using = "//div[@class='form-group group-2']//button[1]")
    protected WebElement loginFB;
    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    protected WebElement useFB;
    @FindBy(how = How.XPATH, using = "//input[@id='pass']")
    protected WebElement pwdFB;
    @FindBy(how = How.XPATH, using = "//button[@id='loginbutton']")
    protected WebElement submitFB;
    @FindBy(how = How.XPATH, using = "//button[@id='loginbutton']")
    protected WebElement continueFB;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initComponents();
    }

    private void initComponents() {
        PageFactory.initElements(driver, this);
        waitU = new ActionUtility(driver);
    }

    /**
     * Method Login by Phone Number
     */

    public void clearAll() {
        phone.clear();
        pwd.clear();
    }

    public void loginBtnHome() {
        logintbn.click();
    }

    public void fillIn(LoginEntilies loginEntilies) {
        phone.sendKeys(loginEntilies.getUser());
        pwd.sendKeys(loginEntilies.getPwd());
    }

    public void submit() {
        submit.click();
    }

    public String getError_Incorrect_Phone_Pwd() {
        waitU.sleep(350);
        return error.getText();
    }

    /**
     * Method Login by Facebook
     */

    public void loginFB() {
        waitU.click(loginFB);
        //loginFB.click();
    }

    public void fillInFB(LoginEntilies loginEntilies) {
        useFB.sendKeys(loginEntilies.getUser());
        pwdFB.sendKeys(loginEntilies.getPwd());
    }

    public void submitFB() {
        waitU.click(submitFB);
    }

    public void continueFB() {
        waitU.waitUntilToBeClickAble(continueFB);
        waitU.click(continueFB);
    }

    /**
     * My account login success
     */

    public boolean isGuest() {
        try {
            weAcount.isDisplayed();
        } catch (NoSuchElementException ex) {
            return true;
        }
        return false;
    }
}