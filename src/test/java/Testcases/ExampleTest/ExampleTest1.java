package Testcases.ExampleTest;

import Common.Constant;
import PageObjects.*;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import Testcases.Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest1 extends TestBase {
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

    @Test(description = "TC04_Login page displays when un-logged User clicks on Book ticket tab")
    public void TC04() {
        homePage.gotoLoginPage();
        loginPage.gotoBookTicketPage();
        loginPage.getLoginPage();
        Assert.assertTrue(loginPage.isAtLoginPage(), "user can't navigate to Login page");
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

    @Test(description = "User can create new account")
    public void TC07(){
        homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        String actualMsg = registerPage.getRegisterSuccessMsg();
        String expectedMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(actualMsg, expectedMsg, "The message content is not displayed correctly");
    }


    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08(){
        homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL_REGISTER, Constant.PASSWORD);
        Assert.assertTrue(loginPage.isAtLoginPage(), "User can login success when account hasn't been activated");
    }

    @Test(description = "TC09 - User can change password")
    public void TC09(){
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.gotoChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        String actualMsg = changePasswordPage.getChangePasswordSuccessMsg();
        String expectedMsg = Constant.MSG_CHANGE_PASSWORD_SUCCESS;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
    }

    @Test(description = "TC10 - User can't create account with Confirm password is not the same with Password")
    public void TC10() {
        homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_INVALID_PASSWORD,Constant.PID);
        String actualMsg = registerPage.getRegisterFailedMsg();
        String expectedMsg = Constant.MSG_REGISTER_FAILED;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly");
    }

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11(){
        homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL_REGISTER,"",Constant.CONFIRM_PASSWORD,"");
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
        homePage.gotoLoginPage();
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.SendInstruction(Constant.EMAIL);
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step");
    }

    @Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password ")
    public void TC13(){
        homePage.gotoLoginPage();
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.SendInstruction(Constant.EMAIL);
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step");
    }

    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.NavigateSuccessfulScreen();
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
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        homePage.gotoTimetablePage();
        timeTablePage.BookTicketFormTrainTimeTableScreen(Constant.DEPART_FROM, Constant.ARRIVE_AT);
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
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.gotoMyTicketPage();
        String countItemBeforeDelete = myTicketPage.getPositionText();
        myTicketPage.deleteTicket("Huế","Sài Gòn","Hard seat","11/15/2022");
        String countItemAfterDelete = myTicketPage.getPositionText();
        Assert.assertFalse(myTicketPage.verifyTicketWasDeleted(countItemBeforeDelete, countItemAfterDelete), "Ticket cannot be deleted");

    }
}
