// Generated by Selenium IDE
package hello_test.hello_test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class GoogeTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {
    //ChromeOptions options = new ChromeOptions()
    //OperaOptions options = new OperaOptions()
    FirefoxOptions options= new FirefoxOptions();
    options.setHeadless(false);
    driver = new FirefoxDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void googe() {
    // Test name: googe
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("https://www.google.com/");
    try {
      // 2 posiciona en el frame
      driver.switchTo().frame(0);
      // 3 busca el boton aceptar
      driver.findElement(By.id("introAgreeButton")).click();
    }
    catch(Exception e) {
      System.out.println("No existe ventana 'antes de continuar'");
    }
    // 4 posiciona frame general
    driver.switchTo().defaultContent();
    // 5 | click | name=q |
    driver.findElement(By.name("q")).click();
    // 6 | type | name=q | devops
    driver.findElement(By.name("q")).sendKeys("devops");
    // 7 | sendKeys | name=q | ${KEY_ENTER}
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
  }
}
