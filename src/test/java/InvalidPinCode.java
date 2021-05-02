import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Set;

public class InvalidPinCode extends BasePage{
    private WebDriver driver;

    private By textbox = By.name("q");
    private By searchbutton = By.className("_34RNph");
    private By first_item = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]");
    private By pin = By.className("_36yFo0");
    private By check = By.className("_2P_LDn");
    private By error = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[7]/div/div/div[2]/div");

    public InvalidPinCode(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void InvalidPinCode(String item_name_c,String pincode_a) throws IOException,InterruptedException{
        try {

            locateElement1(textbox).sendKeys(item_name_c);
            driver.findElement(searchbutton).click();
            Thread.sleep(1000);
            locateElement1(first_item).click();
            Thread.sleep(2000);
            Set<String> windows = driver.getWindowHandles();
            for (String w : windows) {
                driver.switchTo().window(w);
            }
            Thread.sleep(1000);
            locateElement1(pin).sendKeys(pincode_a);
            Thread.sleep(1000);
            driver.findElement(check).click();
            Thread.sleep(1000);
            locateElement1(error);
            String actual_result = driver.findElement(error).getText();
            Thread.sleep(1000);
            Assert.assertEquals(actual_result, "Not a valid pincode");
            Thread.sleep(1000);
            Reports.extentTest.log(Status.INFO,"Invalid Pin Code : " + pincode_a);
            takeScreenshot("VerifyInvalidPinCodePassed");
            Reports.extentTest.log(Status.PASS, "Invalid PinCode");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("VerifyInvalidPinCodeFailed");
        }
    }
}
