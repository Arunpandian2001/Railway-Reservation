package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import customexception.CustomException;
import data.Passenger;
import data.Ticket;
import fileloaddriver.FileDriver;

public class Dummy {

	public static void main(String[] args) {
		FileDriver file=new FileDriver();
//		List<Passenger> map=new ArrayList<>();
//		
//		Passenger passenger=new Passenger();
//		passenger.setAge(21);
//		passenger.setGender("M");
//		passenger.setName("main");
//		passenger.setPreference("RAC");
//		passenger.setSeatNumber("RAC1");
//		passenger.setPnrNumber(2020100);
//		
//		map.add(passenger);
//		
//		try {
//			file.saveRACDetails(map);
//		} catch (CustomException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Map<Integer,Ticket> map1 = null;
		try {
			map1=file.getBookingDetails();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map1.forEach((k,v)->{
			System.out.println(k);
		});
		
	}
}
