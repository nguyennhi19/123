package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    private final By lblTitleHome = By.xpath("//h1[contains(.,'Welcome to Safe Railway')]");

    //Elements
    public WebElement getHomePage() {
        return Constant.DRIVER.findElement(lblTitleHome);
    }

    //Methods
    public boolean isAtHomePage() {
        String titleHome = "Welcome to Safe Railway";
        return this.getHomePage().getText().equals(titleHome);
    }
}
