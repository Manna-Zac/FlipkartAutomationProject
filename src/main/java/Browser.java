import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;

public class Browser {

    public static WebDriver openBrowser(String url){
        String baseDirectory=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",baseDirectory+"/src/main/resources/chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        //ToDo parameterise browser and url
        driver.navigate().to(url);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
        return driver;
    }

    public static void closeBrowser(WebDriver driver){
        driver.close();
    }
}
