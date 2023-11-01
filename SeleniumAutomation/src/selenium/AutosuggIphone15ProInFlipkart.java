package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggIphone15ProInFlipkart
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
		driver.findElement(By.xpath("//div[@class='JFPqaw']/child::span")).click();
		driver.findElement(By.name("q")).sendKeys("iphone 15 pro max");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='iphone 15 pro max']")).click();
		 List<WebElement> list = driver.findElements(By.xpath("//div[contains(text(),'APPLE Iphone 15 Pro Max')]|//div[contains(text(),'APPLE Iphone 15 Pro Max')]/parent::div/following-sibling::div/child::div[1]/child::div[1]"));
		 int count=list.size();
		 for(int i=0; i<count; i++)
		 {
			 String text=list.get(i).getText();
			 System.out.println(text);
			 System.out.println();
		 }
		 driver.close();
		 
	}
}
