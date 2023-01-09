package Pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static helpers.StringModifier.getUniqueString;

public class ResultRhymePage extends BaseSeleniumPage {
    // String dateAndTime = getUniqueString("MyString");
    // @FindAll({@FindBy(className = "d r")})
    List<WebElement> listResult = null;
    //@FindBy (className = "d r")
    public ResultRhymePage(){
        PageFactory.initElements(driver, this);
    }
    public ResultRhymePage showResult(){
        listResult = driver.findElements(By.xpath("//a[@class='d r']"));
        System.out.println("Number of results is : "+listResult.size());
      //  WebElement title = driver.findElement(By.xpath("//title[contains(text(),'test')]"));
        // System.out.println("RESULT : "+title.getAttribute("innerHTML").toString());
        return new ResultRhymePage();
    }
    public String showTitle(String searchRequest){
        WebElement title = driver.findElement(By.xpath("//title[contains(text(),'"+searchRequest+"')]"));
        return title.getAttribute("innerHTML").toString();
    }

    public boolean isWordFieldExist(){
        List<WebElement> myList = driver.findElements(By.xpath("//input[@name='Word']"));
            if (!myList.isEmpty()){return true;}
            else{
        return false;}

    }

}
