package Testcases.Railway;

import Common.Constant;
import PageObjects.ForgotPasswordPage;
import PageObjects.Railway.LoginPage;
import PageObjects.ServerError;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    LoginPage loginPage = new LoginPage();
    ServerError serverError = new ServerError();

    @Test(description = "TC12 - Errors display when password reset token is blank")
    public void TC01(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.sendInstruction(Constant.EMAIL);
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step");
    }
    @Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password ")
    public void TC02(){
        homePage.gotoMenuTap(Constant.TAB_LOGIN);
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.sendInstruction(Constant.EMAIL);
        Assert.assertFalse(serverError.verifyMailBoxDisplayed()
                ,"this testcase was blocked by open mailbox step");
    }
}
