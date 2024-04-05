package tests.tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.Set;

import static utilities.TestBase_BeforeAfterClass.driver;

public class alertYaziBilgisi extends TestBase_BeforeAfter {


    @Test
    public void test01(){


        //1."http://webdriveruniversity.com/" adresine gidin 2."Login Portal" a kadar asagi inin

        driver.get("http://webdriveruniversity.com/");

        String ilkWindow=driver.getWindowHandle();

        //3."Login Portal" a tiklayin

        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

        ReusableMethods.bekle(5);

        //4.Diger window'a gecin

        ReusableMethods.switchWindow(driver, "http://webdriveruniversity.com/Login-Portal/index.html");



        //5."username" ve "password" kutularina deger yazdirin


        // 6."login" butonuna basin

        Actions actions=new Actions(driver);

        WebElement login=driver.findElement(By.xpath("//*[@placeholder='Username']"));


        actions.click(login).sendKeys("Damra").sendKeys(Keys.TAB).sendKeys("12345").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        ReusableMethods.bekle(1);

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin 8.Ok diyerek Popup'i kapatin

        String expectedVali="Validation failed";

        driver.switchTo().alert().accept();


        //9.Ilk sayfaya geri donun

        ReusableMethods.switchWindow(driver,"https://webdriveruniversity.com/");

        //10.Ilk sayfaya donuldugunu test edin
        ReusableMethods.bekle(2);

        String expected="LOGIN PORTAL";

        String actual = driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).getText();

        Assert.assertEquals(expected,actual);






    }
}
