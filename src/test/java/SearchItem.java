import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class SearchItem extends BasePage{
    private WebDriver driver;

    private By textbox = By.name("q");
    private By searchbutton = By.className("_34RNph");
    private By firstItem = By.className("_4rR01T");

    public SearchItem(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    public void SearchingItem(String item_name_a) throws IOException,InterruptedException{
        try {


            locateElement(textbox).sendKeys(item_name_a);
            Thread.sleep(1000);
            driver.findElement(searchbutton).click();
            Thread.sleep(1000);
            String actualresult = locateElement(firstItem).getText();
            Reports.extentTest.log(Status.INFO, "Search Item : " + item_name_a);
            Assert.assertEquals(actualresult.contains(item_name_a), true);
            takeScreenshot("ValidateSearchItemPassed");
            Reports.extentTest.log(Status.PASS, "Search Item Found");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("SearchItemFailed");
        }
    }

    public void negSearch(String item_name_b) throws IOException,InterruptedException{
        try {


            locateElement(textbox).sendKeys(item_name_b);
            Thread.sleep(1000);
            driver.findElement(searchbutton).click();
            Thread.sleep(1000);
            String actualresult = locateElement(By.className("_3uTeW4")).getText();
            Reports.extentTest.log(Status.INFO,"Neg Search Item : "+ item_name_b );
            Assert.assertEquals(actualresult.contains("no results found"), true);
            takeScreenshot("ValidateNegSearchPassed");
            Reports.extentTest.log(Status.PASS, "Neg Search Item Found");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("NegSearchItemFailed");
        }

    }


}



