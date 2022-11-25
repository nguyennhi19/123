package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage {
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
    private final By lblAmount = By.xpath("//table[@class='MyTable']//td[count(//table[@class='MyTable']//th[text()= 'Status']/preceding-sibling::th)+1][text()='New']");

    //Elements
    private WebElement getDepartStation() {
        return Constant.DRIVER.findElement(cbbDepartStation);
    }

    private WebElement getArriveStation() {
        return Constant.DRIVER.findElement(cbbArriveStation);
    }

    private WebElement getDepartDate() {
        return Constant.DRIVER.findElement(txtDepartDate);
    }

    private WebElement getStatus() {
        return Constant.DRIVER.findElement(cbbStatus);
    }

    private WebElement getApplyFilterElement() {
        return Constant.DRIVER.findElement(btnApplyFilter);
    }

    private WebElement getErrorMsg() {
        return Constant.DRIVER.findElement(lblErrorMsg);
    }


    //Methods
    private Select getDepartStationElement() {
        return new Select(getDepartStation());
    }

    private Select getArriveStationElement() {
        return new Select(getArriveStation());
    }

    private Select getStatusElement() {
        return new Select(getStatus());
    }

    public void filter(String departSt, String arriveSt, String departDate, String status){
        if (departSt.equals("")) {
            this.getDepartStationElement().selectByVisibleText("Ignore");
        } else {
            this.getDepartStationElement().selectByVisibleText(departSt);
        }
        if (arriveSt.equals("")) {
            this.getArriveStationElement().selectByVisibleText("Ignore");
        } else {
            this.getArriveStationElement().selectByVisibleText(arriveSt);
        }
        this.getDepartDate().sendKeys(departDate);
        if (status.equals("")) {
            this.getStatusElement().selectByVisibleText("Ignore");
        } else {
            this.getStatusElement().selectByVisibleText(status);
        }
        this.getApplyFilterElement().click();
    }

    public int checkFilter(String filterName, String value){
        String text = "//table[@class='MyTable']//td[count(//table[@class='MyTable']//th[text()= '%s']/preceding-sibling::th)+1][text()='%s']";
        By rowConditionElement = By.xpath(String.format(text,filterName,value));
        return Constant.DRIVER.findElements(rowConditionElement).size();
    }

    public int checkRow(){
        By rowElement = By.xpath("//table[@class='MyTable']//tr");
        return Constant.DRIVER.findElements(rowElement).size() - 1;
    }

    public String getErrorMsgAtFilter(){
        return this.getErrorMsg().getText();
    }

    public boolean checkFilter(int rowBeforeFilter, int rowAfterFilter) {
        int rowsAfterFilter = checkRow();
        return rowBeforeFilter == rowAfterFilter && rowAfterFilter == rowsAfterFilter;
    }

}
