package Testcases.Railway;

import Common.Constant;
import PageObjects.BookTicketPage;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends TestBase{
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();

    @Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
    public void TC01(){
        generalPage.gotoBookTicketPage();
        Assert.assertTrue(loginPage.isAtLoginPage(),"Login page don't displayed");
    }

    @Test(description = "The user can book ticket with valid data")
    public void TC02(){
        generalPage.gotoLoginPage();
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.NavigateSuccessfulScreen();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        System.out.println(actualMsg);
        System.out.println(expectedMsg);
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can't book ticket when arrive at duplicate with depart from")
    public void TC03(){
        generalPage.gotoLoginPage();
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.ARRIVE_AT_DUPLICATE_WITH_DEPART_FROM,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.VerifyErrorMessageAtArriveStation();
        String expectedMsg = Constant.ERROR_MESSAGE_ARRIVE_AT_DUPLICATE_WITH_DEPART_FROM;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can't book ticket with ticket no support")
    public void TC04(){
        generalPage.gotoLoginPage();
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.ARRIVE_AT_TICKET_NO_SUPPORT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.VerifyErrorMessageAtArriveStation();
        String expectedMsg = Constant.ERROR_MESSAGE_TRAIN_NO_SUPPORT;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can't book ticket when the user having 10 ticket")
    public void TC05(){
        generalPage.gotoLoginPage();
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.VerifyErrorMessageAtTicketAmount();
        String expectedMsg = Constant.ERROR_MESSAGE_WHEN_BOOK_10_TICKET;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "The user can book ticket with 10 ticket when the user does not have tickets")
    public void TC06(){
        generalPage.gotoLoginPage();
        loginPage.login(Constant.EMAIL,Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(Constant.VALID_DEPART_DATE,Constant.VALID_DEPART_From,Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.MAX_AMOUNT_TICKET);
        String actualMsg = bookTicketPage.NavigateSuccessfulScreen();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        System.out.println(actualMsg);
        System.out.println(expectedMsg);
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }
}
