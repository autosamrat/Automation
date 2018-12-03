package demo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Result implements ITestListener {
	
	public static int passCount = 0, failCount = 0;
	
	public static void writeXlData(int pass, int fail) {
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\ssamr\\git\\Automation\\result\\summary.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		wb.getSheet("Sheet1").getRow(1).getCell(0).setCellValue(pass);
		wb.getSheet("Sheet1").getRow(1).getCell(1).setCellValue(fail);
		wb.write(new FileOutputStream("C:\\Users\\ssamr\\git\\Automation\\result\\summary.xlsx"));
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {}

	@Override
	public void onTestSuccess(ITestResult result) {
		passCount++;
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 failCount++;
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onStart(ITestContext context) {}

	@Override
	public void onFinish(ITestContext context) {
		
		Result.writeXlData(passCount, failCount);
		
	}

}
