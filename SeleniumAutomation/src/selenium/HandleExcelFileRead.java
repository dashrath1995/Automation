package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleExcelFileRead 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String url = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String un= wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String pw = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
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
