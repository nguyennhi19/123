package PageObjects;

import Common.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MyTicketPage {
    //Locators
    private final By loc_btnCancel = By.xpath("//input[@value='Cancel']");
    private final By loc_btnDelete = By.xpath("//input[@value='Delete']");
    private final By loc_selDepartStation = By.name("FilterDpStation");
    private final By loc_selArriveStation = By.name("FilterArStation");
    private final By loc_txtDepartDate = By.name("FilterDpDate");
    private final By loc_selStatus = By.name("FilterStatus");
    private final By loc_btnApplyFilter = By.xpath("//input[@value='Apply Filter']");
    private final By loc_position = By.xpath("//table[@class='MyTable']//tbody//tr[last()]//td");


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

    public WebElement getPositionElement() {
        return Constant.driver.findElement(loc_position);
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

    public String getPositionText(){
        return this.getPositionElement().getText();
    }

    public String getTicketNeededDelete(String departFrom, String arriveAt, String seatType, String date){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']" +
                "//following-sibling::td[text()='%s']" +
                "//following-sibling::td[text()='%s']" +
                "//following-sibling::td//input[@value='Cancel']";
        return String.format(text, departFrom, arriveAt, seatType, date);
    }

    private void getScrollToElement(String departFrom, String arriveAt, String seatType, String date){
        WebElement element = Constant.driver.findElement(By.xpath(getTicketNeededDelete(departFrom, arriveAt, seatType, date)));
        ((JavascriptExecutor) Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Constant.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    }

    public void deleteTicket(String departFrom, String arriveAt, String seatType, String date) {
        this.getScrollToElement(departFrom, arriveAt, seatType, date);
        Constant.driver.findElement(By.xpath(getTicketNeededDelete(departFrom, arriveAt, seatType, date))).click();
        this.acceptPopup();

    }

    public void acceptPopup() {
        Constant.driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        Alert alert = Constant.driver.switchTo().alert();
        alert.accept();
    }
    public boolean verifyTicketWasDeleted(String actualMsg, String expectedMsg) {
        boolean flag = false;
        int lineNumberBeforeDelete = Integer.parseInt(actualMsg);
        int lineNumberAfterDelete  = Integer.parseInt(expectedMsg);
        int result = lineNumberAfterDelete - lineNumberBeforeDelete;
        if(result==1)
            flag = true;
        return flag;
    }
}
