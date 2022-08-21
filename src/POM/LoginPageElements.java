package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {
    public LoginPageElements(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//button[text()='Accept all cookies']")
    public WebElement acceptCookies;

    @FindBy(xpath="//input[@placeholder='Username']")
    public WebElement userName;

    @FindBy(xpath="//input[@placeholder='Password']")
    public WebElement password;

    @FindBy(xpath="//button[@aria-label='LOGIN']")
    public WebElement logIn;
}
