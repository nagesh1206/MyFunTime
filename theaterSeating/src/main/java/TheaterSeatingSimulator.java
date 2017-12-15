import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.barclays.theaterSeating.model.Row;
import com.barclays.theaterSeating.model.Section;
import com.barclays.theaterSeating.model.TheaterLayout;
import com.barclays.theaterSeating.model.TicketRequest;
import com.barclays.theaterSeating.service.BookingService;
import com.barclays.theaterSeating.service.BookingServiceImpl;

public class TheaterSeatingSimulator {

	public static void main(String[] args) {

		String line;
		StringBuilder layout = new StringBuilder();
		StringBuilder ticketRequests = new StringBuilder();
		boolean isLayoutFinished = false;

		System.out.println("Please enter Theater Layout and Ticket requests.\n");

		Scanner input = new Scanner(System.in);

		while ((line = input.nextLine()) != null && !line.equals("```")) {

			if (line.length() == 0) {
				isLayoutFinished = true;
				continue;
			}

			if (!isLayoutFinished) {
				layout.append(line + System.lineSeparator());

			} else {
				ticketRequests.append(line + System.lineSeparator());
			}

		}

		input.close();

		// TheaterService theaterService = new TheaterServiceImpl();

		try {

			String[] rows = layout.toString().split(System.lineSeparator());
			TheaterLayout theaterLayout = new TheaterLayout();

			for (int i = 0; i < rows.length; i++) {
				Row row = new Row();
				row.setRowNumber(i + 1);
				theaterLayout.addRows(row);
				List<Section> rowSections = new ArrayList<Section>();
				String[] sectionDetails = rows[i].split(" ");
				for (int j = 0; j < sectionDetails.length; j++) {
					Section section = new Section();
					section.setSectionNumber(j+1);
					section.setCapacity(Integer.parseInt(sectionDetails[j]));
					rowSections.add(section);
				}
			}

			rows = ticketRequests.toString().split(System.lineSeparator());
			List<TicketRequest> theaterTicketRequests = new ArrayList<TicketRequest>();
			for (int i = 0; i < rows.length; i++) {
				String[] requestDeatils = rows[i].split(" ");
				TicketRequest ticketRequest = new TicketRequest();
				ticketRequest.setRequestedBy(requestDeatils[0]);
				int noOfTickets = Integer.parseInt(requestDeatils[1]);
				ticketRequest.setNoOfTickets(noOfTickets);
				int totalCapacity = theaterLayout.getTotalCapacity() + noOfTickets;
				theaterLayout.setTotalCapacity(totalCapacity);
				theaterTicketRequests.add(ticketRequest);
			}
			
			BookingService bookingService = new BookingServiceImpl();
			bookingService.processRequest(theaterLayout, ticketRequests);	
			

		} catch (NumberFormatException nfe) {

			System.out.println(nfe.getMessage());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}