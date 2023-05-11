package org.sample;

import org.testng.annotations.Test;

public class GroupsSample {
	@Test(groups ="smoke")
	private void Tc01() {
		System.out.println("10");

	}
	@Test(groups ="smoke")
	private void tc02() {
		System.out.println("20");

	}
	@Test(groups ="sanity")
	private void tc03() {
		System.out.println("30");

	}
	@Test(groups ="smoke")
	private void tc04() {
		System.out.println("40");
	}
	@Test(groups ="sanity")
	private void tc05() {
		System.out.println("50");

	}

}
