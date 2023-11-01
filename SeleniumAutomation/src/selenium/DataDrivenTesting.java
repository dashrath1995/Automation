package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTesting
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("URL");
		String un = p.getProperty("USERNAME");
		String pw=p.getProperty("PASSWORD");
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		driver.close();


	}
}
