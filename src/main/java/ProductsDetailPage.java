import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class ProductsDetailPage extends BasePage {
    String fileName = "productFile.txt";
    String filePriceValue;
    String cartValuePrice;
    String productName;
    String productPrice;
    By productNameLocator = By.xpath("//h1[@id='sp-title']");
    By productPriceLocator = By.xpath("(//div[@id='sp-price-lowPrice'])[1]");
    By productCartLocator = By.xpath("(//form[@name='frm_add_chard'])[1]");


    By clickCartLocator = By.xpath("//a[@class='dIB']");

    By cartPriceValue = By.xpath("//div[@class='total-price']//strong");

    By increareseNumber = By.cssSelector("select[class='amount']");

    By emptyCart = By.xpath("//*[contains(text(), 'Sepetinizde ürün bulunmamaktadır.')]");

    By deleteProductLocator = By.xpath("(//a[@title='Sil'])[1]");

    public ProductsDetailPage(WebDriver driver) throws IOException {
        super(driver);


    }

    public void productInfoPrintFile() throws IOException {
        this.productName = find(productNameLocator).getText();
        this.productPrice = find(productPriceLocator).getText();
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWritter = new BufferedWriter(fileWriter);
        bWritter.write(productPrice + "\n");
        bWritter.write(productName);
        bWritter.close();
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(3000);
        find(productCartLocator).click();
        Thread.sleep(3000);
        find(clickCartLocator).click();

    }

    public boolean compareFilePrice() throws IOException {
        BufferedReader oku = new BufferedReader(new FileReader(fileName));
        filePriceValue = oku.readLine();
        cartValuePrice = find(cartPriceValue).getText();
        if (filePriceValue.contains(cartValuePrice)) {
            return true;
        } else
            return false;
    }

    public boolean compareNumber(int i) throws InterruptedException {
        Thread.sleep(2000);
        find(increareseNumber).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        find(increareseNumber).sendKeys(Keys.ENTER);
        if (isElementPresent(increareseNumber))
            return false;
        else
            return true;

    }

    public boolean isDeleteProduct() throws InterruptedException {
        find(deleteProductLocator).click();
        Thread.sleep(3000);
        if (find(emptyCart).isDisplayed())
            return true;
        else
            return false;
    }

}
