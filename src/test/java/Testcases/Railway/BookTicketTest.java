package Testcases.Railway;

import Common.Constant;
import PageObjects.BookTicketPage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
    public void TC01(){
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        Assert.assertTrue(loginPage.isAtLoginPage(),"Login page don't displayed");
    }

    @Test(description = "The user can book ticket with valid data")
    public void TC02(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.navigateSuccessfulScreen();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can't book ticket when arrive at duplicate with depart from")
    public void TC03(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.ARRIVE_AT_DUPLICATE_WITH_DEPART_FROM,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.verifyErrorMessageAtArriveStation();
        String expectedMsg = Constant.ERROR_MESSAGE_ARRIVE_AT_DUPLICATE_WITH_DEPART_FROM;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can't book ticket with ticket no support")
    public void TC04(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.ARRIVE_AT_TICKET_NO_SUPPORT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.verifyErrorMessageAtArriveStation();
        String expectedMsg = Constant.ERROR_MESSAGE_TRAIN_NO_SUPPORT;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can't book ticket when the user having 10 ticket")
    public void TC05(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.verifyErrorMessageAtTicketAmount();
        String expectedMsg = Constant.ERROR_MESSAGE_WHEN_BOOK_10_TICKET;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can book ticket with 10 ticket when the user does not have tickets")
    public void TC06(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.MAX_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.navigateSuccessfulScreen();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        System.out.println(actualMsg);
        System.out.println(expectedMsg);
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "TC7 - User can book 1 ticket at a time")
    public void TC07() throws InterruptedException {
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_BOOK_TICKET);
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.navigateSuccessfulScreen();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
        Assert.assertEquals(bookTicketPage.getValueTicketOfDepartFromColumn(), Constant.VALID_DEPART_From, "value at Depart Station is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfArriveAtColumn(), Constant.VALID_ARRIVE_AT, "value at Arrive Station is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfSeatTypeColumn(), Constant.VALID_SEAT, "value of Seat Type is not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfDepartDateColumn(), Constant.VALID_DEPART_DATE, "value of DepartDate not correctly");
        Assert.assertEquals(bookTicketPage.getValueTicketOfAmountColumn(), Constant.VALID_AMOUNT_TICKET, "value of Amount is not correctly");
    }
}
