package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "searchbox")
    public WebElement searchInput;

    @FindBy(id = "searchsubmit")
    private WebElement searchButton;

    @FindAll({@FindBy(xpath = "//*[@id=\"main\"]/table/tbody/tr")})
    private List<WebElement> computerList;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void search(String searchString) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        searchInput.clear();
        searchInput.sendKeys(searchString);
        searchButton.click();
    }

    public boolean containsSearchString(String searchString) {
        for (WebElement computer : computerList) {
            WebElement computerLink = computer.findElement(By.tagName("a"));
            if (!computerLink.getText().contains(searchString)) {
                return false;
            }
        }
        return true;
    }

}
