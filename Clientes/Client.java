package Clientes;

import java.util.ArrayList;

public class Client extends Person {
	
	private String address; 
	private ArrayList<Order> orders;
	private int points;
	
	
	
	public Client(String name, String dni, int age, String address, ArrayList<Order> orders, int points) {
		super(name, dni, age);
		this.address = address;
		this.orders = orders;
		this.points = points;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result=super.equals(obj);
		return result;
	}
}
