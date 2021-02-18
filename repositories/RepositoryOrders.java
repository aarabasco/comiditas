import java.time.LocalDateTime;
import java.util.ArrayList;

import models.Client;
import models.Order;
import repositories.RepositoryOrders;
public class pruebaRO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client c1David= new Client("abc", "David", 25, "C/Jose Nieto Muñoz");
		Client c2Elena= new Client("abd", "Elena", 30, "C/Pedraza");
		Order o1=new Order(c1David, null, 0, LocalDateTime.now(), c1David.getAdress(), false, false);
		Order o3=new Order(c1David, null, 200, LocalDateTime.now(), c1David.getAdress(), false, false);
		Order o2=new Order(c2Elena, null, 0, LocalDateTime.now(), c2Elena.getAdress(), false, false);
		ArrayList<Order> orders = new ArrayList<>();
		orders.add(o1);orders.add(o2);orders.add(o3);
		
		RepositoryOrders ro= RepositoryOrders.getInstance_O(orders);	
		System.out.println(ro.getOrdersByClient("abc"));
		
		System.out.println(ro.getAllInput());
	}

}
