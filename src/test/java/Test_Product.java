import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_Product extends BaseTest {

    HomePage homePage; //anasayfa element
    ProductPage productPage;
    ProductsDetailPage productsDetailPage;

    @Test
    @Order(1)
    public void go_to_twopage() {

        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productPage = new ProductPage(driver);

        homePage.searchArea().search("bilgisayar"); //productSearch
        Assertions.assertTrue(productPage.isOnProductPage(), "Not on product page");
    }

    @Test
    @Order(2)
    public void compare_product_price() throws IOException, InterruptedException {
        productPage = new ProductPage(driver);
        productPage.selectRandomProduct();
        productsDetailPage = new ProductsDetailPage(driver);
        productsDetailPage.productInfoPrintFile();
        productsDetailPage.addToCart();
        Assertions.assertTrue(productsDetailPage.compareFilePrice(),
                "price is not equal");
    }


   @Test
    @Order(3)
    public void compare_product_number() throws IOException, InterruptedException {

       productsDetailPage = new ProductsDetailPage(driver);      ;
       Assertions.assertTrue(productsDetailPage.compareNumber(2),
               "Number is not equal");

    }
   @Test
    @Order(4)
    public void delete_product() throws IOException, InterruptedException {

       productsDetailPage = new ProductsDetailPage(driver);
       Assertions.assertTrue(productsDetailPage.isDeleteProduct(),
                "Product not removed");
    }


}
