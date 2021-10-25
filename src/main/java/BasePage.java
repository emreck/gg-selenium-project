import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    WebDriver driver;
    public  BasePage(WebDriver driver){
        this.driver=driver;
    }
    //web elementlerini bulan kod
    public WebElement find(By locator){
        return    driver.findElement(locator);
    }
    //tüm elementleri getiriyor.
    public List<WebElement> findAll(By locator){

        return driver.findElements(locator);
    }
    //Bulsun tıklasın
    public void click(By locator){
        find(locator).click();
    }

    // bulsun yazsın
    public void type (By locator, String text){
        find(locator).sendKeys(text);
    }
    //gözüküyor mu gözükmüyor mu
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
