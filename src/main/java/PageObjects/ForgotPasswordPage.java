package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    // Locators
    private final By loc_txtEmailAddress = By.xpath("//input[@id='email']");
    private final By loc_btnSendInstructions = By.xpath("//input[@type='submit']");

    // Elements

    public WebElement getEmailAddress() {
        return Constant.driver.findElement(loc_txtEmailAddress);
    }

    public WebElement getBtnSendInstructions() {
        return Constant.driver.findElement(loc_btnSendInstructions);
    }

    // Methods
    public void SendInstruction(String email){
        this.getEmailAddress().sendKeys(email);
        this.getBtnSendInstructions().click();
    }
}
