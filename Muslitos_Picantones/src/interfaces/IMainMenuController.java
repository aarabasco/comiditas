package interfaces;

import java.time.LocalDateTime;

import clients.*;
import orders.*;
import products.*;


public interface IMainMenuController {
	public void newOrder();
	public void changeOrder(Order o);
	public void changeOrder(LocalDateTime d);
	public void changeOrder(Order o, LocalDateTime d);
	public void deleteOrder(Order o);
	public void deleteOrder(LocalDateTime d);
	public void deleteOrder(Order o, LocalDateTime d);
	public void cashToday();
	public void cashThisMonth();
	public void cashTotal();
	public void viewOrdersNotPayed();
	public void viewOrdersPendingDelevered();
	public void saveAllAndClose();
}
