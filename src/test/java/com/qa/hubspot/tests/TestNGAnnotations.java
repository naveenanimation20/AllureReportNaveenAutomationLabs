package com.qa.hubspot.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	/**
	 * beforeSuite
beforeTest
beforeClass

beforeMethod
test1 method
AfterMethod

beforeMethod
test2 method
AfterMethod

AfterClass
AfterTest
AfterSuite
	 */
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("beforeSuite");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("beforeTest");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("beforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("beforeMethod");
	}
	
	
	@Test
	public void test1(){
		System.out.println("test1 method");
	}
	
	@Test
	public void test2(){
		System.out.println("test2 method");
	}
	

	@AfterSuite
	public void AfterSuite(){
		System.out.println("AfterSuite");
	}
	
	@AfterTest
	public void AfterTest(){
		System.out.println("AfterTest");
	}
	
	@AfterClass
	public void AfterClass(){
		System.out.println("AfterClass");
	}
	
	@AfterMethod
	public void AfterMethod(){
		System.out.println("AfterMethod");
	}
	
	
	
	
}
