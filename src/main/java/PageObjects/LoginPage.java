package PageObjects;

import Common.*;
import DataObjects.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locator
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By myTicketTab = By.xpath("//span[contains(.,'My ticket')]");
    private final By changePasswordTab = By.xpath("//span[contains(.,'Change password')]");
    private final By btnLogout = By.xpath("//span[contains(.,'Log out')]");
    private final By lblNamePage = By.xpath("//div[@id='content']/h1");
    private final By linkForgotPasswordPage = By.linkText("Forgot Password page");

    //Elements


    //Methods

}
