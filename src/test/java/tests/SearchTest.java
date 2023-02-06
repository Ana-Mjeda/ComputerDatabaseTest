package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class SearchTest {

    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Vezba\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage = new HomePage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://computer-database.gatling.io/computers");
    }

    @Test
    public void searchTest() {
        String searchString = "ASCI";
        homePage.search(searchString);
        int numberOfComputers = homePage.getComputerList().size();
        Assert.assertTrue(homePage.containsSearchString(searchString));
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/computers?f=" + searchString));
        Assert.assertTrue(homePage.getTopMessage().startsWith(numberOfComputers + ""));
        String expMsg = "Displaying 1 to " + numberOfComputers + " of " +numberOfComputers;
        Assert.assertEquals(homePage.getTableMessage(), expMsg);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
