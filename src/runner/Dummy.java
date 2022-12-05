package runner;

import java.util.LinkedHashMap;
import java.util.Map;

import customexception.CustomException;
import data.Passenger;
import data.Ticket;
import fileloaddriver.FileDriver;

public class Dummy {

	public static void main(String[] args) {
		FileDriver file=new FileDriver();
		Map<Integer,Passenger> map=new LinkedHashMap<>();
		
		Passenger passenger=new Passenger();
		passenger.setAge(21);
		passenger.setGender("M");
		passenger.setName("main");
		passenger.setPreference("RAC");
		passenger.setSeatNumber("RAC1");
		
		map.put(202210, passenger);
		
		try {
			file.saveRACDetails(map);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<Integer,Passenger> map1 = null;
		try {
			map1=file.getRACDetails();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map1.forEach((k,v)->{
			System.out.println(v.getSeatNumber());
		});
	}
}
