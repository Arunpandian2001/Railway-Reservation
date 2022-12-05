package fileloaddriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import customexception.CustomException;
import data.Ticket;
import data.User;
import fileinterface.PersistentLayerPathway;

public class FileDriver implements PersistentLayerPathway{


	private <T,V>void updateFile(String fileName, Map<T, V> map) throws CustomException  {
		
		try(FileOutputStream fileWrite=new FileOutputStream(fileName);
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileWrite);){
			
			objectOutputStream.writeObject(map);
			
		} catch (FileNotFoundException e) {
			throw new CustomException("The given file name is not found",e);
		} catch (IOException e) {
			throw new CustomException("The given file caused IO exception",e);
		}
	}
	
	private <T,V>void updateFile(String fileName,int number) throws CustomException  {
		
		try(FileOutputStream fileWrite=new FileOutputStream(fileName);
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileWrite);){
			
			objectOutputStream.writeObject(number);
			
		} catch (FileNotFoundException e) {
			throw new CustomException("The given file name is not found",e);
		} catch (IOException e) {
			throw new CustomException("The given file caused IO exception",e);
		}
	}
	
	private Object getFromFile(String fileName) throws CustomException  {
		
		Object map = null;
		try(FileInputStream getFile=new FileInputStream(fileName);
				ObjectInputStream objectOutputStream=new ObjectInputStream(getFile);){
			
			map= objectOutputStream.readObject();
			
		} catch (FileNotFoundException e) {
			throw new CustomException("The given file name is not found",e);
		} catch (IOException e) {
			throw new CustomException("The given file caused IO exception",e);
		} catch (ClassNotFoundException e) {
			throw new CustomException("Class not found exception occured");
		}
		return map;
	}
	
	
	@Override
	public void saveUserDetails(Map<Integer,User> userDetails) throws CustomException {
		
		String fileName="UserCredentials_RailwayReservation.ser";
		
		updateFile(fileName,userDetails);
	}
	
	@Override
	public void saveBookingDetails(Map<Integer, Ticket> bookingDetails) throws CustomException {
		// TODO Auto-generated method stub
		
		String fileName="BookingDetails_RailwayReservation.ser";
		
		updateFile(fileName,bookingDetails);
	}
	
	@Override
	public void setPNRNumber(int pnrNumber) throws CustomException {
		// TODO Auto-generated method stub
		
		String fileName="LastPNRNumber_RailwayReservation.ser";
		updateFile(fileName,pnrNumber);
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<Integer, User> getUserDetails() throws CustomException {
		
		String fileName="UserCredentials_RailwayReservation.ser";
		
		return (Map<Integer, User>) getFromFile(fileName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, Ticket> getBookingDetails() throws CustomException {
		// TODO Auto-generated method stub
		
		String fileName="BookingDetails_RailwayReservation.ser";
		
		return (Map<Integer, Ticket>) getFromFile(fileName);
	}

	@Override
	public int getPNRNumber() throws CustomException {
		// TODO Auto-generated method stub
		String fileName="LastPNRNumber_RailwayReservation.ser";
		
		return (int) getFromFile(fileName);
	}


	
	
}
