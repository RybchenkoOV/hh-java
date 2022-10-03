import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ScreenFactory;

/**
 * @author oleg on 03.10.2022
 */
public class BaseTest extends ScreenFactory {

  private static WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void setup(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }

  public static WebDriver getDriver() {
    return driver;
  }
}
