package hello_test.hello_test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() {
        //ChromeOptions options = new ChromeOptions()
        //OperaOptions options = new OperaOptions()
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

        driver.get("http://localhost:3000/");
        Thread.sleep(2000);
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        assertEquals(vars.get("total").toString(), "€0.00");
        System.out.println("Total 0.00");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > td .input-group-append > .btn")).click();
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        assertEquals(vars.get("total").toString(), "€1.25");
        System.out.println("Añade 1 Robo Cola --- Total 1.25");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn")).click();
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        assertEquals(vars.get("total").toString(), "€3.25");
        System.out.println("Añade 1 Robo Beer --- Total 3.25");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) .input-group-append > .btn")).click();
        vars.put("total", driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText());
        assertEquals(vars.get("total").toString(), "€6.25");
        System.out.println("Añade 1 Robo Vino --- Total 6.20");
        driver.findElement(By.cssSelector(".btn-success")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(2)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(2)")).getText());
        assertEquals(vars.get("total").toString(), "1");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(3)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(3)")).getText());
        assertEquals(vars.get("total").toString(), "€1.25");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(4)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > .ng-binding:nth-child(4)")).getText());
        assertEquals(vars.get("total").toString(), "€1.25");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(2)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(2)")).getText());
        assertEquals(vars.get("total").toString(), "1");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(3)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(3)")).getText());
        assertEquals(vars.get("total").toString(), "€2.00");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(4)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > .ng-binding:nth-child(4)")).getText());
        assertEquals(vars.get("total").toString(), "€2.00");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(2)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(2)")).getText());
        assertEquals(vars.get("total").toString(), "1");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(3)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(3)")).getText());
        assertEquals(vars.get("total").toString(), "€3.00");
        driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(4)")).click();
        vars.put("total", driver.findElement(By.cssSelector(".ng-scope:nth-child(3) > .ng-binding:nth-child(4)")).getText());
        assertEquals(vars.get("total").toString(), "€3.00");
        System.out.println("Cantidades en preorder correctas ");
        driver.findElement(By.id("ageInput")).click();
        driver.findElement(By.id("ageInput")).sendKeys("34");
        System.out.println("Introduce 34 años");
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