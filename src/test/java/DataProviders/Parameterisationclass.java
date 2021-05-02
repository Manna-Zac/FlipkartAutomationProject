package DataProviders;

import org.testng.annotations.DataProvider;

public class Parameterisationclass {

    @DataProvider(name = "GiveDataProvider")
    public Object[][] getData() {

        Object[][] data = {{"iphone", "76975689"}};
        return data;
    }
    @DataProvider(name = "GetData")
    public Object[][] giveData(){
        Object[][] data = {{"iphone", "682030"}};
        return data;
    }
}