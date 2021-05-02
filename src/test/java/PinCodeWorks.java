import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Set;

public class PinCodeWorks extends BasePage{
    private WebDriver driver;

    private By textbox = By.name("q");
    private By searchbutton = By.className("_34RNph");
    private By first_item = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]");
    private By pin = By.className("_36yFo0");
    private By check = By.className("_2P_LDn");
    private By msg = By.className("_3XINqE");


    public PinCodeWorks(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void PinCodeWorks(String itemname,String pincode) throws IOException,InterruptedException{
        try {

            locateElement1(textbox).sendKeys(itemname);
            driver.findElement(searchbutton).click();
            Thread.sleep(1000);
            locateElement1(first_item).click();
            Thread.sleep(2000);
            Set<String> windows = driver.getWindowHandles();
            for (String w : windows) {
                driver.switchTo().window(w);
            }
            Thread.sleep(1000);
            locateElement1(pin).sendKeys(pincode);
            Thread.sleep(1000);
            driver.findElement(check).click();
            Thread.sleep(1000);
            locateElement1(msg);
            String actual_result = driver.findElement(msg).getText();
            Thread.sleep(1000);
            Reports.extentTest.log(Status.INFO,"Pin Code : " + pincode);
            Assert.assertTrue(actual_result.contains("Delivery "));
            takeScreenshot("VerifyPinCodeWorksPassed");
            Reports.extentTest.log(Status.PASS, "Pin code works");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("VerifyPinCodeWorksFailed");
        }
    }
}
