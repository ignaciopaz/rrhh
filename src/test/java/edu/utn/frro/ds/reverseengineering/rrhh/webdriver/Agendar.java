package edu.utn.frro.ds.reverseengineering.rrhh.webdriver;

import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Agendar {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "c:\\java\\chromedriver.exe");
	driver = new ChromeDriver();
    //driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAgendar() throws Exception {
    driver.get("https://utn-frro-ds-rrhh.herokuapp.com/entrevista/agendar");
    driver.findElement(By.id("idBusquedaLaboral")).click();
    new Select(driver.findElement(By.id("idBusquedaLaboral"))).selectByVisibleText("Desarrollador Java");
    driver.findElement(By.id("idBusquedaLaboral")).click();
    driver.findElement(By.xpath("//input[@value='Enviar']")).click();
    driver.findElement(By.id("codCandidato")).click();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.add(Calendar.DATE, 7);
    String fechaEntrevista = sdf.format(c.getTime());
    driver.findElement(By.id("fecha")).sendKeys(fechaEntrevista);
    driver.findElement(By.xpath("//input[@value='Enviar']")).click();
    driver.findElement(By.xpath("//p")).click();
    assertEquals("Se confirmó la entrevista de John Java para la búsqueda Desarrollador Java el día "+fechaEntrevista, driver.findElement(By.xpath("//p")).getText());
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
