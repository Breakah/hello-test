package hello_test.hello_test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class imdbSearch_remote {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() throws MalformedURLException {
        //ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();
        //ChromeOptions chromeOptions = new ChromeOptions();
        //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), chromeOptions);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void imdbwandavision() {
        // Test name: imdb wandavision
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://www.imdb.com/");
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
        // 6 | type | name=q | wandavision
        driver.findElement(By.name("q")).sendKeys("wandavision");
        // 7 | sendKeys | name=q | ${KEY_ENTER}
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        WebElement busca = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("WandaVision")));
        busca.click();
        busca = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("TRIVIA")));
        busca.click();

        //Thread.sleep(2000);
        // 8 | click | linkText=WandaVision |
        //driver.findElement(By.linkText("WandaVision")).click();
        //Thread.sleep(2000);
        // 9 | click | linkText=TRIVIA |
        //driver.findElement(By.linkText("TRIVIA")).click();
    }

}
