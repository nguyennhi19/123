package Testcases.Railway;

import Common.Constant;
import PageObjects.BookTicketPage;
import PageObjects.Railway.LoginPage;
import PageObjects.TimeTablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeTableTest extends BaseTest {
    TimeTablePage timeTablePage = new TimeTablePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();


    @Test(description = "TC15 - User can open Book ticket page by clicking on Book ticket link in Train timetable page")
    public void TC01(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        homePage.gotoMenuTap(Constant.TAB_TIMETABLE);
        timeTablePage.bookTicketFormTrainTimeTableScreen(Constant.DEPART_FROM, Constant.ARRIVE_AT);
        String actualMsg = bookTicketPage.getContentBookTicketPage();
        String expectedMsg = Constant.MSG_CONTENT_OF_BOOK_TICKET_PAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "you are is not at book ticket page");
        actualMsg = bookTicketPage.valueSelectedOfDepartStation();
        expectedMsg = Constant.DEPART_FROM;
        Assert.assertEquals(actualMsg, expectedMsg, "value of depart from not correctly");
        actualMsg = bookTicketPage.valueSelectedOfArriveAt();
        expectedMsg = Constant.ARRIVE_AT;
        Assert.assertEquals(actualMsg, expectedMsg, "value of arrive at not correctly");
    }
}
