import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTest extends BaseTest {
    @Test
    public void testSum(){
        Assert.assertEquals(calculator.sum(2,3), 5, "неверная сумма...");
    }

    @Test (enabled = false)
    public void testSum1(){
        Assert.assertEquals(calculator.sum(2,3), 5, "неверная сумма...");
    }

    @Test (description = "Тест с описанием")
    public void testSum2(){
        Assert.assertEquals(calculator.sum(2,3), 5, "неверная сумма...");
    }

    @Test (testName = "Test with name")
    public void testSum3(){
        Assert.assertEquals(calculator.sum(2,3), 5, "неверная сумма...");}

    @Test (timeOut = 1000)
    public void waitLongTimeTest() throws InterruptedException{
        Thread.sleep(1100);}

    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void invocationCoutTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2, 3), 5, "неверная сумма...");}

    @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class)
    public void testDataProvider(int a, int b, int expectedResult){
        Assert.assertEquals(calculator.sum(a, b), expectedResult, "неверная сумма...");}

    @Test (expectedExceptions = NullPointerException.class)
    public void testExceptione(){
        List list = null;
        int size = list.size();}

}
