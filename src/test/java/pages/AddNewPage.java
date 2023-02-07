package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewPage extends BasePage{

    @FindBy (id = "name")
    private WebElement computerName;

    @FindBy (id = "introduced")
    private WebElement introducedField;

    @FindBy (id = "discontinued")
    private WebElement discontinuedField;

    @FindBy (id = "company")
    private WebElement company;

    @FindBy (xpath = "//*[@id=\"main\"]/form/div/input")
    private WebElement createComputerButton;

    public AddNewPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
