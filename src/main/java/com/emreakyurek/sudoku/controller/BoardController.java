package com.emreakyurek.sudoku.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String getNewBoard() {
        return "New Board";
    }
	
	@RequestMapping(value = "/{boardId}/", method = RequestMethod.GET)
    public String getBoard(@PathVariable int boardId) {
        return "Board" + boardId;
    }
	
	@RequestMapping(value = "/{boardId}/makeMove/", method = RequestMethod.POST)
    public String makeMove(	@PathVariable int boardId,
    						@RequestParam byte x,
    						@RequestParam byte y,
    						@RequestParam byte value) {
        return "Board" + boardId + " makeMove [x=" + x + ", y=" + y + ", value=" + value + "]";
    }
	
	@RequestMapping(value = "/{boardId}/checkMove/", method = RequestMethod.POST)
    public String checkMove(@PathVariable int boardId,
    						@RequestParam byte x,
    						@RequestParam byte y,
    						@RequestParam byte value) {
        return "Board" + boardId + " checkMove [x=" + x + ", y=" + y + ", value=" + value + "]";
    }
}
