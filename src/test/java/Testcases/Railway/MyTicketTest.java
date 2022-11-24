package Testcases.Railway;

import Common.*;
import DataObjects.Login;
import PageObjects.*;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest {
    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    LoginPage loginPage = new LoginPage();
    Login login;

    @Test(description = "TC01 - User can cancel a ticket")
    public void TC01() {
        Log.info("TC01 - User can cancel a ticket");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click My ticket tab");
        String countItemBeforeDelete = myTicketPage.getPositionText();
        myTicketPage.deleteTicket("Huế","Sài Gòn","Soft seat","12/2/2022");
        Log.info("Step4 - Cancel a ticket");
        String countItemAfterDelete = myTicketPage.getPositionText();
        Assert.assertFalse(myTicketPage.verifyTicketWasDeleted(countItemBeforeDelete, countItemAfterDelete), "Ticket cannot be deleted");
    }

    @Test(description = "TC02 - User can filter with Depart Station")
    public void TC02() {
        Log.info("TC02 - User can filter with Depart Station");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click My ticket tab");
        int before = myTicketPage.checkRowConditionsFilter("Depart Station", "Huế", "","","");
        myTicketPage.filter("Huế", "", "", "");
        Log.info("Step4 - Filter with Depart Station");
        int after = myTicketPage.checkRowConditionsFilter("Depart Station", "Huế", "","","");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }
    @Test(description = "TC03 - User can filter with Depart Station and Arrive Station")
    public void TC03() {
        Log.info("TC03 - User can filter with Depart Station and Arrive Station");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click My ticket tab");
        int before = myTicketPage.checkRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "", "");
        myTicketPage.filter("Sài Gòn", "Phan Thiết", "", "");
        Log.info("Step4 - Filter with Depart Station and Arrive Station");
        int after = myTicketPage.checkRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "", "");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }

    @Test(description = "TC04 - User can filter")
    public void TC04() {
        Log.info("TC04 - User can filter");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click My ticket tab");
        int before = myTicketPage.checkRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "10/30/2022", "Expired");
        myTicketPage.filter("Sài Gòn", "Phan Thiết", "10/30/2022", "Expired");
        Log.info("Step4 - Filter with all");
        int after = myTicketPage.checkRowConditionsFilter("Depart Station", "Sài Gòn","Phan Thiết", "10/30/2022", "Expired");
        boolean checkFilterCorrect = myTicketPage.checkFilterCorrect(before,after);
        Assert.assertTrue(checkFilterCorrect, "filter fail");
    }

    @Test(description = "TC05 - The filter not display when the user have less than 6 row in the table my ticket")
    public void TC05(){
        Log.info("TC05 - The filter not display when the user have less than 6 row in the table my ticket");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click My ticket tab");
        Assert.assertFalse(myTicketPage.isTitleFilterForm(),"Filter form still display");
    }

    @Test(description = "TC06 - Amount ticket is correct display at note")
    public void TC06(){
        Log.info("TC06 - Amount ticket is correct display at note");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click My ticket tab");
        Assert.assertEquals(myTicketPage.getNote(),myTicketPage.getNoteText(),"Amount ticket is incorrect display at note");
    }

    @Test(description =  "TC07 - Error message is display when the user filter with invalid depart date")
    public void TC07(){
        Log.info("TC07 - Error message is display when the user filter with invalid depart date");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click My ticket tab");
        myTicketPage.filter("", "", "15/30/2022", "");
        Log.info("Step4 - Filter with invalid depart date");
        String actualMsg = myTicketPage.getErrorMsgAtFilter();
        String expectedMsg = Constant.ERROR_MSG_INVALID_DATE;
        Assert.assertEquals(actualMsg,expectedMsg,"Filter successful with invalid depart date");
    }

    @Test(description = "TC08 - User can cancel aLL ticket")
    public void TC08() {
        Log.info("TC08 - User can cancel aLL ticket");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step3 - Click My ticket tab");
        myTicketPage.cancelAllTicket();
        Log.info("Step4 - Cancel all ticket");
        Assert.assertEquals(0,myTicketPage.getAmountBtnCancel(),"false");

    }
}