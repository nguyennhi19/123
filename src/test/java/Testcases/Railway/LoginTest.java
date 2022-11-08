package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    LoginPage loginPage = new LoginPage();

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {

        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        String actualMsg = loginPage.getWelcomeMessageText();
        String expectedMsg = String.format(Constant.MSG_WELCOME_USER, Constant.EMAIL);
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test(description = "TC02_User can't login with blank Username textbox")
    public void TC02() {
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = Constant.MSG_PROBLEM_WITH_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not displayed as expected");

    }

    @Test(description = "TC03_User cannot log into Railway with invalid password ")
    public void TC03() {
        loginPage.login(Constant.EMAIL, Constant.INVALID_PASSWORD);
        String actualMsg = loginPage.getErrorMsg();
        System.out.println(actualMsg);
        String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC04_Additional pages display once user logged in")
    public void TC04() {
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Assert.assertTrue(loginPage.verifyMyTicketTabDisplayed(), "My Ticket tab not showing");
        Assert.assertTrue(loginPage.verifyChangePasswordTabDisplayed(), "Change Password tab not showing");
        Assert.assertTrue(loginPage.verifyLogoutTabDisplayed(), "Logout tab not showing");
    }

    @Test(description = "TC05_Book ticket screen display after click on 'Book ticket' tab when user logged in")
    public void TC05() {
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        Assert.assertTrue(loginPage.isAtBookTicketPage(), "user can't navigate to Book ticket page");
    }
}
