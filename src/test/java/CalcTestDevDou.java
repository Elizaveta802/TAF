import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// Странное название класс! Что мешало его назвать CalcDivDoubleTest? Зачем нужно было сокращать?
public class CalcTestDevDou extends BaseTest {

    @Test (expectedExceptions = ArithmeticException.class)
    // ToDo: Исправить название метода - не понимаю, что именно он тут проверяет
    // ToDo: Неверная проверка - данный тест не проходит
    // ToDo: Форматирование кода в классе - Menu: Code -> Reformat Code
    public void testDevDou(){
        Assert.assertEquals(calculator.devDou(2.0,2.0), "неверное деление...");}

    @Test (enabled = false)
    public void testSDevDou1(){
        Assert.assertEquals(calculator.devDou(8.5,2.5), 3.4, "неверное деление...");}

    @Test (description = "Тест с делением на ноль", dependsOnMethods = "testSDevDou3", alwaysRun = true)
    public void testSDevDou2(){
        Assert.assertEquals(calculator.devDou(8.5,2.5), 3.4, "неверное деление...");}

    @Test (testName = "Test with nameDevDou", dependsOnMethods = "testDevDou")
    public void testSDevDou3(){
        // ToDo: Почему падение теста стоит до проверки? Она же в таком случае не выполниться...
        Assert.assertTrue(false);
        Assert.assertEquals(calculator.devDou(6.5,0.00), Double.POSITIVE_INFINITY, "неверное деление...");}

    @Test (groups = "smoke")
    public void testSDevDou4(){
        Assert.assertEquals(calculator.devDou(8.5,2.5), 3.4, "неверное деление...");}

    @Test (groups = "regression")
    public void testSDevDou5(){
        Assert.assertEquals(calculator.devDou(8.5,2.5), 3.4, "неверное деление...");}

    @Test (groups = {"smoke", "regression"})
    public void testSDevDou6(){
        Assert.assertEquals(calculator.devDou(8.5,2.5), 3.4, "неверное деление...");}

    @Test (timeOut = 1000)
    public void testSDevDou7() throws InterruptedException{
        Thread.sleep(1600);
        Assert.assertEquals(calculator.devDou(8.5,2.5), 3.4, "неверное деление...");}

    @Test (invocationCount = 2, invocationTimeOut = 1000, threadPoolSize = 2)
    public void invocationCountTestDevDou() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.devDou(8.5,2.5), 3.4, "неверное деление...");}

    @Test (dataProvider = "dataForDevDou", dataProviderClass=StaticProvider.class)
    public void testDataProvider(double a, double b, double expectedResult){
        Assert.assertEquals(calculator.devDou(a, b), expectedResult, "неверное деление...");}

    @Test (expectedExceptions = NullPointerException.class)
    public void testExceptioneDevDou(){
        List list = null;
        int size = list.size();}

    // ToDo: Тесты не покрывает все проверки. Отсуствуют проверки на 0?
}

