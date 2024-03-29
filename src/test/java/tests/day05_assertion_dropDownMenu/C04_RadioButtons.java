package tests.day05_assertion_dropDownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfterClass;

public class C04_RadioButtons extends TestBase_BeforeAfterClass {

    @Test
    public void test01(){

        // a. Verilen web sayfasına gidin.
        //      https://testotomasyonu.com/form
        // b. Cinsiyet Radio button elementlerini locate edin
        // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
        // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        driver.get("https://testotomasyonu.com/form");

        WebElement kadinYaziElementi = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        WebElement erkekYaziElementi = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
        WebElement digerYaziElementi = driver.findElement(By.xpath("//input[@id='inlineRadio3']"));

        erkekYaziElementi.click();



        Assert.assertTrue(erkekYaziElementi.isSelected());
        Assert.assertFalse(kadinYaziElementi.isSelected());
        Assert.assertFalse(digerYaziElementi.isSelected());
    }
}
