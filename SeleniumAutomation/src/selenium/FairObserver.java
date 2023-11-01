package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FairObserver 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fairobserver.com/");
		List<WebElement> lnews = driver.findElements(By.xpath("//div[@class='latest-news mart50']/descendant::h2[@itemprop='name']"));
		int count = lnews.size();
		System.out.println(count);
		for(int i=0; i<count; i++)
		{
			String text = lnews.get(i).getText();
			System.out.println(text);
			System.out.println();
		}
		driver.close();
	}
}
