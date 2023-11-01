package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MoviesDownload 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.moviesmod.com");
		driver.findElement(By.xpath("//input[@name='s']")).sendKeys("avatar 2 the way of water");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='ajax-search-results']/descendant::a")).click();
		/*String searchMovieNameText = driver.findElement(By.xpath("//h1")).getText();
		System.out.println(searchMovieNameText);
		driver.findElement(By.xpath("//h2[@class='title front-view-title']/child::a")).click();
		driver.findElement(By.xpath("//h4/span[text()='480p']/parent::h4/following-sibling::p[1]/descendant::span[@class='mb-text']")).click();*/

	}
}
