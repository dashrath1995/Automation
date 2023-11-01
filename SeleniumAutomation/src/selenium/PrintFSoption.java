package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintFSoption 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Me/Desktop/hotel.html");
		WebElement cpList = driver.findElement(By.id("cp"));
		Select s=new Select(cpList);
		WebElement fsOption = s.getFirstSelectedOption();
		String text=fsOption.getText();
		System.out.println(text);
	}
}
