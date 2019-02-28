package com.qa.hubspot.tests;

import org.testng.annotations.Test;

public class PriorityConcept {

	@Test(priority = -1)
	public void aloginTest1() {
		System.out.println("login test");
	}

	@Test(priority = 1)
	public void bloginTest2() {
		System.out.println("login test");
	}

	@Test(priority = 2)
	public void cloginTest3() {
		System.out.println("login test");
	}

	@Test(priority = -3)
	public void dloginTest4() {
		System.out.println("login test");
	}

}
