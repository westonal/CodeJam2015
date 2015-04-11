package com.coltsoftware.codejam.infinitehouseofpancakes;

import java.util.ArrayList;
import java.util.Collections;

public final class PancakeCalculator {

	private ArrayList<Integer> pancakes = new ArrayList<>();

	public PancakeCalculator(String pancakesOnPlates) {
		String[] ps = pancakesOnPlates.split(" ");
		for (int i = 0; i < ps.length; i++)
			pancakes.add(Integer.parseInt(ps[i]));
		Collections.sort(pancakes);
	}

	public int getMinimumMinutes() {
		int best = getMaximumPancakes();
		int totalSplittingMinutes = 0;
		do {
			int splittingMinutes = splitStack(getMaximumPancakes());
			totalSplittingMinutes += splittingMinutes;
			int newTime = getMaximumPancakes() + totalSplittingMinutes;
			if (newTime > best)
				return best;
			best = newTime;
		} while (true);
	}

	private int splitStack(int max) {
		int minsToSplit = 0;
		for (int i = pancakes.size() - 1; i >= 0; i--) {
			int p = pancakes.get(i);
			if (p < max)
				break;
			pancakes.set(i, p / 2);
			pancakes.add(p - p / 2);
			minsToSplit++;
		}
		Collections.sort(pancakes);
		return minsToSplit;
	}

	private int getMaximumPancakes() {
		return pancakes.get(pancakes.size() - 1);
	}
}
