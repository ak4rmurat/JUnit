package tests.day08_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){
        // Masaustunde logo.png dosyasinin oldugunu test edin

        String dosyaYolu = "C:\\Users\\MURAT\\Desktop\\logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // Dosya yolu yukaridaki gibi yazilirsa sadece o bilgisayarda calisir.
        // Testin tum bilgisayarlarda calisabilmesi icin dosya yolunu dinamik yapmamız gerekir.

        System.out.println(System.getProperty("user.home"));

        // C:\Users\MURAT
        // Bu kod bize bilgisayarımızdaki kullanicinin ana dosya yolunu verir.

        System.out.println(System.getProperty("user.dir"));

        // C:\Users\MURAT\Desktop\JUnit
        // Buda icinde calistigimiz projenin dosya yolunu verir.

        /*
            Masaustundeki dosyanın dosya yolu :

            C:\Users\MURAT      /Desktop/logo.png
                bana ozel           herkeste ayni
           System.getProperty("user.home")

         */

        String dinamikDosyaYolu = System.getProperty("user.home")+"/Desktop/logo.png";
        System.out.println(dinamikDosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

        // day08 package'inda deneme.txt dosyasinin oldugunu test edin

        dosyaYolu = "C:\\Users\\MURAT\\Desktop\\JUnit\\src\\test\\java\\tests\\day08_actions_faker_fileTestleri\\deneme.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); // Bu sadece kullanicida casliri

        dinamikDosyaYolu = System.getProperty("user.dir")+"\\src\\test\\java\\tests\\day08_actions_faker_fileTestleri\\deneme.txt";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu))); // Bu kod ise herkeste calisir.

    }
}