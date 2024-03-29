package tests.day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C05_FileUpload extends TestBase_BeforeAfter {

    @Test
    public void test01(){

       // 1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
       // 2.chooseFile butonuna basalim
       // 3.Package icersindeki deneme.txt dosyasini secelim.

        // Bilgisayarimizda bulunan dosyalarla webDriver ile ulacamayacağımız için
        // choseFile butonuna yüklemek istedigimiz dosyanın dosya yollunu yollamamiz yeterli.

    // C:\Users\MURAT\Desktop\JUnit\src\test\java\tests\day08_actions_faker_fileTestleri\deneme.txt
        String dinamikDosyaYolu = System.getProperty("user.dir") +
                "\\src\\test\\java\\tests\\day08_actions_faker_fileTestleri\\deneme.txt";
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys(dinamikDosyaYolu);



        ReusableMethods.bekle(2);
       // 4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
       // 5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileText = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        String expectedYazi = "File Uploaded!";
        String actualYazi = fileText.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(2);

    }
}
