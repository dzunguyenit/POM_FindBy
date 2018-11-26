import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import setup.SetupBrowser;
import utilitys.JsonUtility;

public class LoginTest extends SetupBrowser {
    LoginPage loginPage;
    ProfilePage profilePage;
    JsonUtility jsonUtility;

    @Override
    public void preCondition() {
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        jsonUtility = new JsonUtility();
    }

    /**
     * Login by Phone number
     */

    @Test(priority = 1, description = "Login successfully")
    public void TC01_login_Success() {
        loginPage.loginBtnHome();
        loginPage.fillIn(jsonUtility.LoginValid());
        loginPage.submit();
        Assert.assertTrue(loginPage.isGuest());
        profilePage.logout();
        Assert.assertTrue(loginPage.isGuest());
    }

    @Test(priority = 2, description = "incorrect Phone number")
    public void TC02_login_Incorrect_Phone() {
        loginPage.loginBtnHome();
        loginPage.fillIn(jsonUtility.Login_Incorrect_Phone());
        loginPage.submit();
        String actual = loginPage.getError_Incorrect_Phone_Pwd();
        String expected = "Phone: Số điện thoại không hợp lệ.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 3, description = "invalid password")
    public void TC03_login_Incorrect_Pass() {
        loginPage.clearAll();
        loginPage.fillIn(jsonUtility.Login_Incorrect_Pass());
        loginPage.submit();
        String actual = loginPage.getError_Incorrect_Phone_Pwd();
        String expected = "Số điện thoại hoặc mật khẩu không đúng, vui lòng đăng nhập lại.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 4, description = "invalid username and password")
    public void TC04_login_Invalid_User_Pass() {
        loginPage.clearAll();
        loginPage.fillIn(jsonUtility.Login_Invalid_User_Pass());
        loginPage.submit();
        String actual = loginPage.getError_Incorrect_Phone_Pwd();
        String expected = "Số điện thoại hoặc mật khẩu không đúng, vui lòng đăng nhập lại.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 5, description = "invalid format number")
    public void TC05_login_Invalid_Format() {
        loginPage.clearAll();
        loginPage.fillIn(jsonUtility.Login_Invalid_Format());
        loginPage.submit();
        String actual = loginPage.getError_Incorrect_Phone_Pwd();
        String expected = "Phone: Số điện thoại không hợp lệ.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 6, description = "password less than 5 chars")
    public void TC06_login_Pwd_lessthan_5() {
        loginPage.clearAll();
        loginPage.fillIn(jsonUtility.Login_Pwd_lessthan_5());
        loginPage.submit();
        String actual = loginPage.getError_Incorrect_Phone_Pwd();
        String expected = "Password: Mật khẩu phải có ít nhất 5 kí tự.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 7, description = "password less than 5 chars")
    public void TC07_login_Invalid_Phone_Pwd_lessthan_5() {
        loginPage.clearAll();
        loginPage.fillIn(jsonUtility.Login_Invalid_phone_Pwd_lessthan_5());
        loginPage.submit();
        String actual = loginPage.getError_Incorrect_Phone_Pwd();
        String expected = "Phone: Số điện thoại không hợp lệ. Password: Mật khẩu phải có ít nhất 5 kí tự.";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 8, description = "Login empty")
    public void TC08_login_Empty() {
        loginPage.clearAll();
        loginPage.submit();
        Assert.assertTrue(loginPage.isGuest());
    }

    /**
     * Login by Facebook
     */

    @Test(priority = 9, description = "Login FB successfully")
    public void TC09_login_Facebook() {
        loginPage.loginFB();
        loginPage.fillInFB(jsonUtility.Login_FB());
        loginPage.submitFB();
        //loginPage.continueFB();
        loginPage.fillIn(jsonUtility.LoginValid());
        loginPage.submit();
        Assert.assertTrue(loginPage.isGuest());
        profilePage.logout();
    }
}