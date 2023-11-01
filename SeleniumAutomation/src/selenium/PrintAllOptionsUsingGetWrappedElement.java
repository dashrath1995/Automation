package selenium;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintAllOptionsUsingGetWrappedElement 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Me/Desktop/hotel.html");
		WebElement cpList = driver.findElement(By.id("cp"));
		Select s=new Select(cpList);
		String text=s.getWrappedElement().getText();
		System.out.println(text);
		driver.close();
	}

}
