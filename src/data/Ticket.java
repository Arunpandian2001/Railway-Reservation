package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String trainName;
	private int trainNumber;
	private String classType;
	private String date;
	private String from;
	private String to;
	private int pnrNumber;
	private List<Passenger> passengersList=new ArrayList<>();
//	private String start;
//	private String end;
//	private String preference;
	
//	public String getPreference() {
//		return preference;
//	}
//	public void setPreference(String preference) {
//		this.preference = preference;
//	}
//	public String getStart() {
//		return start;
//	}
//	public void setStart(String start) {
//		this.start = start;
//	}
//	public String getEnd() {
//		return end;
//	}
//	public void setEnd(String end) {
//		this.end = end;
//	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public List<Passenger> getPassengersList() {
		return passengersList;
	}
	public void setPassengersList(List<Passenger> passengersList) {
		this.passengersList = passengersList;
	}
	public int getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	
	
}
