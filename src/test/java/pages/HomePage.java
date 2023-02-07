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

    @FindBy(xpath = "//*[@id=\"main\"]/h1")
    private WebElement topHeaderMessage;

    @FindBy(xpath = "//*[@id=\"pagination\"]/ul/li[2]/a")
    private WebElement displayMessageUnderTable;

    @FindBy(className = "alert-message")
    private WebElement alert;

    @FindBy(className = "add")
    private WebElement addNewComputerButton;

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
    public String getTopMessage(){
        return topHeaderMessage.getText();
    }
    public String getTableMessage(){
        return displayMessageUnderTable.getText();
    }

    public List<WebElement> getComputerList() {
        return computerList;
    }

    public String getAlert(){
        return alert.getText();
    }

    public void openAddPage(){
        addNewComputerButton.click();
    }
}
