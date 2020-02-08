package pages;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testCase {
	public static void main(String[] args) {
		todoTest test = new todoTest();
		test.LoginStart();
		test.SearchUrun();
		test.searchPage2();
		test.searchPage2ok();
		test.searchProduct();
		test.basketAdd();
		test.priceProduct();
		test.quitDriver();
	}
}
