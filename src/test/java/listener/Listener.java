package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.xml.transform.Result;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Initiating Test");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test passed succesfully");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test was skipped");
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
