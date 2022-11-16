package Testcases.Railway;

import Common.*;
import DataObjects.BookTicket;
import DataObjects.Login;
import PageObjects.BookTicketPage;
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

    @Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
    public void TC01(){
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Assert.assertTrue(loginPage.isAtLoginPage(),"Login page don't displayed");
    }

    @Test(description = "The user can book ticket with valid data")
    public void TC02(){
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        String actualMsg = bookTicketPage.getSuccessfulText();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can't book ticket when arrive at duplicate with depart from")
    public void TC03(){
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.ARRIVE_AT_DUPLICATE_WITH_DEPART_FROM,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        String actualMsg = bookTicketPage.getErrorMessageAtArriveStation();
        String expectedMsg = Constant.ERROR_MESSAGE_ARRIVE_AT_DUPLICATE_WITH_DEPART_FROM;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can't book ticket with ticket no support")
    public void TC04(){
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.ARRIVE_AT_TICKET_NO_SUPPORT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        String actualMsg = bookTicketPage.getErrorMessageAtArriveStation();
        String expectedMsg = Constant.ERROR_MESSAGE_TRAIN_NO_SUPPORT;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can't book ticket when the user having 10 ticket")
    public void TC05(){
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        String actualMsg = bookTicketPage.getErrorMessageAtTicketAmount();
        String expectedMsg = Constant.ERROR_MESSAGE_WHEN_BOOK_10_TICKET;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can book ticket with 10 ticket when the user does not have tickets")
    public void TC06(){
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.MAX_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        String actualMsg = bookTicketPage.getSuccessfulText();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        System.out.println(actualMsg);
        System.out.println(expectedMsg);
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "TC7 - User can book 1 ticket at a time")
    public void TC07()  {
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
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
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        int amountBefore = myTicketPage.getAmountTicket();
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_FROM,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicket(bookTicket);
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Assert.assertEquals(myTicketPage.getNote(),myTicketPage.getNoteTextAfterBookTicket(amountBefore),"Amount ticket is incorrect display at note");

    }
}