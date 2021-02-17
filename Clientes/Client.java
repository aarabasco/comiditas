package Clientes;
public class Client extends Person {
	
	private String address; 
	private int orders;
	private int points;
	
	
	
	public Client(String name, int dni, int age, String address, int orders, int points) {
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
	
	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}