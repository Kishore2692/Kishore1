package org.sample;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//KnownFailedTestCases
public class IRetryAnalyzerSample implements IRetryAnalyzer{

	int min = 0, max=2;
	public boolean retry(ITestResult result) {
		if (min<max) {
			min++;
			return true;
			
		}
		
		return false;
	}
	
	

}
