package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateIphoneInFlipkart
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("(//button)[2]")).click();
		driver.findElement(By.name("q")).sendKeys("iphone");
		Thread.sleep(3000);
		List<WebElement> iphoneSugg = driver.findElements(By.xpath("//li"));
		int count=iphoneSugg.size();
		for(int i=0; i<count; i++)
		{
			String text=iphoneSugg.get(i).getText();
			System.out.println(text);
		}
		driver.close();
	}
}
