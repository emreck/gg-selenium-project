import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Stack;

public class HomePage extends BasePage {


    SearchArea searchArea;
    By cookiesAcceptLocator = By.xpath("//*[text()[contains(.,'Kapat')]]");

    public HomePage(WebDriver driver) {
        super(driver);
        searchArea = new SearchArea(driver);

    }

    public SearchArea searchArea() {
        return this.searchArea;
    }


    public void acceptCookies() {
        if (isDisplayed(cookiesAcceptLocator)) {
            click(cookiesAcceptLocator);
        }
    }
}
