package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class GeneralPage {
    //Locators
    private final String titleLogin = "Login Page";
    private final String titleBookTicket = "Book ticket";
    private final By loc_tabLogin = By.linkText("Login");
    private final By loc_tabLogout = By.linkText("Log out");
    private final By loc_tabBookTicket = By.linkText("Book ticket");
    private final By loc_tabContact = By.linkText("Contact");
    private final By loc_tabRegister = By.linkText("Register");
    private final By loc_tabChangePassword = By.linkText("Change password");
    private final By loc_tabTimeTable = By.linkText("Timetable");
    private final By loc_tabMyTicket = By.linkText("My ticket");
    private final By loc_WelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By loc_errorMessage = By.xpath("//div[@id='content']/p");
    private final By loc_txtTitleBookTicket = By.xpath("//h1[contains(.,'Book ticket')]");
    private final By loc_txtTitleLogin = By.xpath("//h1[contains(.,'Login Page')]");

    //Elements
    private WebElement getTabLogin() {
        return Constant.driver.findElement(loc_tabLogin);
    }

    private WebElement getTabLogout() {
        return Constant.driver.findElement(loc_tabLogout);
    }

    private WebElement getTabBookTicket() {
        return Constant.driver.findElement(loc_tabBookTicket);
    }

    private WebElement getTabContact() {
        return Constant.driver.findElement(loc_tabContact);
    }

    private WebElement getTabRegister() {
        return Constant.driver.findElement(loc_tabRegister);
    }

    private WebElement getTabChangePassword() {
        return Constant.driver.findElement(loc_tabChangePassword);
    }

    private WebElement getTabTimetable() {
        return Constant.driver.findElement(loc_tabTimeTable);
    }

    private WebElement getTabMyTicket() {
        return Constant.driver.findElement(loc_tabMyTicket);
    }

    private WebElement getWelcomeMessage() {
        return Constant.driver.findElement(loc_WelcomeMessage);
    }

    private WebElement getErrorMessage() {
        return Constant.driver.findElement(loc_errorMessage);
    }

    public WebElement getLoginPage() {
        return Constant.driver.findElement(loc_txtTitleLogin);
    }

    public WebElement getBookTicketPage() {
        return Constant.driver.findElement(loc_txtTitleBookTicket);
    }

    //Methods
    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public String getWelcomeMessageText() {
        return this.getWelcomeMessage().getText();
    }

    public void logout() {
        if (this.getTabLogout() != null)
            this.getTabLogout().click();
    }


    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoContactPage() {
        this.getTabContact().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void gotoTimetablePage() {
        this.getTabTimetable().click();
    }

    public void gotoMyTicketPage() {
        this.getTabMyTicket().click();
    }

    public String getErrorMsg() {
        return this.getErrorMessage().getText();
    }

    public boolean isAtBookTicketPage() {
        return this.getBookTicketPage().getText().equals(titleBookTicket);
    }

    public boolean isAtLoginPage() {
        return this.getLoginPage().getText().equals(titleLogin);
    }

    private void getScrollToElement(){
        WebElement element = Constant.driver.findElement(By.id("id_of_element"));
        ((JavascriptExecutor) Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Constant.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    }
}
