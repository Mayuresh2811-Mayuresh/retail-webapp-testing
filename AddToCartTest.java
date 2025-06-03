package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AddToCartTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://example-retailapp.com");
    }

    @Test
    public void testAddToCart() {
        driver.findElement(By.id("searchBox")).sendKeys("Laptop");
        driver.findElement(By.id("searchBtn")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        String cartCount = driver.findElement(By.id("cart-count")).getText();
        assert cartCount.equals("1");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
