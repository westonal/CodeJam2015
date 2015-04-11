package com.coltsoftware.codejam.standingovation;

public final class OvationCalculator {

	private int[] audienceShyPos;

	public OvationCalculator(String audience) {
		audienceShyPos = new int[audience.length()];
		for (int i = 0; i < audience.length(); i++)
			audienceShyPos[i] = audience.charAt(i) - '0';
	}

	public int audienceToAdd() {
		int newAudience = 0;
		int stoodUp = 0;
		for (int audenceNeededStoodUp = 0; audenceNeededStoodUp < audienceShyPos.length; audenceNeededStoodUp++) {
			int audienceMembersInThisPosition = audienceShyPos[audenceNeededStoodUp];
			if (stoodUp < audenceNeededStoodUp) {
				int newMembers = audenceNeededStoodUp - stoodUp;
				stoodUp += newMembers;
				newAudience += newMembers;
			}
			stoodUp += audienceMembersInThisPosition;
		}
		return newAudience;
	}
}
