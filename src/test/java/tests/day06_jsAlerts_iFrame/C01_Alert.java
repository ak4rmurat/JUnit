package tests.day06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfterClass;

public class C01_Alert extends TestBase_BeforeAfterClass {

    //1. Test
    @Test
    public void test01(){
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo().alert().getText();
        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }
    //2.Test
    @Test
    public void test02(){
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String expectedSonucYazi = "You clicked: Cancel";
        String actualSonucYazi = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        Assert.assertEquals(expectedSonucYazi,actualSonucYazi);
    }
    //3.Test
    @Test
    public void test03(){
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //	- Cikan prompt ekranina "Rasit" yazdiralim
        driver.switchTo().alert().sendKeys("Rasit");
        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //	- Cikan sonuc yazisinin Rasit icerdigini test edelim
        String expectedYazi = "Rasit";
        String actualYazi = driver.findElement(By.xpath("//p[@id='result']")).getText();
        driver.switchTo().newWindow(WindowType.WINDOW);
        Assert.assertTrue(actualYazi.contains(expectedYazi));
    }


}
