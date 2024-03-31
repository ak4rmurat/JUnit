package tests.tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.awt.*;

public class day08_C02 extends TestBase_BeforeAfter {

    @Test
    public void test01() {
        //1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //2- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@frameborder='0']"));
        driver.switchTo().frame(iframeElement);
        //3- videoyu izlemek icin Play tusuna basin
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        //4- videoyu calistirdiginizi test edin
        WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        ReusableMethods.bekle(1);
        Assert.assertTrue(playButton.isDisplayed());

        ReusableMethods.bekle(2);
    }

}
