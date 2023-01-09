package Pages;

import core.BaseSeleniumPage;
import core.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
// https://mvnrepository.com/

    // https://www.fiverr.com/
    //private final By someElement = By.id("");
    //private final By someElement2 = By.xpath("");
    // OR
    @FindBy (xpath = "//a[@class='search collapsed']")
    private WebElement searchBTN;

    @FindBy (xpath = "//i[@class='icon icon-search circle-icon-btn mr-2']")
    WebElement magnifier;
    @FindBy(xpath = "//input[@id='edit-query']")
    private WebElement searchField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement startSearchBtn;
    @FindBy (xpath = "//input[@id='searchInput']")
    private WebElement searchFieldPre;
    @FindBy (className = "search-button")
    WebElement SearchBTNMain;
    @FindBy (xpath = "//input[@name='Word']")
    WebElement wordField;
    // best way to find the element
      @FindBy(xpath = "//input[@class='textfield']") private WebElement element;
      @FindBy(xpath = "//input[@type='submit']") private WebElement searchButton;
    public MainPage() {
        driver.get(ConfigProvider.URL_RHYME);

// driver.get("https://www.rhymezone.com/");
        PageFactory.initElements(driver, this);
        // Page factory otvechaet za inicializaciu vsex elementov v klasse
    }

    public MainPage(WebElement element) {
        this.element = element;
    }

    public ResultRhymePage rhymeSearch(String myString){
        wordField.sendKeys(myString, Keys.ENTER);
        return new ResultRhymePage();
    }
    // metod vozvrashaushiy osnovnuu stranicu
    public MainPage searchResult(String query) throws InterruptedException {
        wordField.sendKeys(query, Keys.ENTER);
        Thread.sleep(5000);

        // Presonus
        // magnifier.click();
        // searchFieldPre.sendKeys(query);
        // SearchBTNMain.click();


        return this;
    }
    public LogInPage createSmth(String titleValue, String bodyValue){
        element.sendKeys(titleValue);
        searchButton.click();
        return new LogInPage();
    }
}
