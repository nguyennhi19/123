package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    LoginPage loginPage = new LoginPage();

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        String actualMsg = loginPage.getWelcomeMessageText();
        String expectedMsg = String.format(Constant.MSG_WELCOME_USER, Constant.EMAIL);
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test(description = "TC02_User can't login with blank Username textBox")
    public void TC02() {
        homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = Constant.MSG_PROBLEM_WITH_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not displayed as expected");

    }

    @Test(description = "TC03_User cannot log into Railway with invalid password ")
    public void TC03() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.INVALID_PASSWORD);
        String actualMsg = loginPage.getErrorMsg();
        System.out.println(actualMsg);
        String expectedMsg = Constant.MSG_PROBLEM_WITH_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC04_Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        homePage.gotoLoginPage();
        loginPage.gotoBookTicketPage();
        loginPage.getLoginPage();
        Assert.assertTrue(loginPage.isAtLoginPage(), "user can't navigate to Book ticket page");
    }

    @Test(description = "TC05_System shows message when user enters wrong password several times")
    public void TC05() {
        homePage.gotoLoginPage();
        loginPage.numberOfLogins(Constant.NUMBER_OF_LOGIN);
        String actualMsg = homePage.getErrorMsg();
        String expectedMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC06_Additional pages display once user logged in")
    public void TC06() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Assert.assertTrue(loginPage.verifyMyTicketTabDisplayed(), "My Ticket tab not showing");
        Assert.assertTrue(loginPage.verifyChangePasswordTabDisplayed(), "Change Password tab not showing");
        loginPage.gotoMyTicketPage();
        Assert.assertTrue(loginPage.isAtMyTicketPage(), "user can't navigate to Book ticket page");
        loginPage.gotoChangePasswordPage();
        Assert.assertTrue(loginPage.isAtChangPasswordPage(), "user can't navigate to Book ticket page");
    }

    @Test(description = "TC07_Book ticket screen display after click on 'Book ticket' tab when user logged in")
    public void TC07() {
    homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        Assert.assertTrue(loginPage.isAtBookTicketPage(), "user can't navigate to Book ticket page");
    }


}
