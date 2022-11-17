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

    @Test(description = "TC02 - User can filter with Depart Station")
    public void TC02() {
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_MY_TICKET);
        int before = MyTicketPage.CheckRowConditionsFilter("Depart Station", "Huế", "","","");
        myTicketPage.Filter("Huế", "", "", "");
        int after = MyTicketPage.CheckRowConditionsFilter("Depart Station", "Huế", "","","");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }
    @Test(description = "TC03 - User can filter with Depart Station and Arrive Station")
    public void TC03() {
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_MY_TICKET);
        int before = MyTicketPage.CheckRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "", "");
        myTicketPage.Filter("Sài Gòn", "Phan Thiết", "", "");
        int after = MyTicketPage.CheckRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "", "");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }

    @Test(description = "TC04 - User can filter ")
    public void TC04() {
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_MY_TICKET);
        int before = MyTicketPage.CheckRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "10/30/2022", "Expired");
        myTicketPage.Filter("Sài Gòn", "Phan Thiết", "10/30/2022", "Expired");
        int after = MyTicketPage.CheckRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "10/30/2022", "Expired");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }

    @Test(description = "TC05 - The filter not display when the user have less than 6 row in the table my ticket")
    public void TC05(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_MY_TICKET);
        Assert.assertFalse(myTicketPage.isTitleFilterForm(),"Filter form still display");
    }

    @Test(description = "TC06 - Amount ticket is correct display at note")
    public void TC06(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_MY_TICKET);
        Assert.assertTrue(myTicketPage.checkAmountTicket(),"Amount ticket is incorrect display");
    }

}
