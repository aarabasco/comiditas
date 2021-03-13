package clients;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import orders.Order;

/* Aqu√≠ tenemos el constructor de cliente. Este constructor sirve para establecer datos como:
 * el nombre, el dni, la edad, direcci√≥n y las ordenes de los clientes.
 */
@XmlRootElement(name="client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client extends Person implements Serializable{
	
	private String address; 
	private ArrayList<Order> orders;
	private int points;
	
	public Client() {
		super("", "", 0);
		address="";
		this.orders = new ArrayList<Order>();
		this.points = 0;
	}

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
		return super.toString()+"\n"+
				"DirecciÛn:       "+this.getAddress()+".\n"+
				"Puntos:          "+this.getPoints()+".\n"+
				"N∫ de Ordenes:   "+this.getOrders().size()+".\n"+
				"-------------------------------------------\n";
	}

	@Override
	public boolean equals(Object obj) {
		boolean result=super.equals(obj);
		return result;
	}
}
