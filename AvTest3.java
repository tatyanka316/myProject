

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AvTest3 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://id.rambler.ru";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAvTest3() throws Exception {
    driver.get(baseUrl + "/account/registration?referer=https%3A%2F%2Fid.rambler.ru%2Faccount%2Fregistration");
    driver.findElement(By.name("password.main")).click();
    driver.findElement(By.name("password.main")).clear();
    driver.findElement(By.name("password.main")).sendKeys(">");
    driver.findElement(By.name("password.confirm")).clear();
    driver.findElement(By.name("password.confirm")).sendKeys(".");
    try {
    	 assertEquals("exact:Символ ">" не поддерживается. Можно использовать символы ! @ $ % ^ & * ( ) _ - +", driver.findElement(By.xpath("//div[@id='root']/div/div/form/div/section/div/div/div[2]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
