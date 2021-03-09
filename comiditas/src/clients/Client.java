package clients;

import java.io.Serializable;
import java.util.ArrayList;
import orders.Order;

public class Client extends Person implements Serializable{
	
	private String address; 
	private ArrayList<Order> orders;
	private int points;
	
	
	
	public Client(String name, String dni, int age, String address) {
		super(name, dni, age);
		this.address = address;
		this.orders = new ArrayList<Order>();
		this.points = 0;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Client "+super.toString()+" address=" + address + ", orders=" + orders + ", points=" + points + "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean result=super.equals(obj);
		return result;
	}
}