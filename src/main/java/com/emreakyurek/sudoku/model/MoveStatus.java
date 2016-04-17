package com.emreakyurek.sudoku.model;

public enum MoveStatus {
	INVALID(0), VALID(1), COMPLETED(2);

	int status;

	private MoveStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
}
