package Testcases.Railway;

import Common.Constant;
import PageObjects.MyTicketPage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest {
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC01 - User can cancel a ticket")
    public void TC01() {
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_MY_TICKET);
        String countItemBeforeDelete = myTicketPage.getPositionText();
        myTicketPage.deleteTicket("Huế","Sài Gòn","Soft seat","11/19/2022");
        String countItemAfterDelete = myTicketPage.getPositionText();
        Assert.assertFalse(myTicketPage.verifyTicketWasDeleted(countItemBeforeDelete, countItemAfterDelete), "Ticket cannot be deleted");
    }

    @Test(description = "TC02 - User can filter a ticket")
    public void TC02() {
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_MY_TICKET);
        int before = myTicketPage.CheckRowConditionFilter("Depart Station", "Huế");
        myTicketPage.Filter("Huế", "", "", "");
        int after = myTicketPage.CheckRowConditionFilter("Depart Station", "Huế");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }
}
