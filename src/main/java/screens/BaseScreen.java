package screens;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ScreenFactory;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author oleg on 03.10.2022
 */
public class BaseScreen extends ScreenFactory {
  WebDriver driver;
  public static Logger logger = Logger.getLogger(String.valueOf(BaseScreen.class));

  public BaseScreen(WebDriver driver) {

    WebDriverManager.chromedriver().setup();
    this.driver = driver;
    this.driver = new ChromeDriver();
  }

  public WebElement findElement(By by) {
    return driver.findElement(by);
  }

  public List<WebElement> findElements(By by) {
    return driver.findElements(by);
  }

  public void openSelectedPage(String url) {
    driver.get(url);
  }

  public void refreshPage() {
    driver.navigate().refresh();
  }

  public void goBack() {
    driver.navigate().back();
  }

  public void goForward() {
    driver.navigate().forward();
  }

  public String getTitle() {
    return driver.getTitle();
  }
}
