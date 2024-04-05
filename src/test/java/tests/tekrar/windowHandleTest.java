package tests.tekrar;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class windowHandleTest extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        driver.get("https://www.testotomasyonu.com");
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com.tr");
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com.tr");

        ReusableMethods.bekle(4);

        ReusableMethods.switchWindow(driver,"https://www.testotomasyonu.com/");
        ReusableMethods.bekle(2);
        ReusableMethods.switchWindow(driver, "https://www.amazon.com.tr/");
        ReusableMethods.bekle(10);
    }
}
