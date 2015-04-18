public final class Point {

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public final int x;
	public final int y;
	public double angle;
	private Point poppedBy;

	public void setPoppedBy(Point p) {
		this.poppedBy = p;
	}

	public int getDepth() {
		if (poppedBy == null)
			return 0;
		return poppedBy.getDepth() + 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point))
			return false;
		return equals((Point) obj);
	}

	public boolean equals(Point other) {
		if (other == null)
			return false;
		return x == other.x && y == other.y;
	}

	@Override
	public int hashCode() {
		return x ^ y;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}
}
