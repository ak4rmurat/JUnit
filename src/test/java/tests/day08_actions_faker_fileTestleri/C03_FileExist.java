package tests.day08_actions_faker_fileTestleri;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.File;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist extends TestBase_BeforeAfter {

    @Test
    public void test01(){
       // 1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
       // 2. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        ReusableMethods.bekle(3);
       // 3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // Java ile bir dosyanın bilgisayarımızda oldugunu test etmek için o dosyanın
        // dosya yoluna ihtiyac duyariz.

        String dosyaYolu = "C:/Users/MURAT/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        String masaustuDosyaYolu = "C:/Users/MURAT/Desktop/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

    }
}
