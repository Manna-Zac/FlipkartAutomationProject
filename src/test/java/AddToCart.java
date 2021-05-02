import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Set;

public class AddToCart extends BasePage{
    private WebDriver driver;

    private By textbox = By.name("q");
    private By searchbutton = By.className("_34RNph");
    private By Item = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div/a[2]");

    private By add_to_cart_button = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button");
    private By cart_title = By.className("_3g_HeN");

    public AddToCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void AddingToCart(String item_name) throws IOException {
        try {


            locateElement1(textbox).sendKeys(item_name);
            driver.findElement(searchbutton).click();
            locateElement1(Item).click();
            Set<String> windows = driver.getWindowHandles();
            for (String w : windows) {
                driver.switchTo().window(w);
            }
            locateElement1(add_to_cart_button).click();
            locateElement1(cart_title);
            Reports.extentTest.log(Status.INFO,"Item added to cart " );
            String actual = driver.findElement(cart_title).getText();
            Assert.assertTrue(actual.contains("My Cart"));
            takeScreenshot("VerifyAddToCartPassed");
            Reports.extentTest.log(Status.PASS, "Item added to cart");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("ValidateAddToCartFailed");
        }
    }




}
