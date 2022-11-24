package Testcases.Railway;

import Common.*;
import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC01 -User can create new account")
    public void TC01(){
        Log.info("TC01 -User can create new account");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_REGISTER);
        Log.info("Step2 - Click Register tab");
        registerPage.register(registerPage.createGenerateEmail(),Constant.PASSWORD,Constant.CONFIRM_PASSWORD,Constant.PID);
        Log.info("Step3 - Register with valid data");
        String actualMsg = registerPage.getRegisterSuccessMsg();
        String expectedMsg = Constant.MSG_REGISTER_SUCCESSFULLY;
        Assert.assertEquals(actualMsg, expectedMsg, "The message content is not displayed correctly");
    }

    @Test(description = "TC03 - User can't create account with Confirm password is not the same with Password")
    public void TC02() {
        Log.info("TC03 - User can't create account with Confirm password is not the same with Password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_REGISTER);
        Log.info("Step2 - Click Register tab");
        registerPage.register(registerPage.createGenerateEmail(),Constant.PASSWORD,Constant.CONFIRM_INVALID_PASSWORD,Constant.PID);
        Log.info("Step3 - Register with Confirm password is not the same with Password");
        String actualMsg = registerPage.getRegisterFailedMsg();
        String expectedMsg = Constant.MSG_REGISTER_FAILED;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly");
    }

    @Test(description = "TC04 - User can't create account while password and PID fields are empty")
    public void TC03(){
        Log.info("TC04 - User can't create account while password and PID fields are empty");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_REGISTER);
        Log.info("Step2 - Click Register tab");
        registerPage.register(registerPage.createGenerateEmail(),"",Constant.CONFIRM_PASSWORD,"");
        Log.info("Step3 - Register with password and PID fields are empty");
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
