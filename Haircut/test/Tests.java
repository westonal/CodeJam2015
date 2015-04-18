import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void t1() {
		assertEquals(1, Haircut.calcBarber(4, new int[] { 10, 5 }));
	}

	@Test
	public void t2() {
		assertEquals(3, Haircut.calcBarber(12, new int[] { 7, 7, 7 }));
	}

	@Test
	public void t3() {
		assertEquals(1, Haircut.calcBarber(8, new int[] { 4, 2, 1 }));
	}

	@Test
	public void t4() {
		assertEquals(1, Haircut.calcBarber(9, new int[] { 2 }));
	}

	@Test
	public void t5() {
		assertEquals(1, Haircut.calcBarber(9, new int[] { 2, 2 }));
	}

	@Test
	public void t6() {
		assertEquals(1, Haircut.calcBarber(1 + 8, new int[] { 2, 2 }));
	}

	@Test
	public void t7() {
		assertEquals(1, Haircut.calcBarber(1 + 30, new int[] { 2, 3, 5 }));
	}
	
	@Test
	public void t8() {
		assertEquals(2, Haircut.calcBarber(2, new int[] { 2, 3 }));
	}

}
