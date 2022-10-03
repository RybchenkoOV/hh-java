package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import screens.BaseScreen;


/**
 * @author oleg on 03.10.2022
 */
public class ScreenFactory {

  public static <T extends BaseScreen> T createScreen(Class<T> sentClass, WebDriver driver) {
    return PageFactory.initElements(driver, sentClass);
  }
}
