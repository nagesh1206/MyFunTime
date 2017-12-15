package com.barclays.theaterSeating.service;

import java.util.List;

import com.barclays.theaterSeating.model.Section;
import com.barclays.theaterSeating.model.TheaterLayout;
import com.barclays.theaterSeating.model.TicketRequest;

public interface BookingService {

	public void processRequest(TheaterLayout layout, List<TicketRequest> ticketRequest);
	
	public Section availableSection(TheaterLayout layout);

}
