package tests.day04_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_Before_After_Notasyonlari {
    /*
    EGER her test method'undan önce mutlaka çalışmasını istediğimiz bir method varsa

     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    @Ignore
    public void youtubeTesti(){

        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Test PASSED");
        }else {
            System.out.println("Youtube Test FAILED");
        }

    }

    @Test
    public void testOtomasyonuTesti(){

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test Otomasyonu Test PASSED");
        }else {
            System.out.println("Test Otomasyonu Test FAILED");
        }

    }

    @Test
    public void wiseQuarterTesti(){

        driver.get("https://wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Test PASSED");
        }else {
            System.out.println("Wisequarter Test FAILED");
        }

    }
}
