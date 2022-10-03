import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import screens.MainScreen;
import utils.ScreenFactory;

import java.util.stream.Stream;

/**
 * @author oleg on 03.10.2022
 */
public class MainScreenTest extends BaseTest{
  private final String searchText = "Printed";
  private final String pageTitle = "My Store";

  @Test
  public void resultativeSearchTest(){
    MainScreen mainScreen = ScreenFactory.createScreen(MainScreen.class, getDriver()).openPage();
        mainScreen.useSearch(searchText).getSearchItems();
    Assert.assertTrue(Stream.of(mainScreen).count() > 0);
  }
  @Test
  public void checkTitle(){
    MainScreen mainScreen = ScreenFactory.createScreen(MainScreen.class, getDriver()).openPage();
    String title = mainScreen.getTitle();
    Assert.assertTrue(title.equals(pageTitle));
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    getDriver().quit();
  }
}
