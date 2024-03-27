package tests.day04_jUnitFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ZeroWebTest {


    /*
            1. http://zero.webappsecurity.com sayfasina gidin
            2. Signin buttonuna tiklayin
            3. Login alanine “username” yazdirin
            4. Password alanina “password” yazdirin
            5. Sign in buttonuna tiklayin
            6. Back tusu ile sayfaya donun
            7. Online Banking menusunden Pay Bills sayfasina gidin
            8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
            9. tarih kismina “2023-09-10” yazdirin
            10. Pay buttonuna tiklayin
            11. “The payment was successfully submitted.” mesajinin ciktigini test edin
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://zero.webappsecurity.com");

        driver.findElement(By.id("signin_button")).click();

        WebElement loginAlani = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginAlani.sendKeys("username" + Keys.TAB + "password");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();

        driver.findElement(By.id("pay_bills_link")).click();

        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("200" + Keys.TAB + "2024-03-27");

        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        WebElement massage = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));



        if (massage.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        ReusableMethods.bekle(2);
        driver.quit();


    }

}
