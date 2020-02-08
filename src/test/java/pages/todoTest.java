package pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class todoTest {
	WebDriver tarayici=new FirefoxDriver();

	public String URL="https://www.n11.com";
	public String geckodriversName="webdriver.gecko.driver";
	public String gdriversPath="/home/sum/Desktop/SeleniumWebOtomasyon-Testinium/testiniumProjeOdevi/SeleniumTest/drivers/geckodriver/geckodriver";
	

	
	public void siteOpen(){
		System.setProperty(geckodriversName, gdriversPath);
		//tarayici ac
		tarayici.manage().window().maximize();
		//n11.com Sitesi açılır
		tarayici.get(URL);
		/*
		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		tarayici.quit();*/
	}
	
	
	public void LoginStart() {
		//n11.com Login sayfasını aç
		btnClick("//a[@href='https://www.n11.com/giris-yap']");
		//Üye girişi yaptır
		sendKeys("//input[@id='email']", "smyye@hotmail.com");
		sendKeys("//input[@id='password']", "123321sm");
		btnClick("//div[@id='loginButton']");
		tarayici.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	public void SearchUrun() {
		//Arama kutucuğuna bilgisayar kelimesi girilir.
		sendKeys("//input[@id='searchData']", "bilgisayar");
		//arama butonuna basılır
		btnClick("//a[@class='searchBtn']");
		tarayici.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	//Arama sonuçları sayfasından 2.sayfa açılır.
	public void searchPage2() {
		btnClick("//a[@href='https://www.n11.com/arama?q=samsung&pg=2']");
        System.out.println("2.Sayfa");

	}
	
	//2.sayfanın açıldığı kontrol edilir.
	public void searchPage2ok()
	{
		try {
			Assert.assertTrue(tarayici.getTitle().equals("B - n11.com - 2/50"));
	    	System.out.println("2. SAyfa Açıldı !");
		 }catch(Exception e){
			 System.out.println("2. Sayfa Görüntülenemed !");
	     		}
	}
	public void searchProduct()
	{
		//ürün arama
		//rastgele ürün seçilir
		tarayici.findElement(By.className("proSubTitle")).click();
		System.out.println("Ürün seçildi");
	}
	public void basketAdd() {
		//Seçilen ürün sepete eklenir.
        tarayici.findElement(By.className("btnAddBasket")).click();

	}
	
	//Ürün†sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
	public void priceProduct()
	{
		String priceProduct1 = tarayici.findElement(By.xpath("//div[@class='newPrice']//ins")).getText();
		System.out.println("Ürün sayfasındaki fiyatı : " + priceProduct1);	
		tarayici.findElement(By.xpath("//div//a[@class='btn btnBlack btnGoBasket']")).click();
		String priceProduct2 = tarayici.findElement(By.xpath("//div[@class='dtl total']/span[@class='price']")).getText();
		System.out.println("Ürünün sepette yer alan fiyatı : " + priceProduct2);
		if(priceProduct1.equals(priceProduct2))
		{
			System.out.println("Ürün fiyatları doğru");
		}
		else 
		{
			System.out.println("Ürün Fiyatları hatalı");
		}
	}
	
	
    
    public void quitDriver(){
        tarayici.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        tarayici.quit();
    }
    
    public void btnClick(String button) {
	
  	  tarayici.findElement(By.xpath(button)).click();
  	  tarayici.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  	  }
    public void sendKeys(String path, String key) {
    	tarayici.findElement(By.xpath(path)).sendKeys(key);
		
	}
	public void checkResults(String path,String searchname) {
			
		if(!tarayici.findElement(By.xpath(path)).getText().isEmpty() ) {
			System.out.println(searchname+ " sonuç bulundu!");
		}
			
		}
	
	public void checkFav(String path) {
		
		if(tarayici.findElement(By.xpath(path)).isDisplayed() ) {
			System.out.println("Ürün yer almıyor!");
		}
	

}
