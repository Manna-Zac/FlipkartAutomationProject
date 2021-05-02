import DataProviders.Parameterisationclass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.InterruptedException;


public class FlipkartExecution {

    private WebDriver driver;

    @Parameters({"url"})
    @BeforeMethod
    public void openBrowser(String url){
        driver=Browser.openBrowser(url);
    }


    @Test(priority = 0)
    @Parameters({"item_name_a"})
    public void validateSearchItem(String item_name_a) throws IOException,InterruptedException {
        Reports.createTest("Validate Search");
        SearchItem searchItem = new SearchItem(driver);
        searchItem.SearchingItem(item_name_a);

    }


    @Test(priority = 1)
    @Parameters({"item_name_b"})
    public void validateNegativeSearch(String item_name_b) throws IOException,InterruptedException{
        Reports.createTest("Validate Neg Search");
        SearchItem neg_search = new SearchItem(driver);
        neg_search.negSearch(item_name_b);

    }


    @Test(priority = 2)
    @Parameters({"item_name"})
    public void validateAddToCart(String item_name) throws IOException{
        Reports.createTest("Add To Cart");
        AddToCart add_cart = new AddToCart(driver);
        add_cart.AddingToCart(item_name);

    }


    @Test(priority = 3)
    @Parameters({"item_name"})
    public void validateRemoveFromCart(@Optional("iphone") String item_name) throws IOException,InterruptedException{
        Reports.createTest("Remove from cart");
        RemoveFromCart removeFromCart = new RemoveFromCart(driver);
        removeFromCart.RemoveFromCart(item_name);
    }


    @Test(priority = 4)
    public void verifyRegisteredAddress() throws IOException, InterruptedException {
        Reports.createTest("Registered Address");
        RegisteredAddress address = new RegisteredAddress(driver);
        address.RegisteredAddress();

    }


    @Test(priority = 5)
    @Parameters({"item_name"})
    public void verifyMostExpensivePhone(String item_name) throws IOException,InterruptedException{
        Reports.createTest("Expensive Phone");
        ExpensivePhone expensivePhone = new ExpensivePhone(driver);
        expensivePhone.MostExpensivePhone(item_name);
    }

    @Test(priority = 6, dataProviderClass = Parameterisationclass.class, dataProvider = "GiveDataProvider")
    public void verifyInvalidPinCode(String item_name_c, String pincode_a) throws IOException,InterruptedException{
        Reports.createTest("Invalid Report");
        InvalidPinCode invalidPinCode = new InvalidPinCode(driver);
        invalidPinCode.InvalidPinCode(item_name_c,pincode_a);
    }
    @Test(priority = 7)
    @Parameters({"product_name"})
    public void VerifyFilterOptions(@Optional("t-shirts") String product_name) throws IOException,InterruptedException{
        Reports.createTest("Filter Options");
        FilterOptions filterOptions = new FilterOptions(driver);
        filterOptions.FilterOptions(product_name);
    }
    @Test(priority = 8)
    public void ValidateFooterText() throws IOException,InterruptedException{
        Reports.createTest("Footer text");
        FooterText footerText = new FooterText(driver);
        footerText.FooterText();

    }
    @Test(priority = 9, dataProviderClass = Parameterisationclass.class, dataProvider = "GetData")
    public void verifyPinCodeWorks(String itemname, String pincode) throws IOException,InterruptedException{
        Reports.createTest("Pin code works");
        PinCodeWorks pinCodeWorks = new PinCodeWorks(driver);
        pinCodeWorks.PinCodeWorks("iphone","682030");
    }
    @Test(priority = 10)
    @Parameters({"item_name"})
    public void verifyTotalAmountSingle(String item_name) throws IOException,InterruptedException{
        Reports.createTest("Total Amount Single");
        TotalAmountSingle totalAmountSingle = new TotalAmountSingle(driver);
        totalAmountSingle.TotalAmountSingle(item_name);
    }




    @AfterMethod
    public void closeBrowser(){
        Browser.closeBrowser(driver);
    }
}
