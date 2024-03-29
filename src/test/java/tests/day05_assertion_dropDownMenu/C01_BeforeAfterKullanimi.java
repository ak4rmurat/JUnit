package tests.day05_assertion_dropDownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C01_BeforeAfterKullanimi extends TestBase_BeforeAfter {

    // testotomasyonu anasayfaya gidin
    // nutella icin arama yapin
    // arama sonucunda urun bulunabildigini test edin
    // arama sonucunda urun bulunabildigini test edin
    // sayfayı kapatın

    @Test
    public void test01(){
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='search-input']"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        WebElement aramaBilgisi = driver.findElement(By.xpath("//span[@class='product-count-text']"));

        String aramaYazisi = aramaBilgisi.getText();
        List<String> aramaList = List.of(aramaYazisi.split(" "));
        Assert.assertTrue(aramaList.get(0).equals("0"));


    }

}
