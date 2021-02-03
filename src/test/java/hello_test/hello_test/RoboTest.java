package hello_test.hello_test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() {
        FirefoxOptions options= new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void roboTest() throws InterruptedException {
        // Test name: RoboTest
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);
        // 2 | storeText | css=tr:nth-child(4) > .ng-binding | total
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        // 3 | assert | total | €0.00
        assertEquals(vars.get("total").toString(), "€0.00");
        System.out.println("Total 0.00");
        // 4 | click | css=.ng-scope:nth-child(1) > td .input-group-append > .btn |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > td .input-group-append > .btn")).click();
        // 5 | storeText | css=tr:nth-child(4) > .ng-binding | total
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        // 6 | assert | total | €1.25
        assertEquals(vars.get("total").toString(), "€1.25");
        System.out.println("Añade 1 Robo Cola --- Total 1.25");
        // 7 | click | css=.ng-scope:nth-child(2) > td .input-group-append > .btn |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn")).click();
        // 8 | storeText | css=tr:nth-child(4) > .ng-binding | total
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        // 9 | assert | total | €3.25
        assertEquals(vars.get("total").toString(), "€3.25");
        System.out.println("Añade 1 Robo Beer --- Total 3.25");
        // 10 | click | css=.ng-scope:nth-child(3) .input-group-append > .btn |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) .input-group-append > .btn")).click();
        // 11 | storeText | css=tr:nth-child(4) > .ng-binding | total
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        // 12 | assert | total | €6.25
        assertEquals(vars.get("total").toString(), "€6.25");
        System.out.println("Añade 1 Robo Vino --- Total 6.20");
        // 13 | click | css=.btn-success |
        driver.findElement(By.cssSelector(".btn-success")).click();
        Thread.sleep(2000);
        // 17 | click | css=.ng-scope:nth-child(1) > .ng-binding:nth-child(2) |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(2)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(2)")).getText());
        assertEquals(vars.get("total").toString(), "1");
        // 18 | click | css=.ng-scope:nth-child(1) > .ng-binding:nth-child(3) |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(3)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(3)")).getText());
        assertEquals(vars.get("total").toString(), "€1.25");
        // 19 | click | css=.ng-scope:nth-child(1) > .ng-binding:nth-child(4) |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(4)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(4)")).getText());
        assertEquals(vars.get("total").toString(), "€1.25");
        // 20 | click | css=.ng-scope:nth-child(2) > .ng-binding:nth-child(2) |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(2)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(2)")).getText());
        assertEquals(vars.get("total").toString(), "1");
        // 21 | click | css=.ng-scope:nth-child(2) > .ng-binding:nth-child(3) |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(3)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(3)")).getText());
        assertEquals(vars.get("total").toString(), "€2.00");
        // 22 | click | css=.ng-scope:nth-child(2) > .ng-binding:nth-child(4) |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(4)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(4)")).getText());
        assertEquals(vars.get("total").toString(), "€2.00");
        // 23 | click | css=.ng-scope:nth-child(3) > .ng-binding:nth-child(2) |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(2)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(2)")).getText());
        assertEquals(vars.get("total").toString(), "1");
        // 24 | click | css=.ng-scope:nth-child(3) > .ng-binding:nth-child(3) |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(3)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(3)")).getText());
        assertEquals(vars.get("total").toString(), "€3.00");
        // 25 | click | css=.ng-scope:nth-child(3) > .ng-binding:nth-child(4) |
        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(4)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(4)")).getText());
        assertEquals(vars.get("total").toString(), "€3.00");
        System.out.println("Cantidades en preorder correctas ");
        // 14 | click | id=ageInput |
        driver.findElement(By.id("ageInput")).click();
        // 15 | type | id=ageInput | 34
        driver.findElement(By.id("ageInput")).sendKeys("34");
        System.out.println("Introduce 34 años");
        // 16 | click | css=.btn-success |
        driver.findElement(By.cssSelector(".btn-success")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".display-4")).click();
        vars.put("total", driver.findElement(By.cssSelector(".display-4")).getText());
        assertEquals(vars.get("total").toString(), "3 drinks");
        Thread.sleep(2000);
        System.out.println("Total 3 bebidas");
        driver.findElement(By.cssSelector("p")).click();
        vars.put("total", driver.findElement(By.cssSelector("p")).getText());
        assertEquals(vars.get("total").toString(), "Coming right up! ~bzzzt~");
        System.out.println("Pedido con exito¡¡¡¡");
    }
}