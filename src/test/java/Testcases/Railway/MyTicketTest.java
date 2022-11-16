package Testcases.Railway;

import Common.Constant;
import PageObjects.BookTicketPage;
import PageObjects.MyTicketPage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTicketTest extends TestBase {
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC16 - User can cancel a ticket")
    public void TC01() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.gotoMyTicketPage();
        String countItemBeforeDelete = myTicketPage.getPositionText();
        myTicketPage.deleteTicket("Huế","Sài Gòn","Hard seat","11/15/2022");        String countItemAfterDelete = myTicketPage.getPositionText();
        Assert.assertFalse(myTicketPage.verifyTicketWasDeleted(countItemBeforeDelete, countItemAfterDelete), "Ticket cannot be deleted");

    }
}
