package com.guillaume.tdd;

public class Game {

	private int[] rolls = new int[21];
	private int currentRollIndex = 0;

	public void roll(int rollScore) {
		rolls[currentRollIndex++] = rollScore;
	}

	public int score() {
		int score = 0;
		int frameFirstIndex = 0;
		for (int frame = 0; frame < 10; frame++) {
			if(isStrike(frameFirstIndex)){
				score += rolls[frameFirstIndex] + rolls[frameFirstIndex + 1] + rolls[frameFirstIndex + 2];
				frameFirstIndex++;
			} else if (isSpare(frameFirstIndex)) {
				score += rolls[frameFirstIndex] + rolls[frameFirstIndex + 1] + rolls[frameFirstIndex + 2];
				frameFirstIndex += 2;
			} else {
				score += rolls[frameFirstIndex] + rolls[frameFirstIndex + 1];
				frameFirstIndex += 2;
			}
		}
		return score;
	}

	private boolean isSpare(int frameFirstIndex) {
		return rolls[frameFirstIndex] + rolls[frameFirstIndex + 1] == 10;
	}

	private boolean isStrike(int frameFirstIndex) {
		return rolls[frameFirstIndex] == 10;
	}
}
