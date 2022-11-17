package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage {
    //Locators
    private final By selDepartStation = By.name("FilterDpStation");
    private final By selArriveStation = By.name("FilterArStation");
    private final By txtDepartDate = By.name("FilterDpDate");
    private final By selStatus = By.name("FilterStatus");
    private final By titleFilter = By.xpath("//div[@class = 'Filter']//strong");
    private final By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");
    private final By position = By.xpath("//table[@class='MyTable']//tbody//tr[last()]//td");
    private final By note = By.xpath("//li[text() = 'You currently book 7 tickets, you can book 3 more.']");


    //Elements
    private Select getDepartStationElement() {
        return new Select(Constant.driver.findElement(selDepartStation));
    }

    private Select getArriveStationElement() {
        return new Select(Constant.driver.findElement(selArriveStation));
    }

    private WebElement getDepartDate() {
        return Constant.driver.findElement(txtDepartDate);
    }

    private Select getStatus() {
        return new Select(Constant.driver.findElement(selStatus));
    }

    private WebElement getApplyFilterElement() {
        return Constant.driver.findElement(btnApplyFilter);
    }

    private WebElement getTitleFilterElement() {
        return Constant.driver.findElement(titleFilter);
    }

    public WebElement getPositionElement() {
        return Constant.driver.findElement(position);
    }

    public String getNote() {
        return Constant.driver.findElement(note).getText();
    }

    //Methods
    public void Filter(String departSt, String arriveSt, String departDate, String status){
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
            this.getStatus().selectByVisibleText("Ignore");
        } else {
            this.getStatus().selectByVisibleText(status);
        }
        this.getApplyFilterElement().click();
    }

    public static int CheckRowConditionFilter(String filterName, String value){
        String text = "//table[@class='MyTable']//td[count(//table[@class='MyTable']//th[text()= '%s']/preceding-sibling::th)+1][text()='%s']";
        By rowConditionElement = By.xpath(String.format(text,filterName,value));
        return Constant.driver.findElements(rowConditionElement).size();
    }

    public static int CheckRowConditionsFilter(String filterName, String value,String value1, String value2, String value3) {
        String text = "//table[@class='MyTable']//td[count(//table[@class='MyTable']//th[text()= '%s']/preceding-sibling::th)+1][text()='%s']";
        String text1 = "/following-sibling::td[text() = '%s']";
        String text2 = "/following-sibling::td[text() = '%s']";
        String text3 = "/following-sibling::td[text() = '%s']";
        if(value1.equals("")){
            text1 = "";
        }
        if(value2.equals("")){
             text2 = "";
        }
        if(value3.equals("")){
             text3 = "";
        }
        By rowConditionElement = By.xpath(String.format(text+text1+text2+text3,filterName,value,value1,value2,value3));
        return Constant.driver.findElements(rowConditionElement).size();
    }

    public static int checkRow(){
        By rowElement = By.xpath("//table[@class='MyTable']//tr");
        return Constant.driver.findElements(rowElement).size() - 1;
    }

    public boolean checkFilterCorrect(int rowConditionBeforeFilter, int rowConditionAfterFilter) {
        int rowAfterFilter = checkRow();
        System.out.println(rowConditionBeforeFilter);
        System.out.println(rowConditionAfterFilter);
        System.out.println(rowAfterFilter);
        if (rowConditionBeforeFilter != rowConditionAfterFilter) {
            return false;
        } else {
            if (rowConditionAfterFilter != rowAfterFilter) {
                return false;
            } else {
                return true;
            }
        }
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

    public void deleteTicket(String departFrom, String arriveAt, String seatType, String date) {
        Utilities.getScrollToElement(By.xpath(getTicketNeededDelete(departFrom, arriveAt, seatType, date)));
        Constant.driver.findElement(By.xpath(getTicketNeededDelete(departFrom, arriveAt, seatType, date))).click();
        this.acceptPopup();
    }

    public void acceptPopup() {
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

    public boolean isTitleFilterForm(){
        System.out.println(getNote().contains(getAmountTicket()));

        boolean flag = false;
        if (this.getTitleFilterElement().getText().equals(Constant.TITLE_FILTER_FORM)){
            flag = true;
        }
        return flag;
    }

    public static String getAmountTicket(){
        By amountTicket = By.xpath("//table[@class='MyTable']//td[count(//table[@class='MyTable']//th[text()= 'Status']/preceding-sibling::th)+1][text()='New']");
        return String.valueOf(Constant.driver.findElements(amountTicket).size());
    }

    public boolean checkAmountTicket(){
        String text = " book "+ getAmountTicket() +" tickets";
        return getNote().contains(text);
    }

}
