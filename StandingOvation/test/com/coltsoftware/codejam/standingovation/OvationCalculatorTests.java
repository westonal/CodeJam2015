package com.coltsoftware.codejam.standingovation;

import org.junit.Assert;
import org.junit.Test;

public final class OvationCalculatorTests {

	@Test
	public void case1(){
		Assert.assertEquals(0, new OvationCalculator("11111").audienceToAdd());
	}
	
	@Test
	public void case2(){
		Assert.assertEquals(1, new OvationCalculator("09").audienceToAdd());
	}
	
	@Test
	public void case3(){
		Assert.assertEquals(2, new OvationCalculator("110011").audienceToAdd());
	}
	
	@Test
	public void case4(){
		Assert.assertEquals(0, new OvationCalculator("1").audienceToAdd());
	}
	
}
