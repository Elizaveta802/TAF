package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Allure example")
@Feature("TestNG support")

public class AllureTest {

    @Test(description = "Main Test")
    public void testName(){
        Assert.assertTrue(true);
    }

    @Test
    @Description("Some details for this test")
    public void testName1(){
        Assert.assertTrue(true);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testName2(){
        Assert.assertTrue(true);
    }

    @Test
    @Story("Base support function")
    public void testName3(){
        Assert.assertTrue(true);
    }

    @Test
    public void testName4(){
        step("Admin");
        Assert.assertTrue(true);
    }

    @Step("Username {user}")
    private void step(String user){
        System.out.println(user);
    }

    @Test
    @Issue("ID-123")
    public void testIssue(){
        step("Admin");
        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("TC-532")
    public void testTms(){
        step("Admin");
        Assert.assertTrue(true);
    }


    @Test
    @Link("http://example.org")
    @Link(name = "allureLink", type = "meLink", url = "http://onliner.by")
    public void testLink(){
        step("Admin");
        Assert.assertTrue(true);
    }
}


