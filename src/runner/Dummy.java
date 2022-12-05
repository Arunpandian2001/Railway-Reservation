package runner;

import java.util.LinkedHashMap;
import java.util.Map;

import customexception.CustomException;
import data.Ticket;
import fileloaddriver.FileDriver;

public class Dummy {

	public static void main(String[] args) {
		FileDriver file=new FileDriver();
		Map<Integer,Ticket> map=new LinkedHashMap<>();
		try {
			map=file.getBookingDetails();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.forEach((k,v)->{
			System.out.println("Ticket :: "+v.getPnrNumber());
		});
	}
}
