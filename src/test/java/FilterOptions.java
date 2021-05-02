import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class FilterOptions extends BasePage{
    private WebDriver driver;

    private By textbox = By.name("q");
    private By searchbutton = By.className("_34RNph");
    private By filter = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/div/div/section/div[4]/div[2]/a[3]");

    public FilterOptions(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void FilterOptions(String product_name) throws IOException,InterruptedException{
        try {

            locateElement(textbox).sendKeys(product_name);
            driver.findElement(searchbutton).click();
            locateElement(filter).click();
            Reports.extentTest.log(Status.INFO,"Filter by : "+ product_name );
            takeScreenshot("VerifyFilterOptionsPassed");
            Reports.extentTest.log(Status.PASS, "Filter Applied");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("VerifyFilterOptionsFailed");
        }
    }
}
