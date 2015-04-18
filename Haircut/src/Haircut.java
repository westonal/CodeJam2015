public class Haircut {

	public static int calcBarber(int placeInLine, int[] barberTimes) {
		int[] seq = new int[barberTimes.length];

		int repeatMins = product(barberTimes);
		int served = servedInMinutes(barberTimes, repeatMins);

		int vplaceInLine = (placeInLine - 1) % served + 1;
		for (int i = 1; i < vplaceInLine; i++) {
			int bidx = findNextBarberIndex(seq);
			seq[bidx] += barberTimes[bidx];
		}

		return findNextBarberIndex(seq) + 1;
	}

	private static int servedInMinutes(int[] barberTimes, int mins) {
		int sum = 0;
		for (int i = 0; i < barberTimes.length; i++)
			sum += mins / barberTimes[i];
		return sum;
	}

	private static int product(int[] ints) {
		int sum = 1;
		for (int i = 0; i < ints.length; i++)
			sum *= ints[i];
		return sum;
	}

	private static int findNextBarberIndex(int[] seq) {
		int min = Integer.MAX_VALUE;
		int midx = 0;
		for (int i = 0; i < seq.length; i++)
			if (seq[i] < min) {
				min = seq[i];
				midx = i;
			}
		return midx;
	}
}
