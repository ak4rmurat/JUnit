package day04_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_JUnitIlkTest {

    /*
    JUnit'in bize sagladigi en buyuk avantajlardan biri @Test notasyonudur.
    @Test sayesinde siradan methodlar bagimsiz olarak çalışabilecek test methodlarına donusur.

    JUnit'de bir class'daki test method'larinin hangi sira ile calisacagi ONGORULEMEZ ve DUZENLENEMEZ.
     */
    // Asagidaki 3 websayfasine gidip, o sayfalara gittigimizi test edin
    // testler birlikte veya ayri ayri calistirilabilmelidir.
    // youtube. testotomasyonu, wisequarter

    @Test @Ignore
    public void youtubeTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Test PASSED");
        }else {
            System.out.println("Youtube Test FAILED");
        }

        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void testOtomasyonuTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test Otomasyonu Test PASSED");
        }else {
            System.out.println("Test Otomasyonu Test FAILED");
        }

        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void wiseQuarterTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Test PASSED");
        }else {
            System.out.println("Wisequarter Test FAILED");
        }

        ReusableMethods.bekle(2);
        driver.quit();
    }



}
