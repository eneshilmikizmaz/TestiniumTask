import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest{

    HomePage homePage ;
    ProductsPage productsPage ;
    LoginPage loginPage;
    ProductDetailPage productDetailPage ;
    CartPage cartPage ;
    @Test
    @Order(1)
    public void login_a_product() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.goToLogin();
        loginPage=new LoginPage(driver);
        loginPage.signIn("seleniumtest1234@yandex.com","test12");
        Assertions.assertTrue(homePage.checkIsLogin("slnmtst") ,
                "Login Fail!");
    }
    @Test
    @Order(2)
    public void search_a_product(){
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Bilgisayar");
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Not on products page!");
    }
    @Test
    @Order(3)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectPage(1);
        productsPage.selectRandomProduct();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page!");
    }

    @Test
    @Order(4)
    public void add_product_to_cart() throws InterruptedException {
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(),
                "Product count did not increase!");
    }

    @Test
    @Order(5)
    public void go_to_cart() throws InterruptedException {
        cartPage = new CartPage(driver);
        String price = productsPage.getPrice();
        homePage.goToCart();

        Assertions.assertTrue(cartPage.checkProductPriceCompare(price) ,
                "Product prices aren't equal!");
    }
    @Test
    @Order(6)
    public void count_change() throws InterruptedException {
        cartPage.countChange(2);
        Assertions.assertTrue(cartPage.checkCount(2) ,
                "Product was not added to cart!");
    }
    @Test
    @Order(7)
    public void delete_product() throws InterruptedException {
        cartPage.deleteProduct();

        Assertions.assertTrue(cartPage.checkIfBacket() ,
                "Product didn't deleted!");
    }
}
