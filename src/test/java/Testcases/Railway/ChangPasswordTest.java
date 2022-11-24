package Testcases.Railway;

import Common.*;
import Common.Log;
import DataObjects.Login;
import PageObjects.ChangePasswordPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangPasswordTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    Login login;

    @Test(description = "TC01 - User can change password")
    public void TC01(){
        Log.info("TC01 - User can change password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_CHANGE_PASSWORD);
        Log.info("Step3 - Click on Change Password tab");
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        Log.info("Step4 - Enter valid value into all fields.");
        Log.info("Step5 - Click on Change Password button");
        String actualMsg = changePasswordPage.getChangePasswordSuccessMsg();
        String expectedMsg = Constant.MSG_CHANGE_PASSWORD_SUCCESS;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
    }

    @Test(description = "TC02 - User can't change password with invalid current password")
    public void TC02(){
        Log.info("TC02 - User can't change password with invalid current password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_CHANGE_PASSWORD);
        Log.info("Step3 - Click on Change Password tab");
        changePasswordPage.changePassword(Constant.INVALID_PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        Log.info("Step4 - Change password with invalid current password");
        String actualMsg = changePasswordPage.getErrorMsgConfirmPassword();
        String expectedMsg = Constant.MSG_CHANGE_PASSWORD_INVALID_PASSWORD;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
    }

    @Test(description = "TC03 - User can't change password with empty current password")
    public void TC03(){
        Log.info("TC02 - User can't change password with invalid current password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_CHANGE_PASSWORD);
        Log.info("Step3 - Click on Change Password tab");
        changePasswordPage.changePassword("", Constant.PASSWORD, Constant.PASSWORD);
        Log.info("Step4 - Change password with empty current password");
        String actualMsg = changePasswordPage.getErrorMsgConfirmPassword();
        String expectedMsg = Constant.MSG_CHANGE_PASSWORD_INVALID_PASSWORD;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
    }

    @Test(description = "TC03 - User can't change password with invalid new password")
    public void TC04(){
        Log.info("TC03 - User can't change password with invalid new password");
        Log.info("Step1 - Navigate to QA Railway Website");
        homePage.gotoMenuTab(Constant.TAB_LOGIN);
        login = new Login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.login(login);
        Log.info("Step2 - Login with valid account");
        homePage.gotoMenuTab(Constant.TAB_CHANGE_PASSWORD);
        Log.info("Step3 - Click on Change Password tab");
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.INVALID_PASSWORD, Constant.PASSWORD);
        Log.info("Step4 - Change password with invalid new password");
        String actualMsg = changePasswordPage.getErrorMsgConfirmPassword();
        String expectedMsg = Constant.MSG_CHANGE_PASSWORD_INVALID_NEW_PASSWORD;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
    }
}