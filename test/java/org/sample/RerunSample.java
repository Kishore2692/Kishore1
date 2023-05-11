package org.sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RerunSample {
	
	@Test
	private void tc01() {
	System.out.println("10");

	}
	

	@Test(retryAnalyzer = IRetryAnalyzerSample.class)
	private void tc02() {
		Assert.assertTrue(false);
	System.out.println("20");

	}


	@Test(retryAnalyzer = IRetryAnalyzerSample.class)
	private void tc03() {
		Assert.assertTrue(false);
	System.out.println("30");

	}


}
