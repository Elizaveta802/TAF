import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTestDevInt extends BaseTest {

    @Test ()
    public void testSDevInt(){
        Assert.assertEquals(calculator.devInt(6,3), 2, "неверное деление...");}

    @Test (enabled = false)
    public void testSDevInt1(){
        Assert.assertEquals(calculator.devInt(6,3), 2, "неверное деление...");}

    @Test (description = "Тест с описанием", dependsOnMethods = "testSDevInt3", alwaysRun = true)
    public void testSDevInt2(){
        Assert.assertEquals(calculator.devInt(6,3), 2, "неверное деление...");}

    @Test (testName = "Test with name1", dependsOnMethods = "testSDevInt")
    public void testSDevInt3(){
        Assert.assertTrue(false);
        Assert.assertEquals(calculator.devInt(6,3), 2, "неверное деление...");}

    @Test (groups = "smoke")
    public void testSDevInt4(){
        Assert.assertEquals(calculator.devInt(6,3), 2, "неверное деление...");}

    @Test (groups = "regression")
    public void testSDevInt5(){
        Assert.assertEquals(calculator.devInt(6,3), 2, "неверное деление...");}

    @Test (groups = {"smoke", "regression"})
    public void testSDevInt6(){
        Assert.assertEquals(calculator.devInt(6,3), 2, "неверное деление...");}

    @Test (timeOut = 1000)
    public void testSDevInt7() throws InterruptedException{
        Thread.sleep(1100);
        Assert.assertEquals(calculator.devInt(6,3), 2, "неверное деление...");}

    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void testSDevInt8() throws InterruptedException {
        Thread.sleep(500);}
        //Assert.assertEquals(calculator.devInt(6,0), Integer., "неверное деление...");}

    //@Test (dataProvider = "dataForDev", dataProviderClass=StaticProvider.class)
    //public void testDataProvider(int a, int b, int expectedResult){
        //Assert.assertEquals(calculator.devInt(a, b), expectedResult, "неверная сумма...");}
}
