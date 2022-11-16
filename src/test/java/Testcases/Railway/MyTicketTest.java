package Testcases.Railway;

import Common.*;
import DataObjects.Login;
import PageObjects.*;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest {
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    Login login;

    @Test(description = "TC01 - User can cancel a ticket")
    public void TC01() {
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        String countItemBeforeDelete = myTicketPage.getPositionText();
        myTicketPage.deleteTicket("Huế","Sài Gòn","Soft seat","11/19/2022");
        String countItemAfterDelete = myTicketPage.getPositionText();
        Assert.assertFalse(myTicketPage.verifyTicketWasDeleted(countItemBeforeDelete, countItemAfterDelete), "Ticket cannot be deleted");
    }

    @Test(description = "TC02 - User can filter with Depart Station")
    public void TC02() {
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        int before = myTicketPage.checkRowConditionsFilter("Depart Station", "Huế", "","","");
        myTicketPage.filter("Huế", "", "", "");
        int after = myTicketPage.checkRowConditionsFilter("Depart Station", "Huế", "","","");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }
    @Test(description = "TC03 - User can filter with Depart Station and Arrive Station")
    public void TC03() {
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        int before = myTicketPage.checkRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "", "");
        myTicketPage.filter("Sài Gòn", "Phan Thiết", "", "");
        int after = myTicketPage.checkRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "", "");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }

    @Test(description = "TC04 - User can filter ")
    public void TC04() {
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        int before = myTicketPage.checkRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "10/30/2022", "Expired");
        myTicketPage.filter("Sài Gòn", "Phan Thiết", "10/30/2022", "Expired");
        int after = myTicketPage.checkRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "10/30/2022", "Expired");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }

    @Test(description = "TC05 - The filter not display when the user have less than 6 row in the table my ticket")
    public void TC05(){
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Assert.assertFalse(myTicketPage.isTitleFilterForm(),"Filter form still display");
    }

    @Test(description = "TC06 - Amount ticket is correct display at note")
    public void TC06(){
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login("nhi123@gmail.com", Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Assert.assertEquals(myTicketPage.getNote(),myTicketPage.getNoteText(),"Amount ticket is incorrect display at note");
    }

    @Test(description =  "TC07 - Error message is display when the user filter with invalid depart date")
    public void TC07(){
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        myTicketPage.filter("", "", "15/30/2022", "");
        String actualMsg = myTicketPage.getErrorMsgAtFilter();
        String expectedMsg = Constant.ERROR_MSG_INVALID_DATE;
        Assert.assertEquals(actualMsg,expectedMsg,"Filter successful with invalid depart date");
    }
}