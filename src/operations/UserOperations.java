package operations;

import java.util.List;
import java.util.Map;

import customexception.CustomException;
import data.Passenger;
import data.Ticket;
import data.Train;
import storage.Storage;

public class UserOperations {

	public Ticket bookTicket(Ticket ticket, int passengers) throws CustomException {
		
		
		int pnrNumber=ticket.getPnrNumber();
		Map<Integer,Ticket> map=Storage.VALUES.getReservaitoDetails();
		map.put(pnrNumber, ticket);
		Storage.VALUES.updateReservaitonDetails(map);
		
		return ticket;
	}
	
	public void cancelTicket(int pnrNumber) throws CustomException {
		
		Map<Integer,Ticket> map=Storage.VALUES.getReservaitoDetails();
		removeTickets(pnrNumber,map);
		map.remove(pnrNumber);
		Storage.VALUES.updateReservaitonDetails(map);
	}

	private void removeTickets(int pnrNumber, Map<Integer, Ticket> map) {
		// TODO Auto-generated method stub
		Ticket ticket=map.get(pnrNumber);
		List<Passenger> list=ticket.getPassengersList();
		for(int i=0;i<list.size();i++) {
			
		}
	}
}
