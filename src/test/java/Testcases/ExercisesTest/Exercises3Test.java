package Testcases.ExercisesTest;

import Common.*;
import Common.Log;
import DataObjects.BookTicket;
import DataObjects.Login;
import PageObjects.*;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Testcases.Railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercises3Test extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ContactPage contactPage = new ContactPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    ServerError serverError = new ServerError();
    BookTicket bookTicket;
    Login login;

    @Test(description = "TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog")
    public void TC04() {
        Log.info("TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_CONTACT);
        Log.info("Step2 - Click on Contact tab");
        Log.info("Step3 -  Check the email address");
        String actualMsg = contactPage.getHrefEmailDressAtContactPage();
        String expectedMsg = Constant.EMAIL_DRESS_HREF;
        Assert.assertEquals(actualMsg, expectedMsg, "Email dress href not correctly");
    }

    @Test(description = "TC09 - User can reset password successfully")
    public void TC09() {
        Log.info("TC09 - User can reset password successfully");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        loginPage.goToForgotPasswordPage();
        Log.info("Step3 - Click on Forgot Password link");
        forgotPasswordPage.sendInstruction(Constant.EMAIL);
        Log.info("Step4 - Enter the email address of the created account in Pre-condition");
        Log.info("Step5 - Click on Send Instructions button");
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step");
    }

    @Test(description = "TC10 - User can't reset password if enter incorrect email address")
    public void TC10() {
        Log.info("TC10 - User can't reset password if enter incorrect email address");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        loginPage.goToForgotPasswordPage();
        Log.info("Step3 - Click on Forgot Password link");
        forgotPasswordPage.sendInstruction(Constant.EMAIL_UN_EXITING);
        Log.info("Step4 - Enter an un-existing email address ");
        Log.info("Step5 - Click on Send Instructions button");
        String actualMsg = forgotPasswordPage.getErrorMsgAtForgotPassword();
        String expectedMsg = Constant.ERROR_MSG_FORGOT_PASSWORD_UN_EXITING;
        Assert.assertEquals(actualMsg, expectedMsg, "Email dress href not correctly");
    }

    @Test(description = "TC14 - User can't book more than 10 tickets")
    public void TC14() {
        Log.info("TC14 - User can't book more than 10 tickets");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        login = new Login(Constant.EMAIL_REGISTER,Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step3 - Login with a valid new account");
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step4 - Click on Book ticket tab");
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.MAX_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        Log.info("Step5 - Book 10 tickets");
        loginPage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step6 - Click on Book ticket tab again");
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.MAX_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        Log.info("Step7 -  Book one more ticket");
        String actualMsg = bookTicketPage.getErrorMessageAtTicketAmount();
        String expectedMsg = Constant.ERROR_MESSAGE_WHEN_BOOK_10_TICKET;
        System.out.println(actualMsg);
        System.out.println(expectedMsg);
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is successful");
    }

    @Test(description = "TC15 - User can open Book ticket page by click on Book ticket link in Ticket price")
    public void TC15() {
        Log.info("TC15 - User can open Book ticket page by click on Book ticket link in Ticket price");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step3 - Login with a valid account");
        homePage.gotoMenuTab(Constant.TAB_TICKET_PRICE);
        Log.info("Step4 - Click on Ticket price tab");
        ticketPricePage.checkPriceFormTrainTicketPriceListScreen(Constant.DEPART_FROM, Constant.ARRIVE_AT);
        Log.info("Step5 -  Click on any ticket from the list");
        ticketPricePage.bookTicketFormTicketPriceScreen(Constant.SEAT_TYPE);
        Log.info("Step6 - Click on Book ticket for any seat type");
        Assert.assertTrue(bookTicketPage.isAtBookTicketPage(), "User can't navigate to Book ticket page");
    }
}