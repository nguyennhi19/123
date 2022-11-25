package PageObjects;

import Common.*;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    //Locator
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By lblSuccessMsg = By.xpath("//div[@id='content']/p");
    private final By lblFailedMsg = By.xpath("//p[@class='message error']");
    private final By lblPasswordFieldMsg = By.xpath("//li[@class='password']/label[@class='validation-error']");
    private final By lblPIDMsg = By.xpath("//li[@class='pid-number']/label[@class='validation-error']");

    //Elements


    //Methods

}
