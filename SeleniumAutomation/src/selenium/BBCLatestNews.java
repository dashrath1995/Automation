package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BBCLatestNews 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bbc.com");
		List<WebElement> news = driver.findElements(By.xpath("//a[@rev='most-popular|link']"));
		int count = news.size();
		for(int i=0; i<count; i++)
		{
			String text=news.get(i).getText();
			System.out.println(text);
		}
		driver.close();
	}
}
