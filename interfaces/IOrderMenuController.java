package interfaces;

import java.util.ArrayList;

import models.*;

public interface IOrderMenuController {
	public boolean addProduct(Product product, Order order);
	public boolean editLine();
	public boolean removeLine();
	public boolean setAdress(String adress, Order order);
	public boolean savePaid(ArrayList<Order> ordersPaid);
	public boolean saveNotPaid(ArrayList<Order> ordersNoPaid);
}
