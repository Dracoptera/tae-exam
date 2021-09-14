package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.xml.transform.Result;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Initiating Test - " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test passed succesfully - " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test failed - " + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test was skipped - " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Test suite starting");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test suite finished");
    }
}
