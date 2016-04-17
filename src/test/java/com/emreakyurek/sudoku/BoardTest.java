package com.emreakyurek.sudoku;

import org.junit.Assert;
import org.junit.Test;

import com.emreakyurek.sudoku.model.Board;


public class BoardTest {
	@Test
	public void newBoardUsingString() {
		String boardStr = "700040530005008010008509040539060001000010005800720900907400000000057000600000050";
		Board board = new Board(boardStr);
		Assert.assertEquals(29, board.getMovesMade());
		Assert.assertEquals(false, board.isCompleted());
	}
}
