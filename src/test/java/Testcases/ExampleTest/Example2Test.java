package Testcases.ExampleTest;

import Common.Constant;
import Common.Log;
import PageObjects.*;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import Testcases.Railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example2Test extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    TimeTablePage timeTablePage = new TimeTablePage();

    @Test(description = "TC04_User is redirected to Book ticket page after logging in")
    public void TC04() {
        Log.info("TC04_User is redirected to Book ticket page after logging in");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        Log.info("Step2 - Click on Book ticket tab");
        Assert.assertTrue(loginPage.isAtLoginPage(), "user can navigate to Book ticket page");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step3 - Click on Login tab");
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step4 - Login with a valid account ");
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        Log.info("Step5 - Click on Book ticket tab");
        Assert.assertTrue(loginPage.isAtBookTicketPage(), "user can't navigate to Book ticket page");
    }

    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC06(){
        Log.info("TC06 - User is redirected to Home page after logging out");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step3 - Login with a valid account ");
        homePage.gotoMenuTap(Constant.TAB_LOGOUT);
        Log.info("Step4 - Click on Logout tab");
        Assert.assertTrue(loginPage.isAtHomePage(), "user can't navigate to home page");
    }

    @Test(description = "TC09 - User can't change password when New Password and Confirm Password are different.")
    public void TC09() {
        Log.info("TC09 - User can't change password when New Password and Confirm Password are different.");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step3 - Login with a valid account ");
        homePage.gotoMenuTap(Constant.TAB_CHANGE_PASSWORD);
        Log.info("Step2 - Click on Change password tab");
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD, Constant.CONFIRM_INVALID_PASSWORD);
        Log.info("Step3 - Enter valid information into Current Password textbox but enter into New Password textbox and Confirm Password textbox are different.");
        String actualMsg = changePasswordPage.verifyErrorMessageAtConfirmPassword();
        String expectedMsg = Constant.MSG_CHANGE_PASSWORD_FIELD_PASSWORD_NO_MATCH;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
    }

    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10(){
        Log.info("TC10 - User can't create account with an already in-use email");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_REGISTER);
        Log.info("Step2 - Click on Register tab");
        registerPage.register(Constant.EMAIL,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        Log.info("Step3 -  Enter information of the created account in Pre-condition");
        Log.info("Step4 - Click on Register button");
        String actualMsg = registerPage.getRegisterFailedMsg();
        String expectedMsg = Constant.MSG_REGISTER_FAILED_EMAIL_USED;
        Assert.assertEquals(actualMsg,expectedMsg,"The main message content is not displayed correctly");
    }

    @Test(description = "TC15 - Ticket price page displays with ticket details after clicking on check price link in Train timetable page")
    public void TC15() {
        Log.info("TC15 - Ticket price page displays with ticket details after clicking on check price link in Train timetable page");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step3 - Login with a valid account ");
        homePage.gotoMenuTap(Constant.TAB_TIMETABLE);
        Log.info("Step4 - Click on Timetable tab");
        timeTablePage.checkPriceFormTrainTimeTableScreen(Constant.DEPART_FROM, Constant.ARRIVE_AT);
        Log.info("Step5 - Click on check price link of the route from Sài Gòn to Huế");
        String actualMsg = ticketPricePage.getContentPricePage();
        String expectedMsg = Constant.MSG_CONTENT_OF_TICKET_PRICE_PAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "you are is not at book ticket page");
        actualMsg = ticketPricePage.getTitleOfTable();
        expectedMsg = Constant.TITLE_TABLE_CHECK_PRICE;
        Assert.assertEquals(actualMsg, expectedMsg, "Title table Price Ticket not correctly");
        actualMsg = ticketPricePage.getPriceOfHSAtTicketPricePage("HS","SS","SSC","HB","SB","SBC");
        expectedMsg = Constant.PRICE_OF_HS + Constant.PRICE_OF_SS + Constant.PRICE_OF_SSC + Constant.PRICE_OF_HB + Constant.PRICE_OF_SB + Constant.PRICE_OF_SBC;
        Assert.assertEquals(actualMsg, expectedMsg, "Price Ticket not correctly");
    }
}
