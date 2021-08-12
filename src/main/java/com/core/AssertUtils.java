package com.core;

import static org.junit.Assert.*;







public class AssertUtils {
	
	
	private static AssertUtils instance = null ;
	
	public static AssertUtils getInstance(){
		if(instance==null){
			instance = new AssertUtils();
		}
		return instance;
	}
	
	public  void assertEquals(String expected , String actual, String message){
		try {
			if((expected == null && actual == null) || (expected == null && actual.equals("null")) || (actual == null && expected.equals("null")) || (expected.equals("null") && actual.equals("null")))
			{
				assertTrue(true);
			}
            else if (expected.equalsIgnoreCase(actual)) {
				assertTrue(true);
				
				
			}
			else{
				fail(message + " | expected : " + expected + " but actual : " + actual);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

	
	public void assertEqualsObject(Object expected , Object actual, String message){
		try {
			if((expected == null && actual == null) || (expected == null && actual.equals("null")) || (actual == null && expected.equals("null")))
			{
				assertTrue(true);
			}
			 else if (expected.equals(actual)) {
					
				 assertTrue(true);
					
				}
				else{
					fail(message + " | expected : " + expected + " but actual : " + actual);
				}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
	}

	public void AsserttTrue(boolean result, String message){
		try {
			assertTrue(message, result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
	
	public void AssertNotNull(Object object, String message){
		try {
			assertNotNull(message, object);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

	public void Fail(String message){
		try {
			fail(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
}
	
	public void assertNull(Object object, String message){
		try {
			
			if((object == null) || (object.equals("null")) || (object.equals("null")))
			{
				assertTrue(true);
			}
			
			else{
				fail(message + " | expected : " + object);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

	public void verifyTextContains(String actual , String expected,String message){
		try {
			if((expected == null && actual == null) || (expected == null && actual.equals("null")) || (actual == null && expected.equals("null")) || (expected.equals("null") && actual.equals("null")))
			{
				assertTrue(true);
			}
			else if (actual.contains(expected)) {
				
				assertTrue(true);
				
			}
			else{
				fail(message + " | expected : " + expected + " but actual : " + actual);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void verifyTextContainsCaseInsensitive(String actual , String expected,String message){
		try {
			if((expected == null && actual == null) || (expected == null && actual.equals("null")) || (actual == null && expected.equals("null")) || (expected.equals("null") && actual.equals("null")))
			{
			assertTrue(true);
			}
			else if (actual.toLowerCase().contains(expected.toLowerCase())) {
			
				assertTrue(true);
				
			}
			else{
				fail(message + " | expected : " + expected + " but actual : " + actual);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
