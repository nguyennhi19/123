package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ServerError {
    private final By serverErrorMsg = By.xpath("//h1");

    // Elements
    public WebElement getServerError(){
        return Constant.driver.findElement(serverErrorMsg);
    }

    // Methods
    public String getServerErrorMsg() {
        return getServerError().getText();
    }

    public boolean verifyMailBoxDisplayed(){
        boolean check = false;
        if(getServerErrorMsg().contains(Constant.ErrorPage)){
            check = true;
        }
        return check;
    }
}
