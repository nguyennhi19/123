package Testcases.Railway;

import Common.*;
import DataObjects.Login;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    Login login;

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        Log.info("TC01 - User can log into Railway with valid username and password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click Login tab");
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step3 - Login with valid username and password");
        String actualMsg = loginPage.getWelcomeMessageText();
        String expectedMsg = String.format(Constant.MSG_WELCOME_USER, Constant.EMAIL);
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test(description = "TC02_User can't login with blank Username textBox")
    public void TC02() {
        Log.info("TC02_User can't login with blank Username textBox");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click Login tab");
        login = new Login("", Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step3 - Login with valid username and password");
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = Constant.MSG_PROBLEM_WITH_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not displayed as expected");

    }

    @Test(description = "TC03_User cannot log into Railway with invalid password ")
    public void TC03() {
        Log.info("TC03_User cannot log into Railway with invalid password ");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click Login tab");
        login = new Login(Constant.EMAIL, Constant.INVALID_PASSWORD);
        loginPage.login(login);
        Log.info("Step3 - Login with invalid password");
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC04_Login page displays when un-logged User clicks on Book ticket tab")
    public void TC04() {
        Log.info("TC04_Login page displays when un-logged User clicks on Book ticket tab");
        Log.info("Step1 - Navigate to QA Railway Website");
        loginPage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step2 - Click Book ticket tab");
        Assert.assertTrue(loginPage.isAtLoginPage(), "user can't navigate to Book ticket page");
    }

    @Test(description = "TC05_System shows message when user enters wrong password several times")
    public void TC05() {
        Log.info("TC05_System shows message when user enters wrong password several times");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click Login tab");
        loginPage.checkNumberOfLogins(Constant.NUMBER_OF_LOGIN);
        Log.info("Step3 - Login several times with wrong password");
        String actualMsg = homePage.getErrorMsg();
        String expectedMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC06_Additional pages display once user logged in")
    public void TC06() {
        Log.info("TC05_System shows message when user enters wrong password several times");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click Login tab");
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step3 - Login with valid account");
        Assert.assertTrue(loginPage.verifyMyTicketTabDisplayed(), "My Ticket tab not showing");
        Assert.assertTrue(loginPage.verifyChangePasswordTabDisplayed(), "Change Password tab not showing");
        loginPage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Assert.assertTrue(myTicketPage.isAtMyTicketPage(), "user can't navigate to Book ticket page");
        loginPage.gotoMenuTab(Constant.TAB_CHANGE_PASSWORD);
        Assert.assertTrue(changePasswordPage.isAtChangPasswordPage(), "user can't navigate to Book ticket page");
    }

    @Test(description = "TC07_Book ticket screen display after click on 'Book ticket' tab when user logged in")
    public void TC07() {
        Log.info("TC05_System shows message when user enters wrong password several times");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click Login tab");
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step3 - Login with valid account");
        loginPage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step4 - Click Book Ticket tab");
        Assert.assertTrue(bookTicketPage.isAtBookTicketPage(), "user can't navigate to Book ticket page");
    }
}