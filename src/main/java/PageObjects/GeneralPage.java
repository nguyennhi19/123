package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final String tabMenu = "%s";
    //Locator
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessage = By.xpath("//div[@id='content']/p");

    //Elements

    //Methods
    public void gotoMenuTab(String tabName){
        Constant.DRIVER.findElement(By.linkText(String.format(tabMenu,tabName))).click();
    }
}
