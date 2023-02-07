package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.time.Duration;

public class SearchTest {

    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage = new HomePage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://computer-database.gatling.io/computers");
    }

    @Test
    public void searchTestSoftAssert() {
        String searchString = "ASCI";
        homePage.search(searchString);
        int numberOfComputers = homePage.getComputerList().size();
        String expMsg = "Displaying 1 to " + numberOfComputers + " of " +numberOfComputers;

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.containsSearchString(searchString));
        softAssert.assertTrue(driver.getCurrentUrl().endsWith("/computers?f=" + searchString));
        softAssert.assertTrue(homePage.getTopMessage().startsWith(numberOfComputers + ""));
        softAssert.assertEquals(homePage.getTableMessage(), expMsg);
        softAssert.assertAll();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
