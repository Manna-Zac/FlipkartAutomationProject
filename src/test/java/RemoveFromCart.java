import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Set;

public class RemoveFromCart extends BasePage{
    private WebDriver driver;

    private By textbox = By.name("q");
    private By searchbutton = By.className("_34RNph");
    private By firstItem = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div/a[1]");
    private By add_to_cart_button = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button");
    private By remove = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]");
    private By msg = By.className("_1LCJ1U");

    public RemoveFromCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void RemoveFromCart(String item_name) throws IOException {
        try {

            locateElement1(textbox).sendKeys(item_name);
            driver.findElement(searchbutton).click();
            locateElement1(firstItem).click();
            Set<String> windows = driver.getWindowHandles();
            for (String w : windows) {
                driver.switchTo().window(w);
            }
            locateElement1(add_to_cart_button).click();
            locateElement1(remove).click();
            locateElement1(msg);
            String actual = driver.findElement(msg).getText();
            Reports.extentTest.log(Status.INFO,"Remove Item : ");
            Assert.assertTrue(actual.contains("Missing Cart items"));
            takeScreenshot("VerifyRemoveFromCartPassed");
            Reports.extentTest.log(Status.PASS, "Found Registered Address");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("VerifyRemoveFromCartFailed");
        }


    }




}
