package com.barclays.theaterSeating.model;

public class Section {
	private int rowNumber;
	private int sectionNumber;
	private int capacity;
	private int bookedSeats;
	private boolean openForBooking = true;

	public int getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public boolean isOpenForBooking() {
		return openForBooking;
	}

	public void setOpenForBooking(boolean openForBooking) {
		this.openForBooking = openForBooking;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
}
