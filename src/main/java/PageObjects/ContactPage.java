package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {
    //Locator
    private final By loc_hrefEmailDress = By.xpath("//a[@href = 'mailto:thanh.viet.le@logigear.com']");

    //Elements
    private WebElement getHrefEmailDress(){
        return Constant.driver.findElement(loc_hrefEmailDress);
    }

    //Methods
    public String getHrefEmailDressAtContactPage(){
        return "mailto:" + this.getHrefEmailDress().getText();
    }
}
