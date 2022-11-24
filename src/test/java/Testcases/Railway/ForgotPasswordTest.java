package Testcases.Railway;


import Common.*;
import PageObjects.ForgotPasswordPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    LoginPage loginPage = new LoginPage();


    @Test(description = "TC1 - User can't reset password if enter incorrect email address")
    public void TC1() {
        Log.info("TC10 - User can't reset password if enter incorrect email address");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        Log.info("Step2 - Click on Login tab");
        loginPage.goToForgotPasswordPage();
        Log.info("Step3 - Click on Forgot Password link");
        forgotPasswordPage.sendInstruction(Constant.EMAIL_UN_EXITING);
        Log.info("Step4 - Enter an un-existing email address ");
        Log.info("Step5 - Click on Send Instructions button");
        String actualMsg = forgotPasswordPage.getErrorMsgAtForgotPassword();
        String expectedMsg = Constant.ERROR_MSG_FORGOT_PASSWORD_UN_EXITING;
        Assert.assertEquals(actualMsg, expectedMsg, "Email dress href not correctly");
    }
}
