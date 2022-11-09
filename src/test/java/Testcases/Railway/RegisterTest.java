package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase{
    RegisterPage registerPage = new RegisterPage();
    GeneralPage generalPage = new GeneralPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can create new account")
    public void TC07(){
        homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        String actualMsg = registerPage.getRegisterSuccessMsg();
        String expectedMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(actualMsg, expectedMsg, "The message content is not displayed correctly");
    }
    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08(){
        generalPage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        generalPage.gotoLoginPage();
        loginPage.login(Constant.EMAIL_REGISTER, Constant.PASSWORD);
        Assert.assertTrue(loginPage.isAtLoginPage(),
                "User can login success when account hasn't been activated");
    }

}
