package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;
	
	  @Before
	  public void setUp() throws Exception {
	    ntc = new NewTelephoneCompany();
	  }
	  
	@Test(expected=UnsupportedOperationException.class)
	public void testInvalidStartTime() {
	    ntc.setStartTime(-5);
	    ntc.setDuration(50);
	    ntc.computeCharge();
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testInvalidDuration() {
	    ntc.setStartTime(1000);
	    ntc.setDuration(-5);
	    ntc.computeCharge();
	}
	
	@Test
	public void testDiscountedTimeAndDuration() {
	    ntc.setStartTime(2359);
	    ntc.setDuration(65);
	    double expResult = 1149.20 ;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration(),expResult==ntc.computeCharge());
	}
	
	@Test
	public void testDiscountedTime() {
	    ntc.setStartTime(400);
	    ntc.setDuration(59);
	    double expResult = 1227.20;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration(),expResult==ntc.computeCharge());
	}
	
	@Test
	public void testDiscountedDuration() {
	    ntc.setStartTime(800);
	    ntc.setDuration(65);
	    double expResult = 2298.40;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration(),expResult==ntc.computeCharge());
	}
	
	@Test
	public void testNoDiscounts() {
	    ntc.setStartTime(1000);
	    ntc.setDuration(40);
	    double expResult = 1664.00;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration(),expResult==ntc.computeCharge());
	}
	
	@Test
	public void testGetStartTime() {
	    int expResult = 0;
	    int result = ntc.getStartTime();
	    assertEquals("Start time is " + expResult,expResult, result);
	}

	@Test
	public void testSetStartTime() {
	    int expResult = 1040;
	    ntc.setStartTime(expResult);
	    int result = ntc.getStartTime();
	    assertEquals("Start time is now " + expResult,expResult, result);
	}

	  @Test
	  public void testGetDuration() {
	    int expResult = 0;
	    int result = ntc.getDuration();
	    assertEquals("Length is" + expResult,expResult, result);
	  }
	  
	  @Test
	  public void testSetDuration() {
	    int expResult = 40;
	    ntc.setDuration(expResult);
	    int result = ntc.getDuration();
	    assertEquals("Length is now " + expResult,expResult, result);
	  }


}
