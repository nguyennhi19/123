package Testcases.testData;

import Common.*;
import Common.ExcelHelpers;
import Common.Utilities;
import DataObjects.BookTicket;
import DataObjects.Login;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import Testcases.Railway.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();
    Login login;
    BookTicket bookTicket;
    ExcelHelpers excel = new ExcelHelpers();

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        Log.info("TC01 - User can log into Railway with valid username and password");
        Log.info("Step1 - Navigate to QA Railway Website");
        excel.setExcelFile(Constant.PATH_EXCEL,Constant.SHEET_LOGIN);
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(excel.getCellData(1, 2),excel.getCellData(1,3));
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        String actualMsg = loginPage.getWelcomeMessageText();
        String expectedMsg = String.format(Constant.MSG_WELCOME_USER, excel.getCellData(1, 2));
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test(description = "TC02 - The user can book ticket with valid data")
    public void TC02(){
        Log.info("TC02 - The user can book ticket with valid data");
        Log.info("Step1 - Navigate to QA Railway Website");
        excel.setExcelFile(Constant.PATH_EXCEL,Constant.SHEET_BOOK_TICKET);
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step 2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        Log.info("Step3 - Click on Book ticket tab");
        bookTicket = new BookTicket(Utilities.getDate(),excel.getCellData(2,2),excel.getCellData(3,2),excel.getCellData(6,2),Integer.parseInt(excel.getCellData(7,2)));
        bookTicketPage.bookTicket(bookTicket);
        Log.info("Step5 - Book 1 ticket");
        String actualMsg = bookTicketPage.getSuccessfulText();
        String expectedMsg = Constant.SUCCESSFULLY_TITLE;
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket is unsuccessful");
    }

    @Test(description = "TC03 -User can create new account")
    public void TC03(){
        Log.info("TC03 -User can create new account");
        Log.info("Step1 - Navigate to QA Railway Website");
        excel.setExcelFile(Constant.PATH_EXCEL,Constant.SHEET_REGISTER);
        homePage.gotoMenuTab(Constant.TAB_REGISTER);
        Log.info("Step2 - Click on Register tab");
        registerPage.register(registerPage.createGenerateEmail(),excel.getCellData(1,3),excel.getCellData(1,4),excel.getCellData(1,5));
        Log.info("Step3 - Create new account");
        String actualMsg = registerPage.getRegisterSuccessMsg();
        String expectedMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(actualMsg, expectedMsg, "The message content is not displayed correctly");
    }
}