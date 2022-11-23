package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {
    //Locator
    private final By hrefEmailDress = By.xpath("//a[@href = 'mailto:thanh.viet.le@logigear.com']");

    //Elements
    private WebElement getHrefEmailDress(){
        return Constant.DRIVER.findElement(hrefEmailDress);
    }

    //Methods
    public String getHrefEmailDressAtContactPage(){
        return "mailto:" + this.getHrefEmailDress().getText();
    }
}