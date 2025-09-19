package com.fashion.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

import org.testng.TestNG;
import org.testng.annotations.Test;

import freemarker.log.Logger;

public class Runner extends BaseClass {
	
	public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add("testcicd.xml"); 
        testng.setTestSuites(suites);
        testng.run();
    }

}
