package Pages;

import core.BaseSeleniumPage;
import core.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RuTrackerPage extends BaseSeleniumPage {
    //https://rutracker.org/forum/index.php
    @FindBy(xpath = "//input[@id='search-text-guest']")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='topmenu']//a[@href='#']")
    private WebElement enterButton;
    @FindBy(xpath = "//input[@name='login_username']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@name='login_password']")
    private WebElement passwordField;
    @FindBy(xpath = "//div[@id='top-login-box']//input[@name='login']")
    private WebElement confirmButton;

    public RuTrackerPage() {
        driver.get(ConfigProvider.RUTRACKER_);
       // driver.get("https://rutracker.org/forum/index.php");

        PageFactory.initElements(driver, this);
    }

    public RT_LoggedIn mainLogin(String user, String password){
        enterButton.click();
        userNameField.sendKeys(user);
        passwordField.sendKeys(password);
        confirmButton.click();
        return new RT_LoggedIn();
    }

}
