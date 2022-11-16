package Testcases.Railway;

import Common.Constant;
import PageObjects.ChangePasswordPage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangPasswordTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(description = "TC09 - User can change password")
    public void TC01(){
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
        loginPage.gotoChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        String actualMsg = changePasswordPage.getChangePasswordSuccessMsg();
        String expectedMsg = Constant.MSG_CHANGE_PASSWORD_SUCCESS;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
    }
}
