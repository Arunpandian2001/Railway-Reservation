package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.util.getValues.InputCheck;

import customexception.CustomException;
import data.Passenger;
import data.Ticket;
import data.Train;
import data.User;
import operations.UserOperations;
import storage.Storage;

public class UserRunner {
	private int id = 0;
	private static Logger logger=Logger.getLogger(UserRunner.class.getName());
	UserOperations operation=new UserOperations();
	InputCheck input=new InputCheck();
	Train train=new Train();
	public UserRunner(int id) {
		this.id=id;
	}
	public void userLayer() throws CustomException {
		
		logger.info("Hello ........... Please select any option ");
		boolean loop=true;
		while(loop) {
			System.out.println("1) Book Ticket \n 2) Cancel Ticket \n 3) PNR Enquiry \n 4)Profile\n 5) Logout");
			int option=input.isInteger();
			switch(option) {
			
				case 1:{
					Ticket ticket=bookTicket();
					logger.info("Ticket booked Successfully");
					printTicket(ticket);
					
					break;
				}
				
				case 2:{
					logger.info("Enter the PNR Number ::");
					 int pnrNumber=input.isInteger();
					
					 if(isPNRNumberValid(pnrNumber)) {
						 
						 Ticket ticket=Storage.VALUES.getReservaitoDetails().get(pnrNumber);
						 printTicket(ticket);
						 
						 logger.warning("To confirm cancellation press 1");
						 logger.warning("If not press 2");
						 int canceloption =input.isInteger();
						 if(canceloption==1) {
							 operation.cancelTicket(pnrNumber);
							 logger.info("Cancelled Ticket Successfully");
							 break;
						 }
						 else {
							 logger.info("The process is cancelled");break;
						 }
					 }
					 logger.warning("The entered PNR Number is invalid");
					 break;
					
				}
				
				case 3:{
					logger.info("Enter the PNR Number ::");
					 int pnrNumber=input.isInteger();
					 
					 if(isPNRNumberValid(pnrNumber)) {
						 Ticket ticket=Storage.VALUES.getReservaitoDetails().get(pnrNumber);
						 printTicket(ticket);
					 }
					 logger.warning("The entered PNR Number is invalid");
					 break;
				}
				
				case 4:{
					User user=Storage.VALUES.getUserDetails().get(id);
					printUserDetails(user);
					break;
				}
				case 5:{
					Storage.VALUES.updateValues();
					logger.info("Logging out");
					loop=false;
					break;
				}
				
				default:{
					logger.warning("Enter valid choice");
					break;
				}
			}
		}
		
	}
	
	private Ticket bookTicket() throws CustomException {
		logger.info("Max no.of tickets per PNR number:4");
		int passengers=0;
		
		logger.info("Enter the number of passengers ");
		passengers=input.isInteger();
		
		List<Passenger> passengersList=new ArrayList<>();
		for(int i=0;i<passengers;i++) {
			Passenger pass=new Passenger();
			logger.info("Enter name :: ");
			pass.setName(input.getString());
			logger.info("Enter age :: ");
			pass.setAge(input.isInteger());
			logger.info("Enter gender (If male enter 'M' if woman enter 'W' if Transgender enter 'T'):: ");
			pass.setGender(input.getString());

			passengersList.add(pass);
		}
		String classType="";
		boolean classLoop=true;
		while(classLoop) {
			logger.info("Enter class preference (1 for AC, 2 for Non-AC )");
			int classPreferenceNumber=input.isInteger();
			switch(classPreferenceNumber) {
				case 1:{
					classType="AC";
					classLoop=false;
					break;
				}
				case 2:{
					classType="Non-AC";
					classLoop=false;
					break;
				}
				default:{
					logger.warning("Please select valid option");
					break;
				}
			}
		}
		Storage.VALUES.updatePnrNumber(Storage.VALUES.getPnrNumber()+1);
		int pnrNumber=Storage.VALUES.getPnrNumber();
		
		Ticket ticket=new Ticket();
		if(Train.lower!=0) {
			ticket.setPreference("L");
		}
		else if(Train.middle!=0) {
			ticket.setPreference("M");
		}
		else if(Train.upper!=0) {
			ticket.setPreference("U");
		}
		else if(Train.rac!=0) {
			ticket.setPreference("RAC");
		}
		ticket.setPnrNumber(pnrNumber);
		ticket.setClassType(classType);
		ticket.setPassengersList(passengersList);
		ticket.setTrainName(Train.trainName);
		ticket.setTrainNumber(Train.trainNumber);
		ticket.setFrom(Train.from);
		ticket.setTo(Train.to);
		ticket.setDate(Train.date);
		
		operation.bookTicket(ticket,passengers);
		
		return ticket;

	}
	
	private boolean isPNRNumberValid(int pnrNumber) throws CustomException {
		if(Storage.VALUES.getReservaitoDetails().containsKey(pnrNumber))
			return true;
		return false;
	}
	private void printTicket(Ticket ticket) {
		 logger.info("The Reservation Details are");
		 System.out.println("+-------------------------------------------------------------------------+");
		 System.out.println("+ PNR Number   :: "+ticket.getPnrNumber()+"                               +");
		 System.out.println("+ Train name   :: "+ticket.getTrainName()+"                                    +");
		 System.out.println("+ Train Number :: "+ticket.getTrainNumber()+"                                  +");
		 System.out.println("+ Class        :: "+ticket.getClassType()+"                               +");
		 System.out.println("+ Date         :: "+ticket.getDate()+"                                         +");
		 System.out.println("+ From         :: "+ticket.getFrom()+"                                         +");
		 System.out.println("+ To           :: "+ticket.getTo()+"                                           +");
		 if(ticket.getPassengersList().size()>1) {
			 System.out.println("+ Seat number           :: "+ticket.getStart()+"-"+ticket.getEnd()+"                                       +");
		 }else {
			 System.out.println("+ Seat number           :: "+ticket.getStart()+"                                           +");
		 }
		 System.out.println("+ Passengers   Name          Age         Gender           +");

		 List<Passenger> list=ticket.getPassengersList();
		 list.forEach(s->{
			 System.out.println("+ "+s.getName()+"        "+s.getAge()+"              "+s.getGender()+"+");

		 });
		 
		 System.out.println("+-------------------------------------------------------------------------+");

	}
	private void printUserDetails(User user) {
		// TODO Auto-generated method stub
		logger.info(" User Profile ");
		 System.out.println("+----------------------------------------------------------+");
		 System.out.println("+ Name   :: "+user.getName()+"                             +");
		 System.out.println("+ Mobile   :: "+user.getMobile()+"                         +");
		 System.out.println("+ Email :: "+user.getEmail()+"                             +");
		 
		 System.out.println("+----------------------------------------------------------+");

	}
}
