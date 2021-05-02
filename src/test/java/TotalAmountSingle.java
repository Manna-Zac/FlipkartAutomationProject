import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Set;

public class TotalAmountSingle extends BasePage{
    private WebDriver driver;

    private By textbox = By.name("q");
    private By searchbutton = By.className("_34RNph");
    private By firstItem = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div/a[1]");
    private By add_to_cart_button = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button");
    private By price_mycart = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/span[1]");
    private By price_pricedetails = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[4]/div/span/div/div/span");


    public TotalAmountSingle(WebDriver driver) {

        super(driver);
        this.driver = driver;
    }

    public void TotalAmountSingle(String item_name) throws IOException {
        try {

            locateElement1(textbox).sendKeys(item_name);
            driver.findElement(searchbutton).click();
            locateElement1(firstItem).click();
            Set<String> windows = driver.getWindowHandles();
            for (String w : windows) {
                driver.switchTo().window(w);
            }
            locateElement1(add_to_cart_button).click();
            locateElement1(price_mycart);
            String a = driver.findElement(price_mycart).getText();
            locateElement1(price_pricedetails);
            String e = driver.findElement(price_pricedetails).getText();
            Reports.extentTest.log(Status.INFO,"Total Amount : " + a  );
            Assert.assertEquals(a, e);
            takeScreenshot("VerifyTotalAmountPassed");
            Reports.extentTest.log(Status.PASS, "Total amount verified");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("VerifyTotalAmountFailed");
        }


    }




}

