package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "dataForSum")
    public static Object[][] dataForSumTest(){
        return new Object[][]{
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5}
        };
    }
    @DataProvider (name = "dataForDevInt")
    public static Object[][] dataForDevIntTest(){
        return new Object[][]{
                {-6, -3, 2},
                {0, 0, 0},
                {2, 2, 1}
        };
    }
    @DataProvider (name = "dataForDevDou")
    public static Object[][] dataForDevDouTest(){
        return new Object[][]{
                {-6.2, -3.2, 1.9375},
                {1.1, 2.1, 0.5238},
                {2.4, 2.2, 1.0909}
        };
    }
}


