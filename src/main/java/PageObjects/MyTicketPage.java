package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage {
    BookTicketPage bookTicketPage = new BookTicketPage();
    //Locators
    private final By lblNamePage = By.xpath("//div[@id='content']/h1");
    private final By cbbDepartStation = By.name("FilterDpStation");
    private final By cbbArriveStation = By.name("FilterArStation");
    private final By txtDepartDate = By.name("FilterDpDate");
    private final By cbbStatus = By.name("FilterStatus");
    private final By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");
    private final By lblFilter = By.xpath("//div[@class = 'Filter']//strong");
    private final By position = By.xpath("//table[@class='MyTable']//tbody//tr[last()]//td");
    private final By lblNote = By.xpath("//li[starts-with(text() , 'You currently book')]");
    private final By lblErrorMsg = By.xpath("//div[@class='error message']");
    //Elements


    //Methods

}
