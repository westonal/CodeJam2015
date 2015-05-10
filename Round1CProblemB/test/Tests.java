import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class Tests {

	@Test
	public void a() {
		assertEquals(1, C.shortestOverlap("AAA"));
	}

	@Test
	public void b() {
		assertEquals(2, C.shortestOverlap("ABAB"));
	}

	@Test
	public void last_letter_repeat() {
		assertEquals(5, C.shortestOverlap("TARGET"));
	}

	@Test
	public void no_repeat() {
		assertEquals(6, C.shortestOverlap("TARGEZ"));
	}

	@Test
	public void m_1() {
		assertEquals(2, C.bestCaseForMonkey(-1, "AAA", 4));
	}

	@Test
	public void m_2() {
		assertEquals(3, C.bestCaseForMonkey(-1, "AA", 4));
	}

	@Test
	public void c() {
		assertTrue(containsAllChars("A", "A"));
	}

	@Test
	public void d_keyboard_extra() {
		assertTrue(containsAllChars("A", "AB"));
	}

	@Test
	public void d_target_extra() {
		assertFalse(containsAllChars("AB", "A"));
	}

	@Test
	public void test_1() {
		assertEquals(0, calc("BANANAS", "MONKEY", 6), 0.000001);
	}

	@Test
	public void test_2() {
		assertEquals(0, calc("AA", "AAA", 4), 0.000001);
	}

	@Test
	public void test_2_1() {
		assertEquals(1, new C("AAA", 4).getChanceOfWord("AA"), 0.000001);
	}

	@Test
	public void test_3() {
		assertEquals(1, calc("AB", "A", 2), 0.000001);
	}

	@Test
	public void test_4() {
		assertEquals(0.888888888, calc("GOOGLE", "GO", 2), 0.000001);
	}

	@Test
	public void test_5() {
		assertEquals(9, calc("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ROSENCRANTZ", 100),
				0.000001);
	}

	public boolean containsAllChars(String target, String keyboard) {
		for (int i = 0; i < target.length(); i++)
			if (keyboard.indexOf(target.charAt(i)) == -1)
				return false;
		return true;
	}

	public double calc(String keyboard, String target, int s) {
		if (!containsAllChars(target, keyboard))
			return 0;
		C c = new C(keyboard, s);

		return c.chance(target);
	}

}
