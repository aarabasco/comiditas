package orders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//seguira el modelo Singleton

@XmlRootElement(name="repositoryO")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepositoryOrders implements Serializable{

	private ArrayList<Order> orders;
	
	//private static variable
	private static RepositoryOrders instanceO;
	
	
	//constructor private
	private RepositoryOrders(ArrayList<Order> orders) {
		super();
		this.orders = orders;
	}
	
	private RepositoryOrders() {
		super();
		this.orders = new ArrayList<Order>();
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	//getter personalizado
	public static RepositoryOrders getInstance_O(ArrayList<Order> orders) {
		if(instanceO==null) {
			instanceO=new RepositoryOrders(orders);
		}
		
		return instanceO;
	}	
	
	public static RepositoryOrders getInstance_O() {
		if(instanceO==null) {
			instanceO=new RepositoryOrders();
		}
		
		return instanceO;
	}	
	
	public ArrayList<Order> getAllOrder(){
		return orders;
		
	}
	
	public ArrayList<Order> getOrdersByClient(String dni){
		ArrayList<Order> result=null;
		if(dni!=null) {
			for(int i=0;i<orders.size();i++) {
				
				if(orders.get(i).getCliente().getDni()!=null) {
					if(orders.get(i).getCliente().getDni().equals(dni)) {
						if(result==null) {
							result=new ArrayList<Order>();
						}
						result.add(orders.get(i));
					}
				}
			}
		}
		return result;
	}
	
	public ArrayList<Order> getOrdersByDate(LocalDate d){
		ArrayList<Order> result=new ArrayList<Order>();
	
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i)!=null&&orders.get(i).getDatetime()!=null) {
				
				if(orders.get(i).getDatetime().equals(d)) {
					result.add(orders.get(i));
				}
			}
		}
		return result;
	}
	
	public ArrayList<Order> getOrdersNoDelivered(){
		ArrayList<Order> result=null;
	
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i)!=null&&!(orders.get(i).isDelivered())) {
				if(result==null) {
					result=new ArrayList<Order>();
				}
				result.add(orders.get(i));
			}
		}
		return result;
	}
	
	public ArrayList<Order> getOrdersNoPayed(){
		ArrayList<Order> result=null;
	
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i)!=null&&!(orders.get(i).isPayed())) {
				if(result==null) {
					result=new ArrayList<Order>();
				}
				result.add(orders.get(i));
			}
		}
		return result;
	}
	
	public double getAllInput(){
		double result=0;
	
		for(Order o:orders) {
			if(o!=null) {
				result+=o.getTotal();
			}
		}
		
		return result;
	}
	
	public double getinputByDate(LocalDate d) {
		double result=0;
		for(Order o:orders) {
			if(o!=null&&o.getDatetime()!=null) {
				if(o.getDatetime().equals(d)) {
					result+=o.getTotal();
				}
			}
		}
		
		return result;
	}
	
	public boolean addOrder(Order o) {
		boolean result=true;
		if(o!=null) {
			for(Order order:orders) {
				if(order.getId()==o.getId()) {
					result=false;
				}
			}
			if(result) {
				orders.add(o);
			}
		}
		
		return result;
		
	}
	
	public void saveFile(){

		try {
			FileOutputStream fo=new FileOutputStream(new File("Order.dat"));
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			oo.writeObject(orders);
			oo.flush();
			oo.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado Order.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void loadFile(){

		try {
			FileInputStream fi=new FileInputStream("Order.dat");
			ObjectInputStream oi=new ObjectInputStream(fi);

			orders=(ArrayList<Order>)oi.readObject();
			oi.close();
		} catch (FileNotFoundException e) {
			System.out.println("No hay ordenes que cargar.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
