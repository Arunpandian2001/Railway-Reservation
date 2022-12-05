package operations;

import java.util.Map;

import customexception.CustomException;
import data.Ticket;
import data.Train;
import storage.Storage;

public class UserOperations {

	public void bookTicket(Ticket ticket, int passengers) throws CustomException {
		
		
		if((Train.lower==5 || Train.upper==5 || Train.middle==5 || Train.rac==5) && passengers==1) {
			if(ticket.getPreference().equalsIgnoreCase("L")) {
				ticket.setStart(1+ticket.getPreference());
				Train.lower--;
			}
			else if(ticket.getPreference().equalsIgnoreCase("M")) {
				ticket.setStart(1+ticket.getPreference());
				Train.middle--;
			}
			else if(ticket.getPreference().equalsIgnoreCase("U")) {
				ticket.setStart(1+ticket.getPreference());
				Train.upper--;
			}
			else if(ticket.getPreference().equalsIgnoreCase("RAC")) {
				ticket.setStart(1+ticket.getPreference());
				Train.rac--;
			}
			
		}else {
			if(ticket.getPreference().equalsIgnoreCase("L")) {
				ticket.setStart(5-Train.lower+1+ticket.getPreference());
				Train.lower-=passengers;
			}
			else if(ticket.getPreference().equalsIgnoreCase("M")) {
				ticket.setStart(5-Train.middle+1+ticket.getPreference());
				Train.middle-=passengers;
			}
			else if(ticket.getPreference().equalsIgnoreCase("U")) {
				ticket.setStart(5-Train.upper+1+ticket.getPreference());
				Train.upper-=passengers;
			}
			else if(ticket.getPreference().equalsIgnoreCase("RAC")) {
				ticket.setStart(5-Train.rac+1+ticket.getPreference());
				Train.rac-=passengers;
			}
		}
		if(passengers>1) {
			if(ticket.getPreference().equalsIgnoreCase("L")) {
				ticket.setEnd(5-Train.lower+ticket.getPreference());
			}
			else if(ticket.getPreference().equalsIgnoreCase("M")) {
				ticket.setEnd(5-Train.middle+ticket.getPreference());
			}
			else if(ticket.getPreference().equalsIgnoreCase("U")) {
				ticket.setEnd(5-Train.upper+ticket.getPreference());
			}
			else if(ticket.getPreference().equalsIgnoreCase("RAC")) {
				ticket.setEnd(5-Train.rac+ticket.getPreference());
			}
		}
		int pnrNumber=ticket.getPnrNumber();
		Map<Integer,Ticket> map=Storage.VALUES.getReservaitoDetails();
		map.put(pnrNumber, ticket);
		Storage.VALUES.updateReservaitonDetails(map);
	}
	
	public void cancelTicket(int pnrNumber) throws CustomException {
		
		Map<Integer,Ticket> map=Storage.VALUES.getReservaitoDetails();
		map.remove(pnrNumber);
		Storage.VALUES.updateReservaitonDetails(map);
	}
}
