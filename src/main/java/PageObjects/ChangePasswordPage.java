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


    //Methods

}