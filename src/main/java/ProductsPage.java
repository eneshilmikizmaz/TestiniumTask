import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    By shippingOptionLocator = By.className("product-link");
    By productNameLocator = new By.ByCssSelector("li.catalog-seem-cell");
    By pageLocator=new By.ByCssSelector(".pager ul li");
    By highPriceLocator=new By.ById("sp-price-highPrice");
    By lowPriceLocator=new By.ById("sp-price-lowPrice");
    By discountPriceLocator=new By.ById("sp-price-discountPrice");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void selectPage(int i)
    {
        getAllPages().get(i).click();
    }
    private List<WebElement> getAllPages(){
        return findAll(pageLocator);
    }
    public boolean isOnProductPage() {
        return isDisplayed(shippingOptionLocator);
    }
    public void selectRandomProduct() {
        getAllProducts().get(new Random().nextInt(getAllProducts().size()-1)).click();
    }
    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    public String getPrice() {
        String price="";
        price=find(highPriceLocator).getText();
        if(!find(lowPriceLocator).getText().isEmpty())
            price=find(lowPriceLocator).getText();
        if(!find(discountPriceLocator).getText().isEmpty())
            price=find(discountPriceLocator).getText();
        return price;
    }
}