package tests.day05_assertion_dropDownMenu;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C02_BeforeAfterKullanimi extends TestBase_BeforeAfter {

    // a. Verilen web sayfasına gidin.
    //     https://testotomasyonu.com/form
    // b. Sirt Agrisi ve Carpinti checkbox’larini secin
    // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    // d. Seker ve Epilepsi checkbox’larininin seçili

    @Test
    public void test01(){
        //a. Verilen web sayfasına gidin.
        driver.get(" https://testotomasyonu.com/form");
        // b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement clickSirtAgrisi = driver.findElement(By.xpath("//input[@id='gridCheck5']"));
        WebElement clickCarpinti = driver.findElement(By.xpath("//input[@id='gridCheck4']"));

        clickCarpinti.click();
        clickSirtAgrisi.click();

        // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assert.assertTrue(clickCarpinti.isSelected());
        Assert.assertTrue(clickSirtAgrisi.isSelected());

        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement checkBoxSeker = driver.findElement(By.xpath("//input[@id='hastalikCheck2']"));
        WebElement checkBoxEpilepsi = driver.findElement(By.xpath("//input[@id='hastalikCheck7']"));

        Assert.assertFalse(checkBoxEpilepsi.isSelected());
        Assert.assertFalse(checkBoxSeker.isSelected());




    }

}
