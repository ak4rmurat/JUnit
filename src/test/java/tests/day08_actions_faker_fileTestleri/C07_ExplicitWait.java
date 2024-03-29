package tests.day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C07_ExplicitWait {
    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Remove butonuna basin.
    //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //4. Add buttonuna basin
    //5. It’s back mesajinin gorundugunu test edin

    @Test
    public void explicitWaitTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        WebElement itsGoneYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneYazisi.isDisplayed());

        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();
        WebElement itsBackYazisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackYazisi.isDisplayed());

        ReusableMethods.bekle(2);
        driver.quit();

    }


}
