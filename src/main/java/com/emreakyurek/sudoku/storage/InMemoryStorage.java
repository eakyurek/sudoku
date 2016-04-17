package com.emreakyurek.sudoku.storage;

import java.util.HashMap;

import com.emreakyurek.sudoku.model.Board;

public class InMemoryStorage {
	private static HashMap<Integer, Board> storage = new HashMap<>();
	
	public static void store(Board board) {
		int id = (int)(Math.random() * 1000000);
		board.setId(id);
		storage.put(id, board);
	}
	
	public static Board get(int id) {
		return storage.get(id);
	}
}
