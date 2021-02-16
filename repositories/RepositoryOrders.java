package repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import models.Order;
//seguira el modelo Singleton
public class RepositoryOrders {
	List<Order> orders;
	
	//private static variable
	private static RepositoryOrders instanceO;
	
	//constructor private
	private RepositoryOrders(List<Order> orders) {
		super();
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	//getter personalizado
	public static RepositoryOrders getInstance_O(List<Order> orders) {
		if(instanceO==null) {
			instanceO=new RepositoryOrders(orders);
		}
		
		return instanceO;
	}	
	
	public List<Order> getAllOrder(){
		return orders;
		
	}
	
	public Order getOrderByClient(String dni){
		Order result=null;
		if(dni!=null) {
			for(int i=0;i<orders.size();i++) {
				
				if(orders.get(i).getCliente().getDni()!=null) {
					if(orders.get(i).getCliente().getDni().equals(dni)) {
						return orders.get(i);
					}
				}
			}
		}
		return result;
	}
	
	public List<Order> getOrderByDate(LocalDateTime ini, LocalDateTime end){
		List<Order> result=null;
	
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i)!=null&&orders.get(i).getDatetime()!=null) {
				if(orders.get(i).getDatetime().compareTo(ini)<0&&orders.get(i).getDatetime().compareTo(end)>0) {
					result.add(orders.get(i));
				}
				
				//una u otra
				
				if(orders.get(i).getDatetime().isAfter(ini)&&orders.get(i).getDatetime().isBefore(end)) {
					result.add(orders.get(i));
				}
			}
		}
		return result;
	}
	
	public List<Order> getOrdersNoDelivered(){
		List<Order> result=null;
	
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i)!=null&&!(orders.get(i).isDelivered())) {
				if(result==null) {
					result=new ArrayList<>();
				}
				result.add(orders.get(i));
			}
		}
		return result;
	}
	
	public List<Order> getOrdersNoPayed(){
		List<Order> result=null;
	
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i)!=null&&!(orders.get(i).isPayed())) {
				if(result==null) {
					result=new ArrayList<>();
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
	
	public double getinputByDate(LocalDateTime ini, LocalDateTime end) {
		double result=0;
		for(Order o:orders) {
			if(o!=null&&o.getDatetime()!=null) {
				if(o.getDatetime().isAfter(ini)&&o.getDatetime().isBefore(end)) {
					result+=o.getTotal();
				}
			}
		}
		
		return result;
	}
}
