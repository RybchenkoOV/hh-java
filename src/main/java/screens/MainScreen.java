package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;

/**
 * @author oleg on 03.10.2022
 */
public class MainScreen extends BaseScreen {

  private final String pageUrl = "http://automationpractice.com/index.php";
  private final By searchInput = By.id("search_query_top");
  private final By searchSubmit = By.xpath("//button[@class='btn btn-default button-search']");
  private final By searchResult = By.xpath("//*[@class='product_list grid row']");

  public MainScreen(WebDriver driver) {
    super(driver);
  }

  public MainScreen openPage() {
    logger.log(Level.INFO, "Открываю главную страницу");
    openSelectedPage(pageUrl);
    return this;
  }

  public String getPageTitle() {
    logger.log(Level.INFO, "Получаю название страницы");
    return getTitle();
  }

  public MainScreen useSearch(String text) {
    logger.log(Level.INFO, "Производим поиск");
    driver.findElement(searchInput).sendKeys(text);
    driver.findElement(searchSubmit).click();
  return this;
  }

  public List<WebElement> getSearchItems() {
    logger.log(Level.INFO, "Ждем и получаем результаты поиска");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
    wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
    return findElements(searchResult).stream().toList();
  }
}
