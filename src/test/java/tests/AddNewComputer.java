package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddNewPage;

public class AddNewComputer extends BaseTest{

    protected AddNewPage addNewPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        addNewPage = new AddNewPage(driver, driverWait);
    }

    @Test
    public void addComputerTest(){
        homePage.openAddPage();
        String name = "Test";
        addNewPage.fillForm(name, "2023-02-13", "2023-02-15", "RCA");
        Assert.assertEquals(homePage.getAlert(), "Done ! Computer " + name + " has been created");
    }
}
