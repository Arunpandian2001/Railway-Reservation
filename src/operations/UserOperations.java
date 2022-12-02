package operations;

import java.util.Map;

import data.Ticket;
import storage.Storage;

public class UserOperations {

	public void bookTicket(Ticket ticket) {
		int pnrNumber=ticket.getPnrNumber();
		Map<Integer,Ticket> map=Storage.VALUES.getReservaitoDetails();
		map.put(pnrNumber, ticket);
		Storage.VALUES.updateReservaitonDetails(map);
		
	}
	
	public void cancelTicket(int pnrNumber) {
		
		Map<Integer,Ticket> map=Storage.VALUES.getReservaitoDetails();
		map.remove(pnrNumber);
		Storage.VALUES.updateReservaitonDetails(map);
	}
}
