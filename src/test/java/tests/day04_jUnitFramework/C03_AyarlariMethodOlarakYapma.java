package tests.day04_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;



public class C03_AyarlariMethodOlarakYapma {

    WebDriver driver;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void tearDown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    @Ignore
    public void youtubeTesti(){
        setUp();

        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Test PASSED");
        }else {
            System.out.println("Youtube Test FAILED");
        }

        tearDown();
    }

    @Test
    public void testOtomasyonuTesti(){
        setUp();

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test Otomasyonu Test PASSED");
        }else {
            System.out.println("Test Otomasyonu Test FAILED");
        }

        tearDown();
    }

    @Test
    public void wiseQuarterTesti(){
        setUp();

        driver.get("https://wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter Test PASSED");
        }else {
            System.out.println("Wisequarter Test FAILED");
        }

        tearDown();
    }

}
