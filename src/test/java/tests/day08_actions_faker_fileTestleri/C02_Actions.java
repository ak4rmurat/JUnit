package tests.day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C02_Actions extends TestBase_BeforeAfter {

    @Test
    public void test01(){

        /*
                Bazi web sayfalari gorunmeyen webelementleri locate etmemize izin verirken,
            bazi web sayfaları izin vermez.

                Eger gorunmeyen bir elementi locate etmemize izin veriyorsa asagiya inmek icin
            actions.scrollToElement(); 'i kullanabiliriz.

                Eger izin vermiyorsa, Locate edemedigimiz bir webelementi hedef olarak action
            objesine veremeyiz bu durumda;

            actions.sendKeys(Keys.PAGE_DOWN);
            actions.sendKeys(Keys.ARROW_DOWN);
            tusları ile istenene bolgeye inebiliriz. Ancak bilgisayardan

       */

       //1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
       //2- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
       //3- videoyu izlemek icin Play tusuna basin
        WebElement iframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframeElementi);
        ReusableMethods.bekle(1);
        WebElement playTusu = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        playTusu.click();
       //4- videoyu calistirdiginizi test edin

        WebElement videoElement = driver.findElement(By.xpath("//video[@class='video-stream html5-main-video']"));
        ReusableMethods.bekle(1);
        actions.moveToElement(videoElement).perform();
        ReusableMethods.bekle(1);
        WebElement volume = driver.findElement(By.xpath("//button[@class='ytp-mute-button ytp-button']"));
        Assert.assertTrue(volume.isDisplayed());
        ReusableMethods.bekle(5);


    }
}
