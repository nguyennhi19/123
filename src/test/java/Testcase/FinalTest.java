package Testcase;

import Common.DriverManager;
import Common.Log;
import Common.*;
import DataObjects.BookTicket;
import DataObjects.Login;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinalTest {
    String email;
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    Login login;
    BookTicket bookTicket;

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.setDriver("chrome");
        homePage.gotoMenuTab(Constant.TAB_REGISTER);
        email = registerPage.register(
                registerPage.createRandomEmail(),
                Constant.PASSWORD,
                Constant.PASSWORD,
                Constant.PID);
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.closeBrowser();
    }

    @Test(description = "FTTC01 - User can filter with Depart Station")
    public void FTTC01() {
        Log.info("FTTC01 - User can filter with Depart Station");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(email, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,"",Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicketSeveralTime(bookTicket,6);
        Log.info("Step3 - Book more than 6 tickets with different Depart Stations");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step4 - Click My ticket tab");
        int before = myTicketPage.checkFilter("Depart Station", "Huế");
        myTicketPage.filter("Huế", "", "", "");
        Log.info("Step5 - Select one of booked Depart Station in 'Depart Station' dropdown list");
        Log.info("Step6 - Click 'Apply filter' button");
        int after = myTicketPage.checkFilter("Depart Station", "Huế");
        boolean checkFilterCorrect = myTicketPage.checkFilter(before,after);
        Assert.assertTrue(checkFilterCorrect, "User can't filter with Depart Station");
    }

    @Test(description =  "FTTC02 - Error displays when user applies filter with invalid format for 'Depart Date' in 'Manage ticket' table")
    public void FTTC02(){
        Log.info("FTTC02 - Error displays when user applies filter with invalid format for 'Depart Date' in 'Manage ticket' table");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(email, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        bookTicket = new BookTicket(Constant.VALID_DEPART_DATE,"",Constant.VALID_ARRIVE_AT,Constant.VALID_SEAT,Constant.VALID_AMOUNT_TICKET);
        bookTicketPage.bookTicketSeveralTime(bookTicket,6);
        Log.info("Step3 - Book more than 6 tickets with different Depart Stations");
        homePage.gotoMenuTab(Constant.TAB_MY_TICKET);
        Log.info("Step4 - Click My ticket tab");
        myTicketPage.filter("", "", "4222022", "");
        Log.info("Step5 - Enter invalid date into 'Depart Date'. Ex: 4222022");
        Log.info("Step6 - Click 'Apply filter' button");
        String actualMsg = myTicketPage.getErrorMsgAtFilter();
        String expectedMsg = Constant.ERROR_MSG_INVALID_DATE;
        Assert.assertEquals(actualMsg,expectedMsg,"Filter successful with invalid format for 'Depart Date'");
    }
}
