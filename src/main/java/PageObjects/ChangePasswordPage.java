package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    //Locator
    private final By lblNamePage = By.xpath("//div[@id='content']/h1");
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By lblSuccessMsg = By.xpath("//p[@class='message success']");
    private final By lblErrorMsg = By.xpath("//label[@class='validation-error']");

    //Elements
    private WebElement getNamePage(){
        return Constant.DRIVER.findElement(lblNamePage);
    }
    private WebElement getTextCurrentPassword(){
        return Constant.DRIVER.findElement(txtCurrentPassword);
    }

    private WebElement getTextNewPassword(){
        return Constant.DRIVER.findElement(txtNewPassword);
    }

    private WebElement getTextConfirmPassword(){
        return Constant.DRIVER.findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword(){
        return Constant.DRIVER.findElement(btnChangePassword);
    }

    public WebElement getChangePasswordSuccess() {
        return Constant.DRIVER.findElement(lblSuccessMsg);
    }

    private WebElement getErrorMsgAtConfirmPassword(){
        return Constant.DRIVER.findElement(lblErrorMsg);
    }

    //Methods
    public boolean isAtChangPasswordPage() {
        String titleChangePasswordPage = "Change password";
        return getNamePage().getText().equals(titleChangePasswordPage);
    }

    public void changePassword(String currentPassword,String newPassword,String confirmPassword){
        this.getTextCurrentPassword().sendKeys(currentPassword);
        this.getTextNewPassword().sendKeys(newPassword);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
    }

    public String getChangePasswordSuccessMsg(){
        return getChangePasswordSuccess().getText();
    }

    public String getErrorMsgConfirmPassword(){
        return this.getErrorMsgAtConfirmPassword().getText();
    }
}