package ru.itmo.potatocoder228.tpo;
// Generated by Selenium IDE
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
public class GoogleUnathorizedSearchTest {
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
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void unathorizedSearch() {
    driver.get("https://auto.ru/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.xpath("//div[@id=\'app\']/div/div/header/div/div/div[3]/div/label/div/span/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@id=\'app\']/div/div/header/div/div/div[3]/div/label/div/span/div[2]/input")).sendKeys("Audi");
    //driver.findElement(By.xpath("//div[@id=\'app\']/div/div/header/div/div/div[3]/div/label/div/span/div[2]/input")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//label[2]/button/span")).click();
    driver.findElement(By.xpath("//label[3]/button/span/span")).click();
    driver.findElement(By.cssSelector(".Button_hovered .Button__text")).click();
    js.executeScript("window.scrollTo(0,123)");
    js.executeScript("window.scrollTo(0,947)");
    vars.put("window_handles", driver.getWindowHandles());
    vars.put("win6544", waitForWindow(2000));
    driver.switchTo().window(vars.get("win6544").toString());
  }
}