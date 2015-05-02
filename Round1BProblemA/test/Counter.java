public class Counter {

	public static class C {
		int count;
	}

	public static int count(int n) {
		C count = new C();
		int i = n;
		while (i > 1) {
			i = flipMaybe(i, count);
		}
		return count.count + 1;
	}

	private static int flipMaybe(int i, C count) {
		int d1 = i % 10;
		for (int d = 1; d <= d1; d++) {
			int icand = i - d1 + d;
			int flipped = flipDigits(icand);
			if (flipped == icand)
				continue;
			if (flipped - i < 0) {
				count.count += i - icand + 1;
				return flipped;
			}
		}
		count.count++;
		return i - 1;
	}

	public static int flipDigits(int i) {
		int result = 0;
		while (i > 0) {
			int lastDigit = i % 10;
			result = result * 10 + lastDigit;
			i /= 10;
		}
		return result;
	}

}
