package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

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
    private void getScrollToElement(){
        WebElement element = Constant.driver.findElement(loc_btnSendInstructions);
        ((JavascriptExecutor) Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Constant.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    }

    public void SendInstruction(String email){
        this.getScrollToElement();
        this.getEmailAddress().sendKeys(email);
        this.getBtnSendInstructions().click();
    }


}
