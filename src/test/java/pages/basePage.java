package pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class basePage {

	WebDriver tarayici=new FirefoxDriver();
	public String URL="https://www.n11.com";
	public String geckodriversName="webdriver.gecko.driver";
	public String gdriversPath="/home/sum/Desktop/SeleniumWebOtomasyon-Testinium/testiniumProjeOdevi/SeleniumTest/drivers/geckodriver/geckodriver";
	
	@Before
	public void openTest()
	{	
		System.setProperty(geckodriversName, gdriversPath);
		//tarayici ac
		tarayici.manage().window().maximize();
		//n11.com Sitesi açılır
		tarayici.get(URL);
		
	}
	
	@After
	public void finishTest()
	{
		//tarayiciyı kapat
		tarayici.quit();
	}

}
