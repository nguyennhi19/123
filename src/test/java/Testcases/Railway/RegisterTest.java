package Testcases.Railway;

import Common.*;
import DataObjects.Login;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    Login login;

    @Test(description = "TC01 -User can create new account")
    public void TC01(){
        homePage.gotoMenuTab(Constant.TAB_REGISTER);
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        String actualMsg = registerPage.getRegisterSuccessMsg();
        String expectedMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(actualMsg, expectedMsg, "The message content is not displayed correctly");
    }
    @Test(description = "TC02 -User can't login with an account hasn't been activated")
    public void TC02(){
        homePage.gotoMenuTab(Constant.TAB_REGISTER);
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Assert.assertTrue(loginPage.isAtLoginPage(),
                "User can login success when account hasn't been activated");
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;
        Assert.assertEquals(actualMsg,expectedMsg,"error message not displayed as expected");
    }

    @Test(description = "TC03 - User can't create account with Confirm password is not the same with Password")
    public void TC03() {
        homePage.gotoMenuTab(Constant.TAB_REGISTER);
        registerPage.register(Constant.EMAIL_REGISTER,Constant.PASSWORD,Constant.CONFIRM_INVALID_PASSWORD,Constant.PID);
        String actualMsg = registerPage.getRegisterFailedMsg();
        String expectedMsg = Constant.MSG_REGISTER_FAILED;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly");
    }

    @Test(description = "TC04 - User can't create account while password and PID fields are empty")
    public void TC04(){
        homePage.gotoMenuTab(Constant.TAB_REGISTER);
        registerPage.register(Constant.EMAIL_REGISTER,"",Constant.CONFIRM_PASSWORD,"");
        String actualMsg = registerPage.getRegisterFailedMsg();
        String expectedMsg = Constant.MSG_REGISTER_FAILED;
        Assert.assertEquals(actualMsg,expectedMsg,"The main message content is not displayed correctly");
        actualMsg = registerPage.getPassWordFieldMsg();
        expectedMsg = Constant.MSG_PASSWORD_FIELD;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content of password fields is not displayed correctly");
        actualMsg = registerPage.getPIDFieldMsg();
        expectedMsg = Constant.MSG_PID_FIELD;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content of PID fields is not displayed correctly");
    }

}
