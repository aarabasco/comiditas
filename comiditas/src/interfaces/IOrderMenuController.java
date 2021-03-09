package interfaces;

import java.util.ArrayList;

import clients.*;
import orders.*;
import products.*;

public interface IOrderMenuController {
	public boolean addProduct(Chart c);
	public boolean editLine(Chart chart);
	public boolean removeLine(Chart chart);
	public boolean setAdress(Client c);
	public boolean savePaid(ArrayList<Order> ordersPaid);
	public boolean saveNotPaid(ArrayList<Order> ordersNoPaid);
	public void comprobarcampos(Client c, Chart chart, int size, String a);
}
