package interfaces;

import java.time.LocalDate;

import clients.*;


public interface IMainMenuController {
	public void newOrder();
	public void changeOrder(Client c);
	public void changeOrder(LocalDate d);
	public void deleteOrder(Client c);
	public void deleteOrder(LocalDate d);
	public void cashToday();
	public void cashThisMonth();
	public void cashTotal();
	public void viewAllOrders();
	public void viewOrdersNotPayed();
	public void viewOrdersPendingDelevered();
	public void saveAllAndClose();
}
