package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    // Locators
    private final By txtEmailAddress = By.id("email");
    private final By btnSendInstructions = By.xpath("//input[@type='submit']");
    private final By lblErrorMsg = By.xpath("//p[@class='message error']");

    // Elements
    public WebElement getEmailAddress() {
        return Constant.DRIVER.findElement(txtEmailAddress);
    }

    public WebElement getBtnSendInstructions() {
        return Constant.DRIVER.findElement(btnSendInstructions);
    }

    public WebElement getErrorMsg(){
        return Constant.DRIVER.findElement(lblErrorMsg);
    }

    // Methods
    public void sendInstruction(String email){
        this.getEmailAddress().sendKeys(email);
        Utilities.scrollToElement(btnSendInstructions);
        this.getBtnSendInstructions().click();
    }

    public String getErrorMsgAtForgotPassword(){
        return this.getErrorMsg().getText();
    }
}

