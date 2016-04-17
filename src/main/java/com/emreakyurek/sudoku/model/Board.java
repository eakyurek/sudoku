package com.emreakyurek.sudoku.model;

import java.util.ArrayList;
import java.util.HashSet;

public class Board {
	private ArrayList<HashSet<Integer>> rows;
	private ArrayList<HashSet<Integer>> columns;
	private ArrayList<HashSet<Integer>> squares;
	private int[][] board;
	private boolean completed;
	private int movesMade;
	
	public Board() {
		rows = new ArrayList<HashSet<Integer>>(9);
		columns = new ArrayList<HashSet<Integer>>(9);
		squares = new ArrayList<HashSet<Integer>>(9);
		board = new int[9][9];
		completed = false;
		movesMade = 0;
		for(int i = 0; i < 9; i++) {
			HashSet<Integer> row = new HashSet<>(9);
			HashSet<Integer> column = new HashSet<>(9);
			HashSet<Integer> square = new HashSet<>(9);
			rows.add(row);
			columns.add(column);
			squares.add(square);
		}
	}

	public Board(String board) {
		this();
		for(int i = 0; i < board.length(); i++) {
			makeMove(i%9, i/9, Character.getNumericValue(board.charAt(i)));
		}
	}
	
	public MoveStatus makeMove(int x, int y, int value) {
		MoveStatus status = checkMove(x, y, value);
		
		switch(status) {
			case COMPLETED:
				completed = true;
			case VALID:
				rows.get(y).add(value);
				columns.get(x).add(value);
				squares.get(findSquare(x, y)).add(value);
				board[x][y] = value;
				movesMade++;
				break;
			case INVALID:
				break;
		}
		
		return status;
	}
	
	public MoveStatus checkMove(int x, int y, int value) {
		if(x < 0 || x > 8 || y < 0 || y > 8 || value < 1 || value > 9 || board[x][y] != 0) {
			return MoveStatus.INVALID;
		}
		
		if(rows.get(y).contains(value)) {
			return MoveStatus.INVALID;
		} else if(columns.get(x).contains(value)) {
			return MoveStatus.INVALID;
		} else if(squares.get(findSquare(x, y)).contains(value)) {
			return MoveStatus.INVALID;
		} else {
			if(movesMade == 80) {
				return MoveStatus.COMPLETED;
			} else {
				return MoveStatus.VALID;
			}
		}
	}
	
	private int findSquare(int x, int y) {
		int row = y / 3;
		int column = x / 3;
		return row * 3 + column;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public int getMovesMade() {
		return movesMade;
	}

	public void setMovesMade(int movesMade) {
		this.movesMade = movesMade;
	}
}
