import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tests {

	@Test
	public void a() {
		assertEquals(3, calc(1, 4, 2));
	}

	@Test
	public void b() {
		assertEquals(7, calc(1, 7, 7));
	}

	@Test
	public void c() {
		assertEquals(10, calc(2, 5, 1));
	}

	private int calc(int rows, int cols, int w) {
		return Main.calc(rows, cols, w);
	}

}
