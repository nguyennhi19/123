package Testcases.Railway;

import Common.*;
import DataObjects.Login;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.TimeTablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeTableTest extends BaseTest {
    TimeTablePage timeTablePage = new TimeTablePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    Login login;

    @Test(description = "TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page")
    public void TC01(){
        Log.info("TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_TIMETABLE);
        Log.info("Step3 - Click Timetable tab");
        timeTablePage.bookTicketFormTrainTimeTableScreen(Constant.DEPART_FROM, Constant.ARRIVE_AT);
        Log.info("Step4 - Click on Book ticket link in Train timetable page");
        String actualMsg = bookTicketPage.getContentBookTicketPage();
        String expectedMsg = Constant.MSG_CONTENT_OF_BOOK_TICKET_PAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "you are is not at book ticket page");
        actualMsg = bookTicketPage.getCbbDepartStation();
        expectedMsg = Constant.DEPART_FROM;
        Assert.assertEquals(actualMsg, expectedMsg, "value of depart from not correctly");
        actualMsg = bookTicketPage.getCbbArriveAt();
        expectedMsg = Constant.ARRIVE_AT;
        Assert.assertEquals(actualMsg, expectedMsg, "value of arrive at not correctly");
    }
}