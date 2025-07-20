package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    private WebDriver driver;
    private By productsTitle = By.className("title");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsTitleDisplayed() {
        return driver.findElement(productsTitle).isDisplayed();
    }
}
