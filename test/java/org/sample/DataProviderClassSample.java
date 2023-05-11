package org.sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClassSample {
	@Test
	@DataProvider(name = "Test03")
	public Object[][] getData() {
return new Object[][] {
	{"test03","test03@123"},{"test04","test04@123"}
};
	}

}
