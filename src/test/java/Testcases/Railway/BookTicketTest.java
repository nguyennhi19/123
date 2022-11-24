package Testcases.Railway;

import Common.*;
import DataObjects.BookTicket;
import DataObjects.Login;
import PageObjects.*;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicket bookTicket;
    Login login;

    @Test(description = "TC01 - Login page displays when un-logged User clicks on Book ticket tab")
    public void TC01(){
        Log.info("TC01 - Login page displays when un-logged User clicks on Book ticket tab");
        Log.info(("Step1 - Navigate to QA Railway Website"));
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step2 - Click on Book Ticket tab");
        Assert.assertTrue(loginPage.isAtLoginPage(),"Login page don't displayed");
    }

    @Test(description = "TC02 - The user can book ticket with valid data")
    public void TC02(){
        Log.info("TC02 - The user can book ticket with valid data");
        Log.info(("Step1 - Navigate to QA Railway Website"));
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step3 - Click on Book Ticket tab");
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        Log.info("Step4 - Book Ticket with valid data");
        String actualMsg = bookTicketPage.getSuccessfulText();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "TC05 - The user can't book ticket when the user having 10 ticket")
    public void TC05(){
        Log.info("TC05 - The user can't book ticket when the user having 10 ticket");
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

    @Test(description = "TC06 - The user can book ticket with 10 ticket when the user does not have tickets")
    public void TC06(){
        Log.info("TC06 - The user can book ticket with 10 ticket when the user does not have tickets");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL_REGISTER,Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step2 - Login with a valid new account");
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step3 - Click on Book ticket tab");
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.MAX_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        Log.info("Step4 - Book 10 tickets");
        String actualMsg = bookTicketPage.getSuccessfulText();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        System.out.println(actualMsg);
        System.out.println(expectedMsg);
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "TC7 - User can book 1 ticket at a time")
    public void TC07()  {
        Log.info("TC7 - User can book 1 ticket at a time");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL_REGISTER,Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step2 - Login with a valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        myTicketPage.cancelAllTicket();
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step3 - Click on Book ticket tab");
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        Log.info("Step4 - Book 1 ticket");
        String actualMsg = bookTicketPage.getSuccessfulText();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
        Assert.assertEquals(bookTicketPage.getValueTicketOfDepartFromColumn(), Constant.VALID_DEPART_FROM, "value at Depart Station is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfArriveAtColumn(), Constant.VALID_ARRIVE_AT, "value at Arrive Station is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfSeatTypeColumn(), Constant.VALID_SEAT, "value of Seat Type is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfDepartDateColumn(), Constant.VALID_DEPART_DATE, "value of DepartDate not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfAmountColumn(), Constant.VALID_AMOUNT_TICKET, "value of Amount is not correctly");
    }

    @Test(description = "TC8 - Note at My Ticket page is correct display after the user book 1 ticket")
    public void TC08()  {
        Log.info("TC8 - Note at My Ticket page is correct display after the user book 1 ticket");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL,Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step2 - Login with a valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click on My ticket tab");
        int amountBefore = myTicketPage.getAmountTicket();
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step4 - Click on Book ticket tab");
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        Log.info("Step5 - Book 1 ticket");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step6 - Click on My ticket tab");
        Assert.assertEquals(myTicketPage.getNote(),myTicketPage.getNoteTextAfterBookTicket(amountBefore),"Amount ticket is incorrect display at note");

    }
}