package com.emreakyurek.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.emreakyurek.sudoku.model.Board;
import com.emreakyurek.sudoku.model.MoveStatus;


public class BoardTest {
	Board board;
	
	@Before
	public void setUp() {
		String boardStr = "700040530005008010008509040539060001000010005800720900907400000000057000600000050";
		board = new Board(boardStr);
	}
	
	@Test
	public void newBoardUsingString() {
		Assert.assertEquals(29, board.getMovesMade());
		Assert.assertEquals(false, board.isCompleted());
	}
	
	@Test
	public void makeValidMove() {
		MoveStatus result = board.makeMove(0, 1, 2);
		Assert.assertEquals(MoveStatus.VALID, result);
	}
	
	@Test
	public void makeComletingMove() {
		String boardStr = "391286574487359126652714839875431692213967485964528713149673258538142967726895340";
		board = new Board(boardStr);
		MoveStatus result = board.makeMove(8, 8, 1);
		Assert.assertEquals(MoveStatus.COMPLETED, result);
	}
	
	@Test
	public void makeInvalidMove_BigValue() {
		MoveStatus result = board.makeMove(0, 1, 10);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
	
	@Test
	public void makeInvalidMove_SmallValue() {
		MoveStatus result = board.makeMove(0, 1, 0);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
	
	@Test
	public void makeInvalidMove_BigXValue() {
		MoveStatus result = board.makeMove(9, 1, 2);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
	
	@Test
	public void makeInvalidMove_SmallXValue() {
		MoveStatus result = board.makeMove(-1, 1, 2);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
	
	@Test
	public void makeInvalidMove_BigYValue() {
		MoveStatus result = board.makeMove(0, 9, 2);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
	
	@Test
	public void makeInvalidMove_SmallYValue() {
		MoveStatus result = board.makeMove(-1, 1, 2);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
	
	@Test
	public void makeInvalidMove_AllreadyFilled() {
		MoveStatus result = board.makeMove(2, 3, 2);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
	
	@Test
	public void makeInvalidMove_RowContainsValue() {
		MoveStatus result = board.makeMove(1, 0, 3);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
	
	@Test
	public void makeInvalidMove_ColumnContainsValue() {
		MoveStatus result = board.makeMove(2, 0, 7);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
	
	@Test
	public void makeInvalidMove_SquareContainsValue() {
		MoveStatus result = board.makeMove(2, 0, 8);
		Assert.assertEquals(MoveStatus.INVALID, result);
	}
}
