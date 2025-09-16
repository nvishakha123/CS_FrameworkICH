package com.fashion.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Runner {
	public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add("testcicd.xml"); 
        testng.setTestSuites(suites);
        testng.run();
    }
}
