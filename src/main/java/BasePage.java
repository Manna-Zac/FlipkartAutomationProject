import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement locateElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement locateElement1(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String takeScreenshot(String name) throws IOException {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = "Screenshot" + "_" + name;

        Files.move
                (Paths.get(screenshot.getAbsolutePath()),
                        Paths.get(System.getProperty("user.dir") + "/report/" + fileName + ".png"));
        return fileName + ".png";
    }
}
