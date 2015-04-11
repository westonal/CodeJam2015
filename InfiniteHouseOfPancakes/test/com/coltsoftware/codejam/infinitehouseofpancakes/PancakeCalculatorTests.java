package com.coltsoftware.codejam.infinitehouseofpancakes;

import static org.junit.Assert.*;
import org.junit.Test;

public final class PancakeCalculatorTests {

	@Test
	public void case1() {
		assertEquals(3, new PancakeCalculator("3").getMinimumMinutes());
	}

	@Test
	public void case2() {
		assertEquals(2, new PancakeCalculator("1 2 1 2").getMinimumMinutes());
	}

	@Test
	public void case3() {
		assertEquals(3, new PancakeCalculator("4").getMinimumMinutes());
	}

	@Test
	public void my_case_1() {
		assertEquals(4, new PancakeCalculator("4 4").getMinimumMinutes());
	}

	@Test
	public void my_case_2() {
		assertEquals(3, new PancakeCalculator("2 4").getMinimumMinutes());
	}

	@Test
	public void my_case_3() {
		assertEquals(4, new PancakeCalculator("3 4").getMinimumMinutes());
	}

	@Test
	public void my_case_4() {
		assertEquals(6, new PancakeCalculator("8 8 4").getMinimumMinutes());
	}

	@Test
	public void my_case_5() {
		assertEquals(7, new PancakeCalculator("8 8 5").getMinimumMinutes());
	}
}
