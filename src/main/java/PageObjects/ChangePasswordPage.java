package PageObjects;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {

    //Locator
    private final By loc_txtCurrentPassword = By.xpath("//input[@id=\"currentPassword\"]");
    private final By loc_txtNewPassword = By.xpath("//input[@id=\"newPassword\"]");
    private final By loc_txtConfirmPassword = By.xpath("//input[@id=\"confirmPassword\"]");
    private final By loc_btnChangePassword = By.xpath("//input[@value=\"Change Password\"]");

    //Elements

    private WebElement getTextCurrentPassword(){
        return Constant.driver.findElement(loc_txtCurrentPassword);
    }

    private WebElement getTextNewPassword(){
        return Constant.driver.findElement(loc_txtNewPassword);
    }

    private WebElement getTextConfirmPassword(){
        return Constant.driver.findElement(loc_txtConfirmPassword);
    }

    private WebElement getBtnChangePassword(){
        return Constant.driver.findElement(loc_btnChangePassword);
    }

    //Methods
    public void changePassword(String currentPassword,String newPassword,String confirmPassword){
        this.getTextCurrentPassword().sendKeys(currentPassword);
        this.getTextNewPassword().sendKeys(newPassword);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
    }
}
