import java.util.ArrayList;
import java.util.Comparator;

public class Hull {

	private Point lowestLeftMost;
	private ArrayList<Point> hull = new ArrayList<Point>();

	public ArrayList<Point> CalcHull(ArrayList<Point> set) {
		set = new ArrayList<Point>(set);
		lowestLeftMost = lowestLeftMost(set);
		hull.add(lowestLeftMost);
		set.remove(0);
		setAngles(set);
		sortByAngles(set);
		calcHull(set);
		return hull;
	}

	private void sortByAngles(ArrayList<Point> set) {
		set.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				double diff = o1.angle - o2.angle;
				return diff > 0 ? 1 : -1;
			}
		});
	}

	private void calcHull(ArrayList<Point> set) {
		for (Point p : set) {
			hull.add(p);
			while (hull.size() > 2 && lastAngleReflex()) {
				Point removed = hull.remove(hull.size() - 2);
				removed.setPoppedBy(p);
			}
		}
	}

	public static boolean reflex(Point a, Point b, Point c) {
		double a1 = Math.atan2(b.y - a.y, b.x - a.x);
		double a2 = Math.atan2(c.y - b.y, c.x - b.x);
		return a2 < a1;
	}

	private boolean lastAngleReflex() {
		return reflex(hull.get(hull.size() - 3), hull.get(hull.size() - 2),
				hull.get(hull.size() - 1));
	}

	private void setAngles(ArrayList<Point> set) {
		for (Point p : set) {
			p.angle = Math
					.atan2(p.y - lowestLeftMost.y, p.x - lowestLeftMost.x);
		}
	}

	private Point lowestLeftMost(ArrayList<Point> set) {
		Point l = set.get(0);
		for (Point p : set) {
			if (p.y < l.y) {
				l = p;
				continue;
			}
			if (p.y == l.y && p.x < l.x) {
				l = p;
				continue;
			}
		}
		return l;
	}

}
