package PageObjects.Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locator
    private final By txtEmail = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By myTicketTab = By.xpath("//span[contains(.,'My ticket')]");
    private final By changePasswordTab = By.xpath("//span[contains(.,'Change password')]");
    private final By btnLogout = By.xpath("//span[contains(.,'Log out')]");
    private final By lblNamePage = By.xpath("//div[@id='content']/h1");
    private final By linkForgotPasswordPage = By.linkText("Forgot Password page");

    //Elements
    private WebElement getTextEmail(){
        return Constant.driver.findElement(txtEmail);
    }

    private WebElement getTextPassword(){
        return Constant.driver.findElement(txtPassword);
    }

    private WebElement getBtnLogin(){
        return Constant.driver.findElement(btnLogin);
    }

    private WebElement getNamePage(){
        return Constant.driver.findElement(lblNamePage);
    }

    private WebElement getForgotPasswordPage(){
        return Constant.driver.findElement(linkForgotPasswordPage);
    }

    //Methods
    public void login(String email, String password){
        this.getTextEmail().sendKeys(email);
        this.getTextPassword().sendKeys(password);
        Utilities.getScrollToElement(btnLogin);
        this.getBtnLogin().click();
    }

    public boolean isAtLoginPage() {
        String titleLoginPage = "Login Page";
        return getNamePage().getText().equals(titleLoginPage);
    }

    public boolean isAtMyTicketPage() {
        String titleMyTicketPage = "Manage Tickets";
        return getNamePage().getText().equals(titleMyTicketPage);
    }

    public boolean isAtChangPasswordPage() {
        String titleChangePasswordPage = "Change password";
        return getNamePage().getText().equals(titleChangePasswordPage);
    }


    public void checkNumberOfLogins(int i) {
        LoginPage loginPage = new LoginPage();
        int count = 1;
        while (count < i) {
            loginPage.login(Constant.EMAIL, Constant.INVALID_PASSWORD);
            count = count + 1;
        }
    }

    public boolean verifyMyTicketTabDisplayed() {
        return Constant.driver.findElements(myTicketTab).size() != 0;
    }

    public boolean verifyChangePasswordTabDisplayed() {
        return Constant.driver.findElements(changePasswordTab).size() != 0;
    }

    public boolean verifyLogoutTabDisplayed() {
        return Constant.driver.findElements(btnLogout).size() != 0;
    }

    public void goToForgotPasswordPage(){
        Utilities.getScrollToElement(linkForgotPasswordPage);
        this.getForgotPasswordPage().click();
    }
}
