package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AddNewPage;
import pages.HomePage;

import java.time.Duration;

public class AddNewComputer extends BaseTest{

    protected AddNewPage addNewPage;

    @BeforeClass
    public void beforeClass() {
        addNewPage = new AddNewPage(driver, driverWait);
    }









}
