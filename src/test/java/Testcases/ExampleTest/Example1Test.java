package Testcases.ExampleTest;

import Common.Constant;
import Common.Log;
import PageObjects.*;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import Testcases.Railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example1Test extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TimeTablePage timeTablePage = new TimeTablePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    ServerError serverError = new ServerError();

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        Log.info("TC01_User can log into Railway with valid username and password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step3 - Enter valid Email and Password");
        Log.info("Step4 - Click on Login button");
        String actualMsg = loginPage.getWelcomeMessageText();
        String expectedMsg = String.format(Constant.MSG_WELCOME_USER, Constant.EMAIL);
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test(description = "TC02_User can't login with blank Username textBox")
    public void TC02() {
        Log.info("TC02_User can't login with blank Username textBox");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        loginPage.login("", Constant.PASSWORD);
        Log.info("Step3 - User doesn't type any words into Username textbox but enter valid information into Password textbox ");
        Log.info("Step4 - Click on Login button");
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = Constant.MSG_PROBLEM_WITH_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message is not displayed as expected");
    }

    @Test(description = "TC03_User cannot log into Railway with invalid password")
    public void TC03() {
        Log.info("TC03_User cannot log into Railway with invalid password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step2 -Click on Login tab");
        loginPage.login(Constant.EMAIL, Constant.INVALID_PASSWORD);
        Log.info("Step3 - Enter valid Email and invalid Password");
        Log.info("Step4 - Click on Login button");
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC04_Login page displays when un-logged User clicks on Book ticket tab")
    public void TC04() {
        Log.info("TC04_Login page displays when un-logged User clicks on Book ticket tab");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        Log.info("Step2 - Click on Book ticket tab");
        Assert.assertTrue(loginPage.isAtLoginPage(), "user can't navigate to Login page");
    }

    @Test(description = "TC05_System shows message when user enters wrong password several times")
    public void TC05() {
        Log.info("TC05_System shows message when user enters wrong password several timesb");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step2 -Click on Login tab");
        loginPage.checkNumberOfLogins(Constant.NUMBER_OF_LOGIN);
        Log.info("Step3 - Enter valid information into Username textbox except Password textbox.");
        Log.info("Step4 - Click on Login button");
        Log.info("Step5 - Repeat step 3 three more times.");
        String actualMsg = homePage.getErrorMsg();
        String expectedMsg = Constant.MSG_RUN_OUT_OF_TRY_LOGIN;
        Assert.assertEquals(actualMsg, expectedMsg, "error message not displayed as expected");
    }

    @Test(description = "TC06_Additional pages display once user logged in")
    public void TC06() {
        Log.info("TC06_Additional pages display once user logged in");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step2 -Click on Login tab");
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step3 - Login with valid account");
        Assert.assertTrue(loginPage.verifyMyTicketTabDisplayed(), "My Ticket tab not showing");
        Assert.assertTrue(loginPage.verifyChangePasswordTabDisplayed(), "Change Password tab not showing");
        Assert.assertTrue(loginPage.verifyLogoutTabDisplayed(), "Logout tab not showing");
        loginPage.gotoMenuTap(Constant.TAB_MY_TICKET);
        Assert.assertTrue(loginPage.isAtMyTicketPage(), "user can't navigate to Book ticket page");
        loginPage.gotoMenuTap(Constant.TAB_CHANGE_PASSWORD);
        Assert.assertTrue(loginPage.isAtChangPasswordPage(), "user can't navigate to Book ticket page");

    }

    @Test(description = "TC07_User can create new account")
    public void TC07(){
        Log.info("TC07_User can create new account");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_REGISTER);
        Log.info("Step2 - Click on Register tab");
        registerPage.register(registerPage.createGenerateEmail(),Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        Log.info("Step3 - Click on Register button");
        String actualMsg = registerPage.getRegisterSuccessMsg();
        String expectedMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(actualMsg, expectedMsg, "The message content is not displayed correctly");
    }


    @Test(description = "TC08_User can't login with an account hasn't been activated")
    public void TC08(){
        Log.info("TC08_User can't login with an account hasn't been activated");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_REGISTER);
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        loginPage.login(Constant.EMAIL_REGISTER, Constant.PASSWORD);
        Log.info("Step3 - Enter username and password of account hasn't been activated.");
        Log.info("Step4 - Click on Login button");
        Assert.assertTrue(loginPage.isAtLoginPage(), "User can login success when account hasn't been activated");
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;
        Assert.assertEquals(actualMsg,expectedMsg,"error message not displayed as expected");
    }

    @Test(description = "TC09 - User can change password")
    public void TC09(){
        Log.info("TC09 - User can change password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step2 - Login with valid account");
        homePage.gotoMenuTap(Constant.TAB_CHANGE_PASSWORD);
        Log.info("Step3 - Click on Change Password tab");
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        Log.info("Step4 - Enter valid value into all fields.");
        Log.info("Step5 - Click on Change Password button");
        String actualMsg = changePasswordPage.getChangePasswordSuccessMsg();
        String expectedMsg = Constant.MSG_CHANGE_PASSWORD_SUCCESS;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
    }

    @Test(description = "TC10 - User can't create account with Confirm password is not the same with Password")
    public void TC10() {
        Log.info("TC10 - User can't create account with Confirm password is not the same with Password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_REGISTER);
        Log.info("Step2 - Click on Register tab");
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_INVALID_PASSWORD,Constant.PID);
        Log.info("Step3 - Enter valid information into all fields except Confirm password is not the same with Password");
        Log.info("Step4 - Click on Register button");
        String actualMsg = registerPage.getRegisterFailedMsg();
        String expectedMsg = Constant.MSG_REGISTER_FAILED;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly");
    }

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11(){
        Log.info("TC11 - User can't create account while password and PID fields are empty");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_REGISTER);
        Log.info("Step2 - Click on Register tab");
        registerPage.register(Constant.EMAIL_REGISTER,"",Constant.CONFIRM_PASSWORD,"");
        Log.info("Step3 - Enter valid email address and leave other fields empty");
        Log.info("Step4 - Click on Register button");
        String actualMsg = registerPage.getRegisterFailedMsg();
        String expectedMsg = Constant.MSG_REGISTER_FAILED;
        Assert.assertEquals(actualMsg,expectedMsg,"The main message content is not displayed correctly");
        actualMsg = registerPage.getPassWordFieldMsg();
        expectedMsg = Constant.MSG_PASSWORD_FIELD;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content of password fields is not displayed correctly");
        actualMsg = registerPage.getPIDFieldMsg();
        expectedMsg = Constant.MSG_PID_FIELD;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content of PID fields is not displayed correctly");
    }

    @Test(description = "TC12 - Errors display when password reset token is blank")
    public void TC12(){
        Log.info("TC12 - Errors display when password reset token is blank");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap("Login");
        Log.info("Step2 - Click on Login tab");
        loginPage.goToForgotPasswordPage();
        Log.info("Step3 - Click on Forgot Password page link");
        forgotPasswordPage.sendInstruction(Constant.EMAIL);
        Log.info("Step4 - Enter the email address of the created account in Pre-condition");
        Log.info("Step5 - Click on Send Instructions button");
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step");
    }

    @Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password")
    public void TC13(){
        Log.info("TC13 - Errors display if password and confirm password don't match when resetting password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap("Login");
        Log.info("Step2 - Click on Login tab");
        loginPage.goToForgotPasswordPage();
        Log.info("Step3 - Click on Forgot Password page link");
        forgotPasswordPage.sendInstruction(Constant.EMAIL);
        Log.info("Step4 - Enter the email address of the created account in Pre-condition");
        Log.info("Step5 - Click on Send Instructions button");
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step");
    }

    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14()  {
        Log.info("TC14 - User can book 1 ticket at a time");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step2 - Login with a valid account ");
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        Log.info("Step3 - Click on Book ticket tab");
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        Log.info("Step4 - Select a Depart date from the list");
        Log.info("Step5 -  Select Huế for Depart from and Sài Gòn for Arrive at.");
        Log.info("Step6 - Select Soft bed with air conditioner for Seat type");
        Log.info("Step7 -  Select 1 for Ticket amount");
        Log.info("Step8 -  Click on Book ticket button");
        String actualMsg = bookTicketPage.navigateSuccessfulScreen();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
        Assert.assertEquals(bookTicketPage.getValueTicketOfDepartFromColumn(), Constant.VALID_DEPART_From, "value at Depart Station is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfArriveAtColumn(), Constant.VALID_ARRIVE_AT, "value at Arrive Station is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfSeatTypeColumn(), Constant.VALID_SEAT, "value of Seat Type is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfDepartDateColumn(), Constant.VALID_DEPART_DATE, "value of DepartDate not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfAmountColumn(), Constant.VALID_AMOUNT_TICKET, "value of Amount is not correctly");
    }

    @Test(description = "TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page")
    public void TC15(){
        Log.info("TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step2 - Login with a valid account ");
        homePage.gotoMenuTap(Constant.TAB_TIMETABLE);
        Log.info("Step3 - Click on Timetable tab");
        timeTablePage.bookTicketFormTrainTimeTableScreen(Constant.DEPART_FROM, Constant.ARRIVE_AT);
        Log.info("Click on book ticket link of the route from Huế to Sài Gòn");
        String actualMsg = bookTicketPage.getContentBookTicketPage();
        String expectedMsg = Constant.MSG_CONTENT_OF_BOOK_TICKET_PAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "you are is not at book ticket page");
        actualMsg = bookTicketPage.valueSelectedOfDepartStation();
        expectedMsg = Constant.DEPART_FROM;
        Assert.assertEquals(actualMsg, expectedMsg, "value of depart from not correctly");
        actualMsg = bookTicketPage.valueSelectedOfArriveAt();
        expectedMsg = Constant.ARRIVE_AT;
        Assert.assertEquals(actualMsg, expectedMsg, "value of arrive at not correctly");
    }

    @Test(description = "TC16 - User can cancel a ticket")
    public void TC16() {
        Log.info("TC16 - User can cancel a ticket");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        Log.info("Step2 - Login with a valid account ");
        homePage.gotoMenuTap(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click on My ticket tab");
        String countItemBeforeDelete = myTicketPage.getPositionText();
        Log.info("Step4 - Click on Cancel button of ticket which user want to cancel.");
        myTicketPage.deleteTicket("Huế","Sài Gòn","Soft seat","11/19/2022");
        Log.info("Step5 - Click on OK button on Confirmation message Are you sure?");
        String countItemAfterDelete = myTicketPage.getPositionText();
        Assert.assertFalse(myTicketPage.verifyTicketWasDeleted(countItemBeforeDelete, countItemAfterDelete), "Ticket cannot be deleted");
    }
}
