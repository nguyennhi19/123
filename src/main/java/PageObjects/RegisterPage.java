package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    //Locator
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPid = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By registerSuccessMsg = By.xpath("//div[@id='content']/p");
    private final By registerFailedMsg = By.xpath("//p[@class='message error']");
    private final By passwordFieldMsg = By.xpath("//li[@class='password']/label[@class='validation-error']");
    private final By pIDMsg = By.xpath("//li[@class='pid-number']/label[@class='validation-error']");

    //Elements
    private WebElement getTextEmail(){
        return Constant.driver.findElement(txtEmail);
    }

    private WebElement getTextPassword(){
        return Constant.driver.findElement(txtPassword);
    }

    private WebElement getTextConfirmPassword(){
        return Constant.driver.findElement(txtConfirmPassword);
    }

    private WebElement getTextPid(){
        return Constant.driver.findElement(txtPid);
    }

    private WebElement getBtnRegister(){
        return Constant.driver.findElement(btnRegister);
    }

    private WebElement getRegisterSuccess(){
        return Constant.driver.findElement(registerSuccessMsg);
    }

    public WebElement getRegisterFailed() {
        return Constant.driver.findElement(registerFailedMsg);
    }

    public WebElement getMsgPassWordField() {
        return Constant.driver.findElement(passwordFieldMsg);
    }

    public WebElement getMsgPIDFieldElement() {
        return Constant.driver.findElement(pIDMsg);
    }

    //Methods
    public void register(String email,String password,String confirmPassword, String pid){
        this.getTextEmail().sendKeys(email);
        this.getTextPassword().sendKeys(password);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
        this.getTextPid().sendKeys(pid);
        Utilities.getScrollToElement(btnRegister);
        this.getBtnRegister().click();
    }

    public String createGenerateEmail() {
        return "Railway+" + Utilities.GenRandomString() + "@gmail.com";
    }

    public String getRegisterSuccessMsg() {
        return getRegisterSuccess().getText();
    }

    public String getRegisterFailedMsg() {
        return getRegisterFailed().getText();
    }

    public String getPIDFieldMsg() {
        return getMsgPIDFieldElement().getText();
    }

    public String getPassWordFieldMsg() {
        return getMsgPassWordField().getText();
    }


}
