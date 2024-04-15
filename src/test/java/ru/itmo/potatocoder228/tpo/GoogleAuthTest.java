package ru.itmo.potatocoder228.tpo;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class GoogleAuthTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    //C:\Users\sasha\AppData\Local\Google\Chrome\User Data
    options.addArguments("--user-data-dir=C:\\Users\\sasha\\AppData\\Local\\Google\\Chrome\\User Data");
    // options.addArguments("--profile-directory=Default");
    // options.addArguments("--headless=new");
    // options.addArguments("--no-sandbox");
    driver = new ChromeDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void auth() {
    driver.get("https://auto.ru/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.xpath("//div[@id=\'app\']/div/div/header/div/div/div[6]/a/span")).click();
    driver.findElement(By.xpath("//a[@id=\'yandex\']/span[2]")).click();
    driver.findElement(By.xpath("//div[@id=\'root\']/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[2]/div/ul/li/div/a/div/div/div/span")).click();
    {
      WebElement element = driver.findElement(By.xpath("//div[@id=\'app\']/div/div/header/div/div/div[6]/div/a/img"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".IconSvg_name_SvgLogout")).click();
  }
}
