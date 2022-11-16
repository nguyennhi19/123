package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locator
    private final By welcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By errorMessage = By.xpath("//div[@id='content']/p");
    private final By txtTitleBookTicket = By.xpath("//h1[contains(.,'Book ticket')]");
    private final By txtTitleLogin = By.xpath("//h1[contains(.,'Login Page')]");
    private final By txtTitleHome = By.xpath("//h1[contains(.,'Welcome to Safe Railway')]");

    //Elements
    private WebElement getWelcomeMessage() {
        return Constant.driver.findElement(welcomeMessage);
    }

    private WebElement getErrorMessage() {
        return Constant.driver.findElement(errorMessage);
    }

    public WebElement getLoginPage() {
        return Constant.driver.findElement(txtTitleLogin);
    }

    public WebElement getBookTicketPage() {
        return Constant.driver.findElement(txtTitleBookTicket);
    }

    public WebElement getHomePage() {
        return Constant.driver.findElement(txtTitleHome);
    }

    //Methods
    public void gotoMenuTap(String tabName){
        String tabMenu = "%s";
        Constant.driver.findElement(By.linkText(String.format(tabMenu,tabName))).click();
    }

    public String getWelcomeMessageText() {
        return this.getWelcomeMessage().getText();
    }


    public String getErrorMsg() {
        return this.getErrorMessage().getText();
    }

    public boolean isAtBookTicketPage() {
        String titleBookTicket = "Book ticket";
        return this.getBookTicketPage().getText().equals(titleBookTicket);
    }

    public boolean isAtHomePage() {
        String titleHome = "Welcome to Safe Railway";
        return this.getHomePage().getText().equals(titleHome);
    }

    public boolean isAtLoginPage() {
        String titleLogin = "Login Page";
        return this.getLoginPage().getText().equals(titleLogin);
    }
}
