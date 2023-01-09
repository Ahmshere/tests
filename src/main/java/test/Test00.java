package test;

import Pages.LogInPage;
import Pages.MainPage;
import Pages.ResultRhymePage;
import Pages.RuTrackerPage;
import core.*;
import helpers.TestValues;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
//import org.junit.Test;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Arrays;

@ExtendWith(TestListener.class)
public class Test00 extends BaseSeleniumTest {
    private int count = 0;
/*
    // JUST FOR TESTNG test cases!!!
    @BeforeSuite
    public void setupNG(ITestContext context){
        Arrays.stream(context.getAllTestMethods()).forEach(x->x.setRetryAnalyzerClass(TestNGRetry.class));
    }
*/
/*
    // JUST FOR JUNIT_4 test cases!!!
    @Rule
    public JUnit4Retry rule= new JUnit4Retry(3);
*/
@Test
public void testJUnit5(){
    Assertions.assertFalse(false);
}
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void rhymeTest01() throws InterruptedException {
        count++;
        String queryConst = TestValues.TEST_EMAIL;
        String query = "book";
        ResultRhymePage rrp = new MainPage().rhymeSearch(query).showResult();
        String st = rrp.showTitle(query);
        boolean br = rrp.isWordFieldExist();

        //Assert.assertTrue(st.contains("book"));
        Assertions.assertTrue(st.contains("book"));
        Assert.assertTrue(br);
        System.out.println("RES - "+ st+ " : IS - " + br);
    }

@Test
public void rutrackerTest01(){
    String user = "Ahmshere";
    String pwd = "h4unc";
    RuTrackerPage ruTrackerPage = new RuTrackerPage();
    String res = ruTrackerPage.mainLogin(user,pwd).getLoggedInUserName(user);
    Assertions.assertTrue(res.contains("ahmshere"));
}

    @Test
    public void rutrackerUserFalse(){
        String user = "Ahmshere";
        String pwd = "h4unc";
        RuTrackerPage ruTrackerPage = new RuTrackerPage();
        String res = ruTrackerPage.mainLogin(user,pwd).getLoggedInUserName(user);
        Assertions.assertFalse(res.contains("ahmshere"));
    }

@Test
    public void rutrackerSearch(){
        String user = "Ahmshere";
        String pwd = "";
        RuTrackerPage ruTrackerPage = new RuTrackerPage();

        int resultSearch = ruTrackerPage.mainLogin(user, pwd).mainSearch("Bad Boys");
            if (resultSearch>0){
                System.out.println("Search result : "+resultSearch);
                Assertions.assertTrue(true);
            }
            else {System.out.println("Search result : "+resultSearch);
                Assertions.assertTrue(false);}


    }

    @Test // fail
    public void rhymeTest02(){
        String query = "pook";
        ResultRhymePage rrp = new MainPage().rhymeSearch(query).showResult();
        String st = rrp.showTitle(query);
        boolean br = rrp.isWordFieldExist();

        Assert.assertTrue(st.contains("book"));
        Assert.assertTrue(br);
        System.out.println("RES - "+ st+ " : IS - " + br);
    }
  /*  @Test
    public void chromeTest1(){
        System.out.println("PRINT SMTH");
        //LogInPage lp = new LogInPage();

        MainPage mp = new MainPage();
        mp.createSmth(TestValues.TEST_MSG, "allure").getTitle();


    }*/
    // https://www.appsdeveloperblog.com/an-overview-of-junit5-assertions-with-examples/ - Assert methods
    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("app.conf"));
        String urlPromProperties = System.getProperty("rt");
        System.out.println("*** "+urlPromProperties);

    }

    @Test
    public void checkSettings(){
        String urlFromConf = ConfigProvider.URL_PRESONUS;
        System.out.println("*** "+urlFromConf);
    }

}
// https://www.youtube.com/watch?v=brKmBegyObU&t=18s

// Config files - https://www.youtube.com/watch?v=D0aE_fRT0DE

// test api server (crud) http://85.192.34.140:8080/swagger-ui/index.html

// GIT - git@github.com:Ahmshere/tests.git