import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Stack;

public class HomePage extends BasePage {
    SearchBox searchBox ;
    By cartCountLocator = new By.ByClassName("basket-item-count");
    By cartContainerLocator = new By.ByClassName("basket-container");
    By acceptCookiesLocator = new By.ByClassName("tyj39b-3");
    By loginButtonLocator = new By.ByClassName("gekhq4-5");
    By sigInButtonLocator = new By.ByCssSelector("a[href='https://www.gittigidiyor.com/uye-girisi?s=1']");
    By accountNameLocator = new By.ByCssSelector(".gekhq4-4 span");
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public boolean isProductCountUp() throws InterruptedException {
        return getCartCount() > 0 ;
    }
    public void goToLogin() throws InterruptedException {

        Thread.sleep(1000);
        if(isDisplayed(loginButtonLocator))
            click(loginButtonLocator);
        Thread.sleep(1000);
        click(sigInButtonLocator);
    }
    public void goToCart() throws InterruptedException {
        click(cartContainerLocator);
    }

    private int getCartCount() throws InterruptedException {
        //isDisplayed(cartCountLocator);
        Thread.sleep(1000);
        String count =find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }

    public boolean checkIsLogin(String username) {
        isDisplayed(accountNameLocator);
        return find(accountNameLocator).getText().equals(username);
    }
}
