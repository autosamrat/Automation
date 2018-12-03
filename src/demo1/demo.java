package demo1;

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
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class demo {
	static {
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
	}
	@Test
	public static void loginPage() throws EncryptedDocumentException, InvalidFormatException, IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ArrayList<String> userName = readXlData(0);
		ArrayList<String> passWord = readXlData(1);
		
		for(int i=0; i<userName.size(); i++) {
		driver.findElement(By.id("username")).sendKeys(userName.get(i));
		driver.findElement(By.name("pwd")).sendKeys(passWord.get(i));
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		String title = driver.getTitle();
		//Assert.assertTrue(title.contains("Enter"));
		//or
		if(title.contains(title)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		driver.findElement(By.id("logoutLink")).click();
		}
	}
	public static ArrayList<String> readXlData(int colNo) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\ssamr\\git\\Automation\\data\\input.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet s = wb.getSheet("Sheet1");
		Iterator<Row> row = s.iterator();
		ArrayList<String> list = new ArrayList<String>();
		row.next();
		while(row.hasNext()) {
			list.add(row.next().getCell(colNo).getStringCellValue());
		}
		return list;
	}
}
