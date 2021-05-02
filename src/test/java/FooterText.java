import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class FooterText extends BasePage{
    private WebDriver driver;

    private By contact_us = By.xpath("//*[@id=\"container\"]/div/footer/div/div[3]/div[1]/div[1]/a[1]");
    private By careers = By.xpath("//*[@id=\"container\"]/div/footer/div/div[3]/div[1]/div[1]/a[3]");
    private By press = By.xpath("//*[@id=\"container\"]/div/footer/div/div[3]/div[1]/div[1]/a[5]");

    public FooterText(WebDriver driver){
        super(driver);
        this.driver = driver;

    }

    public void FooterText() throws IOException,InterruptedException{
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            locateElement1(contact_us);
            String actual_one = driver.findElement(contact_us).getText();
            locateElement1(careers);
            String actual_two = driver.findElement(careers).getText();
            locateElement1(press);
            String actual_three = driver.findElement(press).getText();
            Reports.extentTest.log(Status.INFO,"Under ABOUT : Contact Us, Careers,Press are present. " );
            Assert.assertEquals(actual_one, "Contact Us");
            Assert.assertEquals(actual_two, "Careers");
            Assert.assertEquals(actual_three, "Press");
            takeScreenshot("ValidateFooterTextPassed");
            Reports.extentTest.log(Status.PASS, "Found Footer Text");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("ValidateFooterTextFailed");
        }
    }
}
