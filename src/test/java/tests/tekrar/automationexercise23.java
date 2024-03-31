package tests.tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.security.Key;

public class automationexercise23 extends TestBase_BeforeAfter {
    @Test
    public void test01() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        String expecteUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expecteUrl,actualUrl);
        // 4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        // 5. Fill all details in Signup and create account
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
        nameBox.sendKeys("Murat" + Keys.TAB +
                         "muratakar@yaho.com");
        driver.findElement(By.xpath("//*[text()='Signup']")).click();
        driver.findElement(By.xpath("//input[@value='Mr']")).click();
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("123456789" +Keys.TAB +
                            "2" + Keys.TAB +  "june" + Keys.TAB + "1991"+
                            Keys.TAB+Keys.TAB+Keys.TAB+
                            "Murat" + Keys.TAB + "Akar" + Keys.TAB+Keys.TAB+
                            "ISTANBUL" + Keys.TAB+Keys.TAB+
                            "Canada" + Keys.TAB + "ıstanbul" +Keys.TAB+ "umraniye" + Keys.TAB+
                            "34000"+Keys.TAB+"905555555555");
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();

        // 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountYazisi = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        String expectedYazi = "ACCOUNT CREATED!";
        String actualYazi = accountYazisi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        ReusableMethods.bekle(2);

        // 7. Verify ' Logged in as username' at top
        WebElement loginKontrol = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        String actualLoginYazi = loginKontrol.getText();
        String expectedLoginYazi = "Logged in as Murat";
        Assert.assertEquals(expectedLoginYazi,actualLoginYazi);


        // 8. Add products to cart
        // 9. Click 'Cart' button
        // 10. Verify that cart page is displayed
        // 11. Click Proceed To Checkout
        // 12. Verify that the delivery address is same address filled at the time registration of account
        // 13. Verify that the billing address is same address filled at the time registration of account
        // 14. Click 'Delete Account' button
        // 15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();

        ReusableMethods.bekle(2);
    }
}
