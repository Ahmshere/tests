package Pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RT_LoggedIn extends BaseSeleniumPage {

    @FindBy(xpath = "//a[@id='logged-in-username']")
    private WebElement loggedInUsername;
    @FindBy(xpath = "//*[@id='search-text']")
    private WebElement serachField;
    @FindBy(xpath = "//p[@class='med bold']")
    private WebElement searchResult;
    public RT_LoggedIn(){
        PageFactory.initElements(driver, this);

    }
    public String getLoggedInUserName(String userName){
        return loggedInUsername.getAttribute("innerHTML").toString();
    }

    public Integer mainSearch(String param){
        serachField.sendKeys(param, Keys.ENTER);
        String s1 = searchResult.getAttribute("innerHTML").toString();
                String[] s2_array = s1.split("\\D+");
        Integer numbers = Integer.parseInt(String.join("", s2_array));
        return numbers;

    }
}
