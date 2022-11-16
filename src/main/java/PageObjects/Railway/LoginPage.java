package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends GeneralPage {
    //Locator
    private final String loginPageTitle = "Login Page";
    private final String myTicketPageTitle = "Manage Tickets";
    private final String changePasswordPageTitle = "Change password";
    private final By loc_txtEmail = By.xpath("//input[@id='username']");
    private final By loc_txtPassword = By.xpath("//input[@id='password']");
    private final By loc_btnLogin = By.xpath("//input[@value='Login']");
    private final By loc_myTicketTab = By.xpath("//span[contains(.,'My ticket')]");
    private final By loc_changePasswordTab = By.xpath("//span[contains(.,'Change password')]");
    private final By loc_btnLogout = By.xpath("//span[contains(.,'Log out')]");
    private final By _lblNamePage = By.xpath("//div[@id='content']/h1");
    private final By loc_linkForgotPasswordPage = By.xpath("//div[@id='content']/ul/li[3]/a");


    //Elements
    private WebElement getTextEmail(){
        return Constant.driver.findElement(loc_txtEmail);
    }

    private WebElement getTextPassword(){
        return Constant.driver.findElement(loc_txtPassword);
    }

    private WebElement getBtnLogin(){
        return Constant.driver.findElement(loc_btnLogin);
    }

    private WebElement getNamePage(){
        return Constant.driver.findElement(_lblNamePage);
    }

    public WebElement getForgotPasswordPage(){
        return Constant.driver.findElement(loc_linkForgotPasswordPage);
    }

    //Methods
    public void login(String email, String password){
        this.getTextEmail().sendKeys(email);
        this.getTextPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public boolean isAtLoginPage() {
        return getNamePage().getText().equals(loginPageTitle);
    }

    public boolean isAtMyTicketPage() {
        return getNamePage().getText().equals(myTicketPageTitle);
    }

    public boolean isAtChangPasswordPage() {
        return getNamePage().getText().equals(changePasswordPageTitle);
    }


    public void numberOfLogins(int i) {
        LoginPage loginPage = new LoginPage();
        int count = 1;
        while (count < i) {
            loginPage.login(Constant.EMAIL, Constant.INVALID_PASSWORD);
            count = count + 1;
        }
    }

    public boolean verifyMsgAccountHasNotBeenActivated(boolean check) {
        HomePage homePage = new HomePage();
        boolean flag = false;
        if(check == false){
            String actualMsg = homePage.getErrorMsg();
            String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;
            if(actualMsg.equals(expectedMsg)){
                flag = true;
            };
        }
        return flag;
    }

    public boolean verifyMyTicketTabDisplayed() {
        boolean flag = false;
        if (Constant.driver.findElements(loc_myTicketTab).size() == 1) {
            flag = true;
        }
        return flag;
    }

    public boolean verifyChangePasswordTabDisplayed() {
        boolean flag = false;
        if (Constant.driver.findElements(loc_changePasswordTab).size() != 0) {
            flag = true;
        }
        return flag;
    }

    public boolean verifyLogoutTabDisplayed() {
        boolean flag = false;
        if (Constant.driver.findElements(loc_btnLogout).size() != 0) {
            flag = true;
        }
        return flag;
    }

    private void getScrollToElement(){
        WebElement element = Constant.driver.findElement(loc_linkForgotPasswordPage);
        ((JavascriptExecutor) Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Constant.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    }

    public void goToForgotPasswordPage(){
        this.getScrollToElement();
        this.getForgotPasswordPage().click();
    }
}
