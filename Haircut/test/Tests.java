import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void t1() {
		assertEquals(1, Haircut.calcBarber(4, new int[] { 10, 5 }));
	}
	
	@Test
	public void t2() {
		assertEquals(3, Haircut.calcBarber(12, new int[] { 7,7,7 }));
	}
	
	@Test
	public void t3() {
		assertEquals(1, Haircut.calcBarber(8, new int[] { 4,2,1 }));
	}

}
