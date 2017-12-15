package com.barclays.theaterSeating.model;

import java.util.ArrayList;
import java.util.List;

public class TheaterLayout {
	
	private int totalCapacity;
    private int bookedSeats;
    private List<Row> rows = new ArrayList<Row>();
    
    public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public void addRows(Row row) {
		rows.add(row);
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
    
}
