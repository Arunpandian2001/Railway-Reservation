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
		if(Storage.VALUES.getRacDetails().size()!=0) {
			removeTickets(pnrNumber,map);
		}
		map.remove(pnrNumber);
		Storage.VALUES.updateReservaitonDetails(map);
	}

	private void removeTickets(int pnrNumber, Map<Integer, Ticket> map) throws CustomException {
		// TODO Auto-generated method stub
		Ticket ticket=map.get(pnrNumber);
		List<Passenger> list=ticket.getPassengersList();
		for(Passenger pass:list) {
			String seatNumber=pass.getSeatNumber();
			String preference=pass.getPreference();
			shiftRAC(seatNumber,preference);
		}
	}

	private void shiftRAC(String seatNumber, String preference) throws CustomException {
		// TODO Auto-generated method stub
		List<Passenger> list=Storage.VALUES.getRacDetails();
		Passenger passenger=list.get(0);
		passenger.setSeatNumber(seatNumber);
		passenger.setPreference(preference);
		Map<Integer,Ticket> map=Storage.VALUES.getReservaitoDetails();
		Ticket ticket=map.get(passenger.getPnrNumber());
		List<Passenger> pass=ticket.getPassengersList();
		for(Passenger p: pass) {
			if(passenger.getName().equals(p.getName()) && passenger.getAge()==p.getAge()) {
				p=passenger;
				break;
			}
		}
		ticket.setPassengersList(pass);
		map.put(passenger.getPnrNumber(), ticket);
		Storage.VALUES.updateReservaitonDetails(map);
		list.remove(0);
		Storage.VALUES.updateRACDetails(list);
		Storage.VALUES.updateValues();
	}
}
