package tests.day05_assertion_dropDownMenu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_BeforeAfter;

public class C08_DropdownMenuTesti extends TestBase_BeforeAfter {

    //● https://testotomasyonu.com/form adresine gidin.
    //1. Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //	4. Secilen değerleri konsolda yazdirin
    //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
    //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin


    @Test
    public void test01() {

        driver.get("https://testotomasyonu.com/form");

        WebElement dogumTarihiGun = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select select1 = new Select(dogumTarihiGun);
        select1.selectByVisibleText("5");

        WebElement dogumTarihiAy = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select select2 = new Select(dogumTarihiAy);
        select2.selectByVisibleText("Nisan");
        WebElement dogumTarihiYil = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select select3 = new Select(dogumTarihiYil);
        select3.selectByVisibleText("1991");

        System.out.println("Gun : " + select1.getFirstSelectedOption().getText()
                            +"\nAy : " + select2.getFirstSelectedOption().getText()
                            +"\nYil : " + select3.getFirstSelectedOption().getText());

        System.out.println();
    }

}
