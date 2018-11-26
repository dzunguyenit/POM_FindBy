package setup;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class SetupBrowser {
    public static WebDriver driver;
    private String homeURL;
    private String browserType;

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("in before suite");
        initBrowser();
    }

    @BeforeClass
    public void beforeClass() {
        try {
            System.out.println("in before class");
            preCondition();
        } catch (Exception e) {
        }
    }

    @BeforeMethod
    public void setUpBeforeMethod() {
        System.out.println("in before method");
    }

    @AfterMethod
    public void cleanOrKeepTrack() {
        System.out.println("in after method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("in after class");
    }

    @AfterSuite
    public void clearUp() {
        System.out.println("in after suite");
        killWebDriver();
    }

    public void preCondition() {
        //
    }

    /**
     * Parse file JSON to data
     */
    JSONObject jsonObjectForm;

    private void initComponents() {
        try {
            this.jsonObjectForm = this.parseContent("\\data\\Configuration.json");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public JSONObject parseContent(String dir) throws Exception {
        File file = new File(System.getProperty("user.dir") + dir);
        String content = FileUtils.readFileToString(file, "utf-8");
        return new JSONObject(content);
    }

    private void killWebDriver() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    /**
     * init browser instance
     */

    private void initBrowser() {
        try {
            initComponents();
            browserType = jsonObjectForm.getString("browser");
            homeURL = jsonObjectForm.getString("site_fo");
            switch (browserType) {
                case "chrome":
                    initChrome();
                    break;
                case "firefox":
                    initFirefox();
                    break;
                default:
                    System.out.println("browser : " + browserType + "Launching Chrome as browser of choice...");
                    initChrome();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(jsonObjectForm.getLong("object_wait"), TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(jsonObjectForm.getLong("page_wait"), TimeUnit.SECONDS);
            driver.get(homeURL);
        } catch (JSONException el) {
        }
    }

    private void initChrome() {
        System.out.println("Launching google chrome with new profile..");
        String driverExePath = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExePath);
        driver = new ChromeDriver();
    }

    private void initFirefox() {
        System.out.println("Launching firefox with new profile..");
        String driverExePath = System.getProperty("user.dir") + "\\driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverExePath);
        driver = new FirefoxDriver();
    }
}
