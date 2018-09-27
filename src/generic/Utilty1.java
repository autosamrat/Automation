package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.xml.crypto.Data;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;


public class Utilty1 {


	public static String getPopertyValue(String path, String key) {
		
		String v="";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			v = p.getProperty(key);
		}
		catch(Exception e){	
			e.printStackTrace();
		}
		return v;
	}
	public static String getXLData(String path, String sheet, int r, int c) {
		String v="";
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			v=w.getSheet(sheet).getRow(r).getCell(c).toString();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
			return v;
		
	}
	public static int getXLRowCount(String path, String sheet) {
		int count=0;
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			count=w.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public static string getPhoto(WebDriver driver, String folder) {
		Data d = new Data();
		String dateTime = d.toString().replace(":", "-");
		String path = folder+
		
		
		
		
		
		
		
		
		
		
	}
}
