import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class RegisteredAddress extends BasePage{
    private WebDriver driver;
    private By address = By.xpath("//*[@id=\"container\"]/div/footer/div/div[3]/div[1]/div[6]/div/div[2]/div[1]/div[1]");


    public RegisteredAddress(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void RegisteredAddress() throws IOException,InterruptedException{
        try {


            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(4000);
            locateElement(address);
            String expected = "Flipkart Internet Private Limited,\n" +
                    "Buildings Alyssa, Begonia &\n" +
                    "Clove Embassy Tech Village,\n" +
                    "Outer Ring Road, Devarabeesanahalli Village,\n" +
                    "Bengaluru, 560103,\n" +
                    "Karnataka, India\n" +
                    "CIN : U51109KA2012PTC066107\n" +
                    "Telephone: 1800 202 9898";
            String actual = driver.findElement(address).getText();
            Thread.sleep(1000);
            Reports.extentTest.log(Status.INFO,"Registered Address : " + actual);
            Assert.assertEquals(actual, expected);
            takeScreenshot("ValidateRegisteredAddressPassed");
            Reports.extentTest.log(Status.PASS, "Found Registered Address");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("ValidateRegisteredAddressFailed");

        }





    }
}
