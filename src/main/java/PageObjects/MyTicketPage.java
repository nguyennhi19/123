package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {
    //Locators
    private final By loc_btnCancel = By.xpath("//input[@value='Cancel']");
    private final By loc_btnDelete = By.xpath("//input[@value='Delete']");
    private final By loc_selDepartStation = By.name("FilterDpStation");
    private final By loc_selArriveStation = By.name("FilterArStation");
    private final By loc_txtDepartDate = By.name("FilterDpDate");
    private final By loc_selStatus = By.name("FilterStatus");
    private final By loc_btnApplyFilter = By.xpath("//input[@value='Apply Filter']");

    //Elements
    private WebElement getCancelElement() {
        return Constant.driver.findElement(loc_btnCancel);
    }

    private WebElement getDeleteElement() {
        return Constant.driver.findElement(loc_btnDelete);
    }

    private WebElement getDepartStationElement() {
        return Constant.driver.findElement(loc_selDepartStation);
    }

    private WebElement getArriveStationElement() {
        return Constant.driver.findElement(loc_selArriveStation);
    }

    private WebElement getDepartDate() {
        return Constant.driver.findElement(loc_txtDepartDate);
    }

    private WebElement getStatus() {
        return Constant.driver.findElement(loc_selStatus);
    }

    private WebElement getApplyFilterElement() {
        return Constant.driver.findElement(loc_btnApplyFilter);
    }

    //Methods
    public void CancelBookTicket(){
        this.getCancelElement().click();
    }

    public void DeleteBookTicket(){
        this.getDeleteElement().click();
    }

    public void chooseDepartStation(String departStation) {
        this.getDepartStationElement().click();
        Constant.driver.findElement(By.xpath("//select[@name='FilterDpStation']//option[text()='"+departStation+"']"));
    }

    public void chooseArriveStation(String arriveStation) {
        this.getArriveStationElement().click();
        Constant.driver.findElement(By.xpath("//select[@name='FilterArStation']//option[text()='"+arriveStation+"']"));
    }

    public void chooseStatus(String departDate) {
        this.getStatus().click();
        Constant.driver.findElement(By.xpath("//select[@name='FilterStatus']//option[text()='"+departDate+"']"));
    }

    public void Filter(String departSt, String arriveSt, String departDate, String status){
        this.chooseDepartStation(departSt);
        this.chooseArriveStation(arriveSt);
        this.getDepartDate().sendKeys(departDate);
        this.chooseStatus(status);
        this.getApplyFilterElement();
    }
}
