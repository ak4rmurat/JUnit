package tests.day09_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeAfter;

public class C03_KlasikKodlarlaYapilmayanWebTables extends TestBase_BeforeAfter {

    @Test
    public void test01(){
       // 1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");
       // 2. Headers da bulunan basliklari yazdirin

        WebElement baslikSatirElementi = driver.findElement(By.xpath("//div[@role='hrow']"));
        System.out.println("Baslik Satiri : " + baslikSatirElementi.getText());
       // 3. 3.sutunun basligini yazdirin
       // 4. Tablodaki tum datalari yazdirin
       // 5. Tabloda kac tane cell (data) oldugunu yazdirin
       // 6. Tablodaki satir sayisini yazdirin
       // 7. Tablodaki sutun sayisini yazdirin
       // 8. Tablodaki 3.kolonu yazdirin
       // 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
       // 10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde
       // bana datayi yazdirsin
    }
}
