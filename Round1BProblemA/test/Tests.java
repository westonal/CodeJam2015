import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void testa() {
		assertEquals(1, Counter.count(1));
	}

	@Test
	public void test_19() {
		assertEquals(19, Counter.count(19));
	}

	@Test
	public void test_23() {
		assertEquals(15, Counter.count(23));
	}

	@Test
	public void test_35() {
		assertEquals(13 + 1 + 4, Counter.count(35));
	}

	@Test
	public void test_3() {
		assertEquals(19 + 1 + (113 - 91) + 1 + 9, Counter.count(320));
	}

	@Test
	public void flip_digits_1() {
		assertEquals(2, Counter.flipDigits(2));
	}

	@Test
	public void flip_digits_2() {
		assertEquals(32, Counter.flipDigits(23));
	}

	@Test
	public void flip_digits_3() {
		assertEquals(432, Counter.flipDigits(234));
	}

	@Test
	public void flip_digits_3_zero() {
		assertEquals(32, Counter.flipDigits(230));
	}

}
