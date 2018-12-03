package demo;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {
	static{
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ArrayList<String> userName = readXlData(0);
		ArrayList<String> passWord = readXlData(1);
		for(int i=0; i<userName.size(); i++) {
		driver.findElement(By.id("username")).sendKeys(userName.get(i));
		driver.findElement(By.name("pwd")).sendKeys(passWord.get(i));
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("logoutLink")).click();
		
		Thread.sleep(5000);
		}

	}
	
	public static ArrayList<String> readXlData(int cellNo) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream file= new FileInputStream("C:\\Users\\ssamr\\git\\Automation\\data\\input.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet s = wb.getSheet("Sheet1");
		Iterator<Row> row = s.iterator();
		row.next();
		ArrayList<String> list = new ArrayList<String>();
		while(row.hasNext()) {
			list.add(row.next().getCell(cellNo).getStringCellValue());
		
		}
		
		System.out.println(list);
		return list;
		
	  }
}
