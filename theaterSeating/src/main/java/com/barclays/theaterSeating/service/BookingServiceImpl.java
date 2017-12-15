package com.barclays.theaterSeating.service;

import java.util.List;

import com.barclays.theaterSeating.model.TheaterLayout;
import com.barclays.theaterSeating.model.TicketRequest;

public class BookingServiceImpl implements BookingService {

	public void processRequest(TheaterLayout layout, List<TicketRequest> ticketRequests) {
		
		for(TicketRequest ticketRequest: ticketRequests) {
			
		}
		
		String decision = "";
		if(request.getNoOfTickets() > layout.getTotalCapacity()) {
			decision = request.getRequestedBy() + " Sorry, we can't handle your party";
		}
	}

}
