package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ServerError {
    private final By lblServerErrorMsg = By.xpath("//h1");

    // Elements
    public WebElement getServerError(){
        return Constant.DRIVER.findElement(lblServerErrorMsg);
    }

    // Methods
    public String getServerErrorMsg() {
        return getServerError().getText();
    }

    public boolean verifyMailBoxDisplayed(){
        return getServerErrorMsg().contains(Constant.ErrorPage);
    }
}