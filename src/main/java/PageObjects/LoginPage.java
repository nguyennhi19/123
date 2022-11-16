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
    private WebElement getTextEmail(){
        return Constant.DRIVER.findElement(txtEmail);
    }

    private WebElement getTextPassword(){
        return Constant.DRIVER.findElement(txtPassword);
    }

    private WebElement getBtnLogin(){
        return Constant.DRIVER.findElement(btnLogin);
    }

    private WebElement getNamePage(){
        return Constant.DRIVER.findElement(lblNamePage);
    }

    private WebElement getForgotPasswordPage(){
        return Constant.DRIVER.findElement(linkForgotPasswordPage);
    }

    //Methods
    public void login(Login login) {
        this.getTextEmail().sendKeys(login.getEmail());
        this.getTextPassword().sendKeys(login.getPassword());
        Utilities.scrollToElement(btnLogin);
        this.getBtnLogin().click();
    }

    public boolean isAtLoginPage() {
        String titleLoginPage = "Login Page";
        return getNamePage().getText().equals(titleLoginPage);
    }

    public void checkNumberOfLogins(int i) {
        Login login;
        int count = 1;
        while (count < i) {
            login = new Login(Constant.EMAIL, Constant.INVALID_PASSWORD);
            login(login);
            count = count + 1;
        }
    }

    public boolean verifyMyTicketTabDisplayed() {
        return Constant.DRIVER.findElements(myTicketTab).size() != 0;
    }

    public boolean verifyChangePasswordTabDisplayed() {
        return Constant.DRIVER.findElements(changePasswordTab).size() != 0;
    }

    public boolean verifyLogoutTabDisplayed() {
        return Constant.DRIVER.findElements(btnLogout).size() != 0;
    }

    public void goToForgotPasswordPage(){
        Utilities.scrollToElement(linkForgotPasswordPage);
        this.getForgotPasswordPage().click();
    }
}
