package Pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BaseSeleniumPage {
    @FindBy (id = "")
    private WebElement loginField;

    @FindBy (id = "")
    private WebElement passwordField;

    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

    public MyPage authorisation(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password, Keys.ENTER);
        return new MyPage();
    }
    public LogInPage getTitle(){
        String resultTitle = driver.getTitle();
        return new LogInPage();
    }

}
