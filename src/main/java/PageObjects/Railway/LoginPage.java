package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locator
    private final By loc_txtEmail = By.xpath("//input[@id='username']");
    private final By loc_txtPassword = By.xpath("//input[@id='password']");
    private final By loc_btnLogin = By.xpath("//input[@value='Login']");
    private final By loc_myTicketTab = By.xpath("//span[contains(.,'My ticket')]");
    private final By loc_changePasswordTab = By.xpath("//span[contains(.,'Change password')]");
    private final By loc_btnLogout = By.xpath("//span[contains(.,'Log out')]");

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

    //Methods
    public void login(String email, String password){
        this.getTextEmail().sendKeys(email);
        this.getTextPassword().sendKeys(password);
        this.getBtnLogin().click();
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
}
