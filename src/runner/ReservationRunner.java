package runner;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.util.getValues.InputCheck;

import customexception.CustomException;
import login.LoginLayer;
import storage.Storage;

/*
 * 1001 - arun@123
 * 1002 - arriebi@143
 * 1003 - srini@123
 */

public class ReservationRunner {

	private static Logger logger=Logger.getLogger(ReservationRunner.class.getName());
	
	public static void main(String[] args) {
		FileHandler fh;
		
		try {
			fh=new FileHandler("logfiles/RailwayReservationLogFile.log");
			logger.addHandler(fh);
			SimpleFormatter simpleFormatter=new SimpleFormatter();
			fh.setFormatter(simpleFormatter);
			
		} catch (SecurityException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		LoginLayer login=new LoginLayer();
		InputCheck input=new InputCheck();

		try {
			Storage.VALUES.loadValues();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int id=0;
		String password="";

		boolean loginLoop=true;
		while(loginLoop) {
			boolean idLoop=true;
			while(idLoop) {
				logger.info("Enter user id");
				try {
					id=input.isInteger();
					idLoop=false;
				} catch (CustomException e) {
					logger.warning(e+"");
					
				}
			}
			boolean passwordLoop=true;
			while(passwordLoop) {
				logger.info("Enter password");
				password=input.getString();
				if(login.isAccountAvailable(id,password)) {
					logger.info("Welcome again");
					loginLoop=false;
					passwordLoop=false;
					UserRunner userRunner=new UserRunner(id);
					try {
						userRunner.userLayer();
					} catch (CustomException e) {
						logger.warning(e+"");
					}
				}else {
					logger.warning("Enter valid details");
				}
			}
		}

	}
}
