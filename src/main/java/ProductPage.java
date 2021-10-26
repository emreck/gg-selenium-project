import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    WebElement element;
    By twopage = By.xpath("//li[@data-testid='pagination-list-item'][2]");
    By twoPageCheck = By.xpath("(//div[@data-testid='productImageSlider'])[1]");

    By allProductElement = By.xpath("//span[@data-cy='buy-price']");


    public boolean isOnProductPage() {
        element = driver.findElement(By.xpath("//nav[@aria-label='pagination navigation']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        click(twopage);
        return isDisplayed(twoPageCheck);
    }

    public void selectRandomProduct() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(getAllProductsSize());
        findAll(allProductElement).get(randomNumber).click();
    }

    private int getAllProductsSize() {
        return findAll(allProductElement).size();
    }


}
