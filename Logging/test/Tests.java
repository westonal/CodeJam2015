import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Tests {

	@Test
	public void t1() {
		ArrayList<Point> set = new ArrayList<Point>();
		set.add(new Point(0, 0));
		set.add(new Point(10, 0));
		set.add(new Point(10, 10));
		set.add(new Point(0, 10));
		set.add(new Point(5, 5));
		Hull hull = new Hull();
		ArrayList<Point> h = hull.CalcHull(set);
		assertEquals(4, h.size());
		assertEquals(new Point(0, 0), h.get(0));
		assertEquals(new Point(10, 0), h.get(1));
		assertEquals(new Point(10, 10), h.get(2));
		assertEquals(new Point(0, 10), h.get(3));

		assertEquals(0, set.get(0).getDepth());
		assertEquals(0, set.get(1).getDepth());
		assertEquals(0, set.get(2).getDepth());
		assertEquals(0, set.get(3).getDepth());
		assertEquals(1, set.get(4).getDepth());
	}
	
	@Test
	public void t2() {
		ArrayList<Point> set = new ArrayList<Point>();
		set.add(new Point(0, 0));
		set.add(new Point(5, 0));
		set.add(new Point(10, 0));
		set.add(new Point(0, 5));
		set.add(new Point(5, 5));
		set.add(new Point(10, 5));
		set.add(new Point(0, 10));
		set.add(new Point(5, 10));
		set.add(new Point(10, 10));
		Hull hull = new Hull();
		ArrayList<Point> h = hull.CalcHull(set);
		assertEquals(8, h.size());
//		assertEquals(new Point(0, 0), h.get(0));
//		assertEquals(new Point(10, 0), h.get(1));
//		assertEquals(new Point(10, 10), h.get(2));
//		assertEquals(new Point(0, 10), h.get(3));

		assertEquals(0, set.get(0).getDepth());
		assertEquals(0, set.get(1).getDepth());
		assertEquals(0, set.get(2).getDepth());
		assertEquals(0, set.get(3).getDepth());
		assertEquals(3, set.get(4).getDepth());
		assertEquals(0, set.get(5).getDepth());
		assertEquals(0, set.get(6).getDepth());
		assertEquals(0, set.get(7).getDepth());
		assertEquals(0, set.get(8).getDepth());		
	}

	@Test
	public void reflexDetect1() {
		assertTrue(Hull.reflex(new Point(0, 0), new Point(1, 1),
				new Point(2, 1)));
	}

	@Test
	public void reflexDetect2() {
		assertFalse(Hull.reflex(new Point(0, 0), new Point(1, 1), new Point(1,
				2)));
	}

}
