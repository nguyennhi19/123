package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {

    //Locator
    private final By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By changePasswordSuccessMsg = By.xpath("//p[@class='message success']");
    private final By changePasswordErrorMsg = By.xpath("//label[@class='validation-error']");

    //Elements
    private WebElement getTextCurrentPassword(){
        return Constant.driver.findElement(txtCurrentPassword);
    }

    private WebElement getTextNewPassword(){
        return Constant.driver.findElement(txtNewPassword);
    }

    private WebElement getTextConfirmPassword(){
        return Constant.driver.findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword(){
        return Constant.driver.findElement(btnChangePassword);
    }

    public WebElement getChangePasswordSuccess() {
        return Constant.driver.findElement(changePasswordSuccessMsg);
    }

    private WebElement getErrorMessageAtConfirmPassword(){
        return Constant.driver.findElement(changePasswordErrorMsg);
    }

    //Methods
    public void changePassword(String currentPassword,String newPassword,String confirmPassword){
        this.getTextCurrentPassword().sendKeys(currentPassword);
        this.getTextNewPassword().sendKeys(newPassword);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
    }

    public String getChangePasswordSuccessMsg(){
        return getChangePasswordSuccess().getText();
    }

    public String verifyErrorMessageAtConfirmPassword(){
        return this.getErrorMessageAtConfirmPassword().getText();
    }
}
