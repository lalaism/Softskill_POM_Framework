package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseDriver {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(String browser){

        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\techno\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("startmaximized");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            driver.manage().window().maximize();
            driver.get("https://campus.techno.study/");
        } else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\techno\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("startmaximized");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            driver.manage().window().maximize();
            driver.get("https://campus.techno.study/");
        }
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();

    }
}
