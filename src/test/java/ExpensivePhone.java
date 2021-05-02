import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class ExpensivePhone extends BasePage{
    private WebDriver driver;

    private By textbox = By.name("q");
    private By searchbutton = By.className("_34RNph");
    private By H_to_L = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div[4]");
    private By most_expensive_phone = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]");
    //*[@id
    public ExpensivePhone(WebDriver driver){
        super(driver);
        this.driver = driver;}



    public void MostExpensivePhone(String item_name) throws IOException,InterruptedException{
        try {


            locateElement1(textbox).sendKeys(item_name);

            driver.findElement(searchbutton).click();
            Thread.sleep(1000);
            locateElement1(H_to_L).click();
            Thread.sleep(2000);
            locateElement1(most_expensive_phone);
            Thread.sleep(2000);
            String actual_result = driver.findElement(most_expensive_phone).getText();
            Thread.sleep(2000);
            Reports.extentTest.log(Status.INFO,"Expensive Phone : " + actual_result );
            Assert.assertTrue(actual_result.contains("APPLE iPhone 12 Pro Max"));
            takeScreenshot("VerifyMostExpensivePhonePassed");
            Reports.extentTest.log(Status.PASS, "Expensive Phone Verified");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("VerifyMostExpensivePhoneFailed");
        }
    }

}
