import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage extends BasePage {

    By productNameLocator = new By.ByCssSelector("div.product-item-box-container");
    By backetContainer = new By.ById("submit-cart");
    By backetPriceContainer = new By.ByClassName("new-price");
    By counterLocator = new By.ByCssSelector("select.amount");
    By productCountLocator = new By.ByClassName("detail-text");
    By deleteButtonLocator = new By.ByClassName("btn-delete");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfBacket() {
        return getProducts().size() == 0 ;
    }
    public void deleteProduct() throws InterruptedException {
        click(deleteButtonLocator);
        Thread.sleep(1000);
    }
    public void countChange(int count) throws InterruptedException {
        Select countSelect=new Select(find(counterLocator));
        countSelect.selectByValue(String.valueOf(count));
        Thread.sleep(2000);
    }
    public boolean checkCount(int count) {
        String rawText=find(productCountLocator).getText();
        String countText=rawText.substring(rawText.indexOf('(')+1,rawText.lastIndexOf('A')-1);
        return Integer.parseInt(countText)==count;
    }
    public boolean checkProductPriceCompare(String price)
    {
        String value=find(backetPriceContainer).getText();
        return find(backetPriceContainer).getText().equals(price);
    }
    private List<WebElement> getProducts(){
        isDisplayed(backetContainer);
        return findAll(productNameLocator);
    }
}