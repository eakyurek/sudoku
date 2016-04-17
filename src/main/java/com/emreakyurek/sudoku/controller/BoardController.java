package com.emreakyurek.sudoku.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emreakyurek.sudoku.exception.ResourceNotFoundException;
import com.emreakyurek.sudoku.model.Board;
import com.emreakyurek.sudoku.model.MoveStatus;
import com.emreakyurek.sudoku.storage.InMemoryStorage;

@RestController
@RequestMapping("/board")
public class BoardController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public Board getNewBoard() {
		Board board = new Board("700040530005008010008509040539060001000010005800720900907400000000057000600000050");
		InMemoryStorage.store(board);
        return board;
    }
	
	@RequestMapping(value = "/{boardId}/", method = RequestMethod.GET)
    public Board getBoard(@PathVariable int boardId) {
		Board board = InMemoryStorage.get(boardId);
		if(board != null) {
			return board;
		} else {
			throw new ResourceNotFoundException(); 
		}
    }
	
	@RequestMapping(value = "/{boardId}/makeMove/", method = RequestMethod.POST)
    public MoveStatus makeMove(	@PathVariable int boardId,
    						@RequestParam int x,
    						@RequestParam int y,
    						@RequestParam int value) {
		Board board = InMemoryStorage.get(boardId);
		System.out.println(x + " " + y + " " + value);
		if(board != null) {
			return board.makeMove(x, y, value);
		} else {
			throw new ResourceNotFoundException(); 
		}
    }
	
	@RequestMapping(value = "/{boardId}/checkMove/", method = RequestMethod.POST)
    public MoveStatus checkMove(@PathVariable int boardId,
    						@RequestParam int x,
    						@RequestParam int y,
    						@RequestParam int value) {
		Board board = InMemoryStorage.get(boardId);
		if(board != null) {
			return board.checkMove(x, y, value);
		} else {
			throw new ResourceNotFoundException(); 
		}
    }
}
