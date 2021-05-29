import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By userNameLocator =new By.ByName("kullanici");
    By passwordLocator =new By.ByName("sifre");
    By submitButton = new By.ById("gg-login-enter");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void signIn(String email, String password) throws InterruptedException {
        if(isDisplayed(userNameLocator)){
            type(userNameLocator , email);
            type(passwordLocator , password);
            click(submitButton);
            Thread.sleep(1000);
        }
    }
}
