package com.coltsoftware.codejam.infinitehouseofpancakes;

import java.util.ArrayList;
import java.util.Collections;

public final class PancakeCalculator {

	private final int[] pDinersCount;

	public PancakeCalculator(String pancakesOnPlates) {
		String[] ps = pancakesOnPlates.split(" ");
		ArrayList<Integer> pancakes = new ArrayList<Integer>();
		for (int i = 0; i < ps.length; i++)
			pancakes.add(Integer.parseInt(ps[i]));
		Collections.sort(pancakes);
		pDinersCount = new int[getMaximumPancakes(pancakes) + 1];
		for (int p = 1; p < pDinersCount.length; p++)
			pDinersCount[p] = getFrequency(pancakes, p);
	}

	private int getFrequency(ArrayList<Integer> pancakes, int p) {
		int freq = 0;
		for (Integer stackHeight : pancakes)
			if (stackHeight == p)
				freq++;
		return freq;
	}

	private static int getMaximumPancakes(ArrayList<Integer> pancakes) {
		return pancakes.get(pancakes.size() - 1);
	}

	public int getMinimumMinutes() {
		int indexOfHighestStack = getHighestPancakeStack(pDinersCount);

		return getMinimumMinutes(pDinersCount);
	}

	public static int getMinimumMinutes(int[] pDinersCount) {
		int indexOfHighestStack = getHighestPancakeStack(pDinersCount);
		if (indexOfHighestStack <= 1)
			return indexOfHighestStack;

		int timeIfEatFirst = getTimeIfEatNext(pDinersCount);

		int timeIfSplitFirst = getTimeIfSplitNext(pDinersCount,
				indexOfHighestStack);
		return Math.min(timeIfEatFirst, timeIfSplitFirst);
	}

	private static int getTimeIfSplitNext(int[] pDinersCount,
			int indexOfHighestStack) {
		int[] clonedForReducedStack = new int[indexOfHighestStack];
		System.arraycopy(pDinersCount, 0, clonedForReducedStack, 0,
				clonedForReducedStack.length);
		int numberOfDinersWithMaxStack = pDinersCount[indexOfHighestStack];

		int[] time = new int[indexOfHighestStack / 2];
		for (int index1 = 1; index1 <= indexOfHighestStack / 2; index1++) {
			int index2 = indexOfHighestStack - index1;
			int[] clone2 = clonedForReducedStack.clone();
			clone2[index1] += numberOfDinersWithMaxStack;
			clone2[index2] += numberOfDinersWithMaxStack;
			time[index1 - 1] = getMinimumMinutes(clone2);
		}

		int timeIfSplitFirst = getMinOfArray(time) + numberOfDinersWithMaxStack;
		return timeIfSplitFirst;
	}

	private static int getMinOfArray(int[] time) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < time.length; i++)
			if (time[i] < min)
				min = time[i];
		return min;
	}

	private static int getTimeIfEatNext(int[] pDinersCount) {
		int[] clonedForEat = eat(pDinersCount);
		int timeIfEatFirst = getMinimumMinutes(clonedForEat) + 1;
		return timeIfEatFirst;
	}

	private static int[] eat(int[] pDinersCount) {
		int[] clonedForEat = new int[pDinersCount.length - 1];
		System.arraycopy(pDinersCount, 1, clonedForEat, 0,
				pDinersCount.length - 1);
		return clonedForEat;
	}

	private static int getHighestPancakeStack(int[] pDinersCount) {
		for (int p = pDinersCount.length - 1; p >= 0; p--)
			if (pDinersCount[p] > 0)
				return p;
		return 0;
	}
}
