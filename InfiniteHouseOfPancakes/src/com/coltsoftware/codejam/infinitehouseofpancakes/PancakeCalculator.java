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
		return getMinimumMinutes(pancakes);
	}

	private static int getMinimumMinutes(ArrayList<Integer> pancakes) {
		int best = getMaximumPancakes(pancakes);
		if (best <= 1)
			return best;

		ArrayList<Integer> clonedForEating = new ArrayList<Integer>(pancakes);
		reduceStacks(clonedForEating);
		int timeIfWeEatFirst = getMinimumMinutes(clonedForEating) + 1;

		if (best % 2 == 0) {

			ArrayList<Integer> clonedForSplitting = new ArrayList<Integer>(
					pancakes);
			int splittingMinutes = splitStack(
					getMaximumPancakes(clonedForSplitting), clonedForSplitting);

			int timeIfWeSplitFirst = getMinimumMinutes(clonedForSplitting)
					+ splittingMinutes;

			return Math.min(timeIfWeEatFirst, timeIfWeSplitFirst);
		}
		return timeIfWeEatFirst;
	}

	private static void reduceStacks(ArrayList<Integer> pancakes) {
		for (int i = pancakes.size() - 1; i >= 0; i--) {
			Integer stackHeight = pancakes.get(i);
			if (stackHeight > 0)
				pancakes.set(i, stackHeight - 1);
		}
	}

	private static int splitStack(int max, ArrayList<Integer> pancakes) {
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

	private static int getMaximumPancakes(ArrayList<Integer> pancakes) {
		return pancakes.get(pancakes.size() - 1);
	}
}
