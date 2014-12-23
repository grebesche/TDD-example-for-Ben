package com.guillaume.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingTests {

	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void testOneRoll() throws Exception {
		game.roll(0);
	}

	@Test
	public void testWorstGame() throws Exception {
		multipleRolls(20, 0);
		assertEquals(0, game.score());
	}

	@Test
	public void testBadGame() throws Exception {
		game.roll(4);
		game.roll(2);
		multipleRolls(18, 0);
		assertEquals(6, game.score());
	}

	@Test
	public void testSpare() throws Exception {
		rollSpare();
		game.roll(2);
		multipleRolls(17, 0);
		assertEquals(14, game.score());
	}

	@Test
	public void testStrike() throws Exception {
		rollStrike();
		game.roll(2);
		game.roll(5);
		multipleRolls(16, 0);
		assertEquals(24, game.score());
	}

	@Test
	public void testPerfectGame() throws Exception {
		multipleRolls(12, 10);
		assertEquals(300, game.score());
	}

	@Test
	public void testSpareFollowedByAStrike() throws Exception {
		rollSpare();
		rollStrike();
		multipleRolls(16, 0);
		assertEquals(30, game.score());
	}

	@Test
	public void testStrikeFollowedByASpare() throws Exception {
		rollStrike();
		rollSpare();
		multipleRolls(16, 0);
		assertEquals(30, game.score());
	}

	private void rollStrike() {
		game.roll(10);
	}

	private void rollSpare() {
		game.roll(6);
		game.roll(4);
	}

	private void multipleRolls(int iterations, int rollScore) {
		for (int i = 0; i < iterations; i++) {
			game.roll(rollScore);
		}
	}
}
