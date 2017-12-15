package com.barclays.theaterSeating.service;

import java.util.List;

import com.barclays.theaterSeating.model.Row;
import com.barclays.theaterSeating.model.Section;
import com.barclays.theaterSeating.model.TheaterLayout;
import com.barclays.theaterSeating.model.TicketRequest;

public class BookingServiceImpl implements BookingService {

	public void processRequest(TheaterLayout layout, List<TicketRequest> ticketRequests) {
		
		for(TicketRequest ticketRequest: ticketRequests) {
			Section availableSection = availableSection(layout);
			int openSeats = availableSection.getCapacity();
			
			//if requested seats less than section capacity, 
				//find sum of requests == capacity
				// if found assign row & section value and openForBooking to false
				// if not then assign requested seats to the section and openForBooking to false
			
			if(ticketRequest.getNoOfTickets() == openSeats) {
				availableSection.setOpenForBooking(false);
				ticketRequest.setConfirmation(ticketRequest.getRequestedBy() + " Row " + availableSection.getRowNumber() + " Section " + availableSection.getSectionNumber());
			} else if(ticketRequest.getNoOfTickets() < availableSection.getCapacity()) {
				
			}
		}
		
		/*String decision = "";
		if(request.getNoOfTickets() > layout.getTotalCapacity()) {
			decision = request.getRequestedBy() + " Sorry, we can't handle your party";
		}*/
	}

	public Section availableSection(TheaterLayout layout) {
		for(Row row: layout.getRows()){
			for(Section section: row.getSections()) {
				if(section.isOpenForBooking()) {
					return section;
				}
			}
		}
		return null;
	}

}
