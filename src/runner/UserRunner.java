package runner;

import java.util.logging.Logger;

import com.util.getValues.InputCheck;

import customexception.CustomException;
import operations.UserOperations;

public class UserRunner {
	private int id = 0;
	private static Logger logger=Logger.getLogger(UserRunner.class.getName());
	public UserRunner(int id) {
		this.id=id;
	}
	public void userLayer() {
		UserOperations operation=new UserOperations();
		InputCheck input=new InputCheck();
		
		logger.info("Hello ........... Please select any option ");
		boolean loop=true;
		while(loop) {
			System.out.println("1) Book Ticket \n 2) Cancel Ticket \n 3) PNR Enquiry \n 4) Logout");
			int option=0;
			switch(option) {
			
				case 1:{
					logger.info("Max no.of tickets per PNR number:4");
					int passengers=0;
					
					logger.info("Enter the number of passengers ");
					try {
						passengers=input.isInteger();
					} catch (CustomException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}
		
	}
}
