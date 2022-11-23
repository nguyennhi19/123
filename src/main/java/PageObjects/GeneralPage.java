package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locator
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessage = By.xpath("//div[@id='content']/p");

    private WebElement getWelcomeMessage() {
        return Constant.DRIVER.findElement(lblWelcomeMessage);
    }

    private WebElement getErrorMessage() {
        return Constant.DRIVER.findElement(lblErrorMessage);
    }

    //Methods
    public void gotoMenuTab(String tabName){
        String tabMenu = "%s";
        Constant.DRIVER.findElement(By.linkText(String.format(tabMenu,tabName))).click();
    }

    public String getWelcomeMessageText() {
        return this.getWelcomeMessage().getText();
    }

    public String getErrorMsg() {
        return this.getErrorMessage().getText();
    }
}
