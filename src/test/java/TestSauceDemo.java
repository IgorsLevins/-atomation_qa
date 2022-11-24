import lv.acodemy.constans.Generic;
import lv.acodemy.page_object.InventoryPage;
import lv.acodemy.page_object.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lv.acodemy.constans.Generic.SAUCE_URL;

public class TestSauceDemo {

    ChromeDriver driver;
    LoginPage loginPage;


    InventoryPage inventoryPage;

    @BeforeMethod(description = "Preconditions")
    public void initialize() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        driver.get(SAUCE_URL);
    }

    @Test
    public void authorizeTest() {

        loginPage.authorize("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.itemElementCount(), 6);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }



}
