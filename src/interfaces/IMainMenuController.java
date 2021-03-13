package interfaces;

import java.time.LocalDateTime;

import clients.*;
import orders.*;
import products.*;


public interface IMainMenuController {
	public void newOrder();
	public void changeOrder(Client c);
	public void changeOrder(LocalDateTime d);
	public void deleteOrder(Client c);
	public void deleteOrder(LocalDateTime d);
	public void cashToday();
	public void cashThisMonth();
	public void cashTotal();
	public void viewOrdersNotPayed();
	public void viewOrdersPendingDelevered();
	public void saveAllAndClose();
}
