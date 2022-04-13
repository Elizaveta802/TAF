package data;

import org.testng.annotations.DataProvider;

public class StaticProviderInt {

    @DataProvider (name = "dataForDev")
    public static Object[][] dataForDevTest(){
        return new Object[][]{
                {-4, -2, -2},
                {0, 0, 0},
                {6, 3, 2}
        };
    }
}


