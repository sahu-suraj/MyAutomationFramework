package com.tmb.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import com.tmb.utils.ELKUtils;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		
			ExtentReport.initReports();
		

	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReports();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		//ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
		ELKUtils.sendDetailsToELK(result.getMethod().getDescription(), "pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()).replaceAll(",", "\n"));
			ELKUtils.sendDetailsToELK(result.getMethod().getDescription(), "fail");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
		ELKUtils.sendDetailsToELK(result.getMethod().getDescription(), "skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		/*
		 * 
		 */
	}

	@Override
	public void onStart(ITestContext context) {

		/*
		 * 
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * 
		 */

	}

}
