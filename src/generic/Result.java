package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Result implements IAutoConst,ITestListener {
	public static int passCount = 0,failCount=0;
	public void onTestSucess(ITestResult result) {
		passCount++;
	}
	public void onTestFailure(ITestResult result) {
		failCount++;
	}
	@Override
	public void onFinish(ITestContext arg0) {}
	
	@Override
	public void onStart(ITestContext arg0) {}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {}

	@Override
	public void onTestSkipped(ITestResult arg0) {}
	
	@Override
	public void onTestStart(ITestResult arg0) {}

	@Override
	public void onTestSuccess(ITestResult arg0) {}

}
