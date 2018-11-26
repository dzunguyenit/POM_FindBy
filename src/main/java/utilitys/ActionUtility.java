package utilitys;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtility {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private static final int TIMEOUT_INTERVAL_UNIT = 30;

    public ActionUtility(WebDriver driver) {
        this.driver = driver;
        initComponents();
    }

    private void initComponents() {
        wait = new WebDriverWait(driver, TIMEOUT_INTERVAL_UNIT);
        js = ((JavascriptExecutor) driver);
    }

    public void click(WebElement click) {
        js.executeScript("arguments[0].click();", click);
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilToBeClickAble(WebElement ele) {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void waitUntilInVisibility(WebElement ele) {
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public void waitForPageLoad(int timeout) {
        try {
            sleep(2000);
            for (int i = 0; i < timeout; i++) {
                // To check page ready state.
                if (js.executeScript("return document.readyState").toString().equals("complete"))
                    break;
                sleep(500);
            }
        } catch (JavascriptException ex) {
            js.executeScript("return window.jsErrors");
        }
    }
    public void stopPageLoad() {
        js.executeScript("return window.stop");
    }
}
