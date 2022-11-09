package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RegisterPage {
    //Locator
    private final By loc_txtEmail = By.xpath("//input[@id='email']");
    private final By loc_txtPassword = By.xpath("//input[@id=\"password\"]");
    private final By loc_txtConfirmPassword = By.xpath("//input[@id=\"confirmPassword\"]");
    private final By loc_txtPid = By.xpath("//input[@id=\"pid\"]");
    private final By loc_btnRegister = By.xpath("//input[@value=\"Register\"]");
    private final By registerSuccessMsg = By.xpath("//div[@id='content']/p");

    //Elements

    private WebElement getTextEmail(){
        return Constant.driver.findElement(loc_txtEmail);
    }

    private WebElement getTextPassword(){
        return Constant.driver.findElement(loc_txtPassword);
    }

    private WebElement getTextConfirmPassword(){
        return Constant.driver.findElement(loc_txtConfirmPassword);
    }

    private WebElement getTextPid(){
        return Constant.driver.findElement(loc_txtPid);
    }

    private WebElement getBtnRegister(){
        return Constant.driver.findElement(loc_btnRegister);
    }

    private WebElement getRegisterSuccess(){
        return Constant.driver.findElement(registerSuccessMsg);
    }

    //Methods
    private void getScrollToElement(){
        WebElement element = Constant.driver.findElement(loc_btnRegister);
        ((JavascriptExecutor) Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Constant.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    }

    public void register(String email,String password,String confirmPassword, String pid){
        this.getTextEmail().sendKeys(email);
        this.getTextPassword().sendKeys(password);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
        this.getTextPid().sendKeys(pid);
        this.getScrollToElement();
        this.getBtnRegister().click();
    }

    public String getRegisterSuccessMsg() {
        return getRegisterSuccess().getText();
    }
}
