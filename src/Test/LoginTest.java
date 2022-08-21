package Test;

import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseDriver {
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;


    @Test(priority = 1,dataProvider = "LogInData")
    public void loginPositiveTest(String userName, String password){
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements= new MyAccountPageElements(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageElements.acceptCookies.click();
        loginPageElements.userName.sendKeys(userName);
        loginPageElements.password.sendKeys(password);
        loginPageElements.logIn.click();

        String actualMessage= myAccountPageElements.welcomeMessage.getText();
        String expectedMessage="Welcome, Lala Ismayilova !";

        Assert.assertEquals(actualMessage,expectedMessage);

    }


    @Test(priority = 2,dataProvider = "LogInData2")
    public void loginNegativeTest2(String userName, String password) {
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageElements.acceptCookies.click();
        loginPageElements.userName.sendKeys(userName);
        loginPageElements.password.sendKeys(password);
        loginPageElements.logIn.click();

        String actualError = myAccountPageElements.errorMessage.getText();
        String expectedError = "Invalid username or password";

        Assert.assertEquals(actualError, expectedError);
    }

    @Test(priority = 3,dataProvider = "LogInData3")
    public void loginNegativeTest3(String userName, String password) {
        loginPageElements= new LoginPageElements(driver);
        myAccountPageElements= new MyAccountPageElements(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageElements.acceptCookies.click();
        loginPageElements.userName.sendKeys(userName);
        loginPageElements.password.sendKeys(password);
        loginPageElements.logIn.click();

        String actualError=myAccountPageElements.errorMessage.getText();
        String expectedError="Invalid username or password";

        Assert.assertEquals(actualError,expectedError);

    }
    @Test(priority = 4,dataProvider = "LogInData4")
    public void loginNegativeTest4(String userName, String password) {
        loginPageElements= new LoginPageElements(driver);
        myAccountPageElements= new MyAccountPageElements(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageElements.acceptCookies.click();
        loginPageElements.userName.sendKeys(userName);
        loginPageElements.password.sendKeys(password);
        loginPageElements.logIn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.errorMessage));
        String actualError=myAccountPageElements.errorMessage.getText();
        String expectedError="Invalid username or password";

        Assert.assertEquals(actualError,expectedError);

    }
    @DataProvider(name = "LogInData") // Enter your correct email and correct password
    public Object [][] testDataProvider() {
        return new Object[][] { {"ismayilovalala2@gmail.com","1234inputTEST"}};
    }
    @DataProvider(name = "LogInData2") // Enter your incorrect email and correct password
    public Object [][] testDataProvider2() {
        return new Object[][] { {"ismayil@gmail.com","1234inputTEST"} };
    }
    @DataProvider(name = "LogInData3") // Enter your correct email and incorrect password
    public Object [][] testDataProvider3() {
        return new Object[][] { {"ismayilovalala2@gmail.com","asdahiu2"} };
    }
    @DataProvider(name = "LogInData4") // Enter your incorrect email and incorrect password
    public Object [][] testDataProvider4() {
        return new Object[][] { {"ismail@gmail.com","asdsad"} };
}
    }