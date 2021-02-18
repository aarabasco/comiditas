package MENUs;
import java.util.ArrayList;

import interfaces.IOrderMenuController;
import models.Order;
import models.Product;
public class OrderMenuController implements IOrderMenuController{

	@Override
	public boolean addProduct(Product product, Order order) {
		if(product!=null&&order!=null&&order.getProductos()!=null) {
			order.getProductos().add(product);
		return true;
	}
		return false;
	}

	@Override
	public boolean editLine() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeLine() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAdress(String adress, Order order) {
		if(adress!=null&&order!=null) {
			order.setAdress(adress);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean savePaid(ArrayList<Order> ordersPaid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveNotPaid(ArrayList<Order> ordersNoPaid) {
		// TODO Auto-generated method stub
		return false;
	}


}
