package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    // Locators
    private final By txtEmailAddress = By.xpath("//input[@id='email']");
    private final By btnSendInstructions = By.xpath("//input[@type='submit']");
    private final By errorMsg = By.xpath("//p[@class='message error']");

    // Elements

    public WebElement getEmailAddress() {
        return Constant.driver.findElement(txtEmailAddress);
    }

    public WebElement getBtnSendInstructions() {
        return Constant.driver.findElement(btnSendInstructions);
    }

    public WebElement getErrorMsg(){
        return Constant.driver.findElement(errorMsg);
    }

    // Methods
    public void sendInstruction(String email){
        Utilities.getScrollToElement(btnSendInstructions);
        this.getEmailAddress().sendKeys(email);
        this.getBtnSendInstructions().click();
    }

    public String getErrorMsgAtForgotPassword(){
        return this.getErrorMsg().getText();
    }
}
