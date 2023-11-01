package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CarDekho 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.cardekho.com/");
		List<WebElement> carBrandList = driver.findElements(By.xpath("//div[@class='shadow24 brandMain  popularbrands']/descendant::li/descendant::span"));
		int count=carBrandList.size();
		//System.out.println(count);
		for(int i=0; i<count;i++)
		{
			String text=carBrandList.get(i).getText();
			System.out.println(text);
		}
	}
}
