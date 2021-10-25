import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchArea extends BasePage {

    By searchLocator = By.xpath("//input[@placeholder=\"Keşfetmeye Bak\"]");
    By searchButtonLocator = By.xpath("//span[text()=\"BUL\"]");


    public SearchArea(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchLocator, text);
        click(searchButtonLocator);
    }
}
