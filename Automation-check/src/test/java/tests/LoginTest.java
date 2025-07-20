package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Home;
import pages.Login;

public class LoginTest {
    private WebDriver driver;
    private Login loginPage;
    private Home homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new Login(driver);
        homePage = new Home(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.isProductsTitleDisplayed(), "Login failed or Products page not displayed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}