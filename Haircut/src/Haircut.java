public class Haircut {

	public static int calcBarber(int placeInLine, int[] barberTimes) {
		int[] seq = new int[barberTimes.length];

		int rep = sumBarberTimes(barberTimes);

		int vplaceInLine = ((placeInLine-1)%rep)+1;
		for (int i = 1; i < vplaceInLine; i++) {
			int bidx = findNextBarberIndex(seq);
			seq[bidx] += barberTimes[bidx];
		}

		return findNextBarberIndex(seq) + 1;
	}

	private static int sumBarberTimes(int[] barberTimes) {
		int sum = 1;
		for (int i = 0; i < barberTimes.length; i++)
			sum *= barberTimes[i];
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
