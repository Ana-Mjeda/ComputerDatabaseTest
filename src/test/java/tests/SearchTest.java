package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BaseTest{

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
}
