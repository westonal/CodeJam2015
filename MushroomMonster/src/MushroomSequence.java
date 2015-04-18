public class MushroomSequence {

	private int[] sequence;

	public MushroomSequence(int[] sequence) {
		this.sequence = sequence;
	}

	public int minEaten() {
		int total = 0;
		for (int i = 1; i < sequence.length; i++) {
			int previous = sequence[i - 1];
			int current = sequence[i];
			int eaten = previous - current;
			if (eaten > 0)
				total += eaten;
		}
		return total;
	}

	public int maxEaten() {
		int maxEaten = 0;
		for (int i = 1; i < sequence.length; i++) {
			int previous = sequence[i - 1];
			int current = sequence[i];
			int eaten = previous - current;
			if (eaten > maxEaten)
				maxEaten = eaten;
		}
		int actuallyEaten = 0;
		for (int i = 0; i < sequence.length - 1; i++) {
			actuallyEaten += Math.min(maxEaten, sequence[i]);
		}
		return actuallyEaten;
	}

}
