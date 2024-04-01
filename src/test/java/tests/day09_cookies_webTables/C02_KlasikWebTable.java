package tests.day09_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

import java.util.List;

public class C02_KlasikWebTable extends TestBase_BeforeAfter {

    @Test
    public void test01(){
       //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");
       //2.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());

       //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String  expectedBodyIcerik = "Comfortable Gaming Chair";
        String actualBodyIcerik = tumBodyElementi.getText();

        Assert.assertTrue(actualBodyIcerik.contains(expectedBodyIcerik));
       //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> elemanSatirList = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSize = 5;
        int actualSatirSize = elemanSatirList.size();

        Assert.assertEquals(expectedSatirSize,actualSatirSize);
       //5. Tum satirlari yazdirin
        System.out.println(ReusableMethods.stringListeDonustur(elemanSatirList));
        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> elemanSutunList = driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedSutunSize = 4;
        int actualSutunSize = elemanSutunList.size();

        Assert.assertEquals(expectedSutunSize,actualSutunSize);
       //7. 3.sutunu yazdirin
        List<WebElement> ucuncuSatirElement = driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println(ReusableMethods.stringListeDonustur(ucuncuSatirElement));

        //8. Tablodaki basliklari yazdirin
        List<WebElement> tabloBaslik = driver.findElements(By.xpath("//thead/tr/th"));

        System.out.println(ReusableMethods.stringListeDonustur(tabloBaslik));
        //9. Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
       //döndüren bir method olusturun
        System.out.println(getData(2, 3));// $40.00
        System.out.println(getData(4,1)); // Comfortable Gaming Chair

        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
        String expectedData = "Furniture";
        String actualData = getData(4,2);

        Assert.assertEquals(expectedData,actualData);

        ReusableMethods.bekle(2);



    }
    public String getData(int satir, int sutun){
        String dinamikXpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]";

        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenDataElementi.getText();
    }
}
