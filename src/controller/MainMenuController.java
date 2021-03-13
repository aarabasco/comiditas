package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

import interfaces.IMainMenuController;
import clients.*;
import orders.*;
import products.*;
import utils.*;

public class MainMenuController implements IMainMenuController{
	static MainMenuController mmc=new MainMenuController();
	static ProductRepository rp=ProductRepository.instance();
	static RepositoryOrders ro=RepositoryOrders.getInstance_O();
	static RepositoryClients rc=RepositoryClients.getMiRepository();
	static OrderMenuController omc=new OrderMenuController();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu
		
		rp.loadFile();
		ro.loadFile();
		rc.loadFile();
		System.out.println(rp.getAllProducts());
		U.P("¡Bienvenido a la aplicación de Muslitos_Picantes!\n");
			int option=-1;
		do {
			option=uv.MainOrderMenu();
			
			switch(option) {
			
			//MAIN MENU CONTROLLER
			
			case 0:
				U.P("\nFin del Programa");
				break;	//SAVE AND EXIT
			
			case 1:
				mmc.newOrder();	//NEW ORDER
				break;
			
			case 2: //CHANGE ORDER MENU
				
				int option_Change_Order=U.getInt("\n¿Que desea hacer?\n"+
					"1. Buscar y modificar una orden por su cliente.\n"+
					"2. Buscar y modificar una orden por su fecha de encargo.\n"+
					"Inserte una opción");
				while(option_Change_Order<1||option>2) {
					option_Change_Order=U.getInt("\nInserte una opción válida");
				}
				
				switch(option_Change_Order) {
				case 1:
					//aqui va changeOrder(Client c)
					
					
					Client c=null;
					boolean encontrado=false;
					
					while(!encontrado) {
						int option_c=U.getInt("\n1. Buscar por dni.\n"+
											"2. Buscar por nombre.\n"+
											"3. Listar todos los clientes.");
						while(option_c<1||option_c>3) {
						option=U.getInt("\n¿Inserte una opción válida.");	
						}
						
						switch(option_c) {
						case 1:
							U.P("\nEstás buscando por dni.");
							String dni=uv.search(); //
							ArrayList<Client> dnilist= rc.searchClientsDNI(dni);
							c=uv.chooseClient(dnilist);
							break;
						
						case 2:
							U.P("\nEstás buscando por nombre.");
							String nombre=uv.search();
							ArrayList<Client> namelist= rc.searchClientsByName(nombre);
							c=uv.chooseClient(namelist);
							break;
							
						default:
							ArrayList<Client> alllist= rc.getAllClients();
							c=uv.chooseClient(alllist);
							break;
						}

						if(c!=null) {
							encontrado=true;
						}
						else {
							U.P("\nNo se ha encontrado el cliente. Inténtelo de nuevo.");
						}
				}
				
				if(c.getOrders()!=null&&c.getOrders().size()>0) {
					mmc.changeOrder(c);
				}
				else {
					U.P("\nEste cliente no tiene ordenes.");
				}
				
				
				break;
					
					
				
				case 2:
					//aqui va changeOrder(LocalDateTime d)
					
					LocalDate d=null;
					do {
						int year=U.getInt("Inserte el año (ej:2015)");
						int month=U.getInt("Inserte el mes(ej: 11)");
						while(month<1||month>12) {
							month=U.getInt("Inserte el mes válido (del 01 al 12)");
						}
						int day=U.getInt("Inserte el día para buscar (ej: 03)");
						while(day<1||day>31) {
							month=U.getInt("Inserte un día válido (del 01 al 31)");
						}
						
						d=LocalDate.of(year, month,day);
						if(d==null) {
							U.P("\nNo se ha podido especificar su fecha. Indíquela de nuevo.");
						}
					}while(d==null);
					
					mmc.changeOrder(d);
					
					break;
				
				}
				
				
				break;
			
			case 3: //DELETE ORDER MENU
				
				int option_Delete_order=-1;
				option_Delete_order=U.getInt("\n¿Que desea hacer?\n"+
					"1. Buscar y eliminar una orden por su cliente.\n"+
					"2. Buscar y eliminar una orden por su fecha de encargo.\n"+
					"Inserte una opción");
				while(option_Delete_order<1||option_Delete_order>2) {
					option_Delete_order=U.getInt("Inserte una opción válida");
				}
				
				switch(option_Delete_order) {
				case 1:
					//aqui va deleteOrder(Client c)
					Client c=null;
						boolean encontrado=false;
						
						while(!encontrado) {
							int option_c=U.getInt("\n1. Buscar por dni.\n"+
												"2. Buscar por nombre.\n"+
												"3. Listar todos los clientes.");
							while(option_c<1||option_c>3) {
							option=U.getInt("\n¿Inserte una opción válida.");	
							}
							
							switch(option_c) {
							case 1:
								U.P("\nEstás buscando por dni.");
								String dni=uv.search(); //
								ArrayList<Client> dnilist= rc.searchClientsDNI(dni);
								c=uv.chooseClient(dnilist);
								break;
							
							case 2:
								U.P("\nEstás buscando por nombre.");
								String nombre=uv.search();
								ArrayList<Client> namelist= rc.searchClientsByName(nombre);
								c=uv.chooseClient(namelist);
								break;
								
							default:
								ArrayList<Client> alllist= rc.getAllClients();
								c=uv.chooseClient(alllist);
								break;
							}

							if(c!=null) {
								encontrado=true;
							}
							else {
								U.P("\nNo se ha encontrado el cliente. Inténtelo de nuevo.");
							}
					}
					
					if(c.getOrders()!=null&&c.getOrders().size()>0) {
						mmc.deleteOrder(c);
					}
					else {
						U.P("\nEste cliente no tiene ordenes.");
					}
					
					
					break;
				
				case 2:
					
					LocalDate d=null;
					do {
						int year=U.getInt("Inserte el año (ej:2015)");
						int month=U.getInt("Inserte el mes(ej: 11)");
						while(month<1||month>12) {
							month=U.getInt("Inserte el mes válido (del 01 al 12)");
						}
						int day=U.getInt("Inserte el día para buscar (ej: 03)");
						while(day<1||day>31) {
							month=U.getInt("Inserte un día válido (del 01 al 31)");
						}
						
						d=LocalDate.of(year, month,day);
						if(d==null) {
							U.P("\nNo se ha podido especificar su fecha. Indíquela de nuevo.");
						}
					}while(d==null);
					
					mmc.deleteOrder(d);
					
					break;
				
				}
				
				break;
			
			case 4: //CASH MENU
				mmc.cashTotal();
				break;
				
			case 5: //VIEW ALL ORDERS
				mmc.viewAllOrders();
			
				break;
				
			case 6:
				mmc.viewOrdersNotPayed();
				break;
				
			default:
				mmc.viewOrdersPendingDelevered();
				break;
			}
			
			
		}while(option>0);
		
		
	}
	
	
	
	public MainMenuController() {}
	
	public void newOrder() {
		// TODO Auto-generated method stub
		Client c=null;
		String a=null;
		Chart chart=new Chart();
		boolean payed=false;
		//BUSQUEDA DE CLIENTE O CREACIÓN DE UNO
		boolean nuevoCliente=uv.usarcliente(); //
		if(nuevoCliente) {
			c=uv.createClient();  //
		}
		else {
			boolean encontrado=false;
			while(!encontrado) {
				int option=U.getInt("\n1. Buscar por dni.\n"+
									"2. Buscar por nombre.\n"+
									"3. Listar todos los clientes.");
				while(option<1||option>3) {
				option=U.getInt("\n¿Inserte una opción válida.");	
				}
				
				switch(option) {
				case 1:
					U.P("\nEstás buscando por dni.");
					String dni=uv.search(); //
					ArrayList<Client> dnilist= rc.searchClientsDNI(dni);
					c=uv.chooseClient(dnilist);
					break;
				
				case 2:
					U.P("\nEstás buscando por nombre.");
					String nombre=uv.search();
					ArrayList<Client> namelist= rc.searchClientsByName(nombre);
					c=uv.chooseClient(namelist);
					break;
					
				default:
					ArrayList<Client> alllist= rc.getAllClients();
					c=uv.chooseClient(alllist);
					break;
				}

				if(c!=null) {
					encontrado=true;
				}
				else {
					U.P("\nNo se ha encontrado el cliente. Inténtelo de nuevo.");
				}
			}
		}
		
		//ORDER MENU CONTROLLER...
		int option=-1;
		boolean completed = false;
		boolean result=false;
		do {
			U.P(chart.toString());
			option=uv.ChooseOrderMenu();
		
			switch (option) {

			case 0:
				U.P("\nSe ha cancelado su pedido. Volviendo al menú principal.");
				completed=true;
				break;
			
			case 1:
				result=omc.addProduct(chart);
				
				if(result) {
					U.P("\nEl producto se ha añadido correctamente al carrito.");
				}
				else {
					U.P("\nNo se ha podido añadir tu producto al carrito.");
				}
				
				break;
						
			case 2:
				result=false;
				if(chart.getLane().size()>0) {
					result=omc.editLine(chart);	
				}
				else {
					U.P("\nNo hay ninguna línea que editar.");
				}
				
				if(result) {
					U.p("\nSe ha editado la linea correctamente.");
				}
				break;
				
			case 3:
				result=false;
				if(chart.getLane().size()>0) {
					result= omc.removeLine(chart);
					if(result) {
						U.P("\nSe ha eliminado la linea correctamente.");
					}
					else {
						U.P("\nNo se ha podido eliminar la linea.");
					}
				}
				else{
					U.P("\nNo hay ninguna linea que eliminar.");
				}
				break;
				
			case 4:
				if(c!=null) {
					result=omc.setAdress(c);
					if(result&&c.getAddress()!=null) {
						a=c.getAddress();
						U.P("\nSe ha insertado correctamente la dirección de envio.\n");
					}
					else {
						U.P("\nNo se ha podido insertar correctamente la dirección de envio.\n");
					}
				}
				else {
					U.P("\nNo se ha podido insertar la dirección, no hay ningún cliente.\n");
				}
				
				break;
				
			case 5:
				payed=true;
				break;
				

			default:
				break;
			}
		
			if(option>=5&&c!=null&&a!=null&&chart!=null&&chart.getLane().size()>0) {
				LocalDate ldc=LocalDate.now();
				ArrayList<Product> productos=chart.ChartToOrder();
				Order o=new Order(c,productos ,chart.getTotal(), ldc, a, chart, false, payed);
				if(payed=true) {
					U.P("\nSe ha guardado la orden correctamente como pagada.");
				}
				else {
					U.P("\nSe ha guardado la orden correctamente como no pagada.");
				}
				result=ro.addOrder(o);
				if(result) {
					if(!rc.getAllClients().contains(c)) {
						rc.getAllClients().add(c);
					}
					U.P("\nSe ha añadido la orden completamente.");
					c.getOrders().add(o);
					rc.saveFile();
					U.P("\nSu orden es la siguiente: "+o);

					rp.updateProductsInfo(chart);
					
					ro.saveFile();
					rp.saveFile();
					
					//prueba sold increment:
					System.out.println(chart.getLane().get(0).getSold());
					completed=true;
				}
				else {
					U.P("\nNo se ha podido añadir tu orden, ya existe una orden con este código.");
				}
				completed=true;
			}
			else if(option>=5){
				U.P("\nDebe rellenar todos los campos:");
				omc.comprobarcampos(c, chart, chart.getLane().size(), a);
			}
		}while(!completed);
		
	}

	public void changeOrder(Client c) {
		// TODO Auto-generated method stub
		boolean completed=false;
		Order order_to_change=null;
		
		ArrayList<Order> orders_of_this_client=ro.getOrdersByClient(c.getDni());
		order_to_change=uv.chooseOrder(orders_of_this_client);
		
		U.P(order_to_change.toString());
		
		if(order_to_change!=null) {
			
			do {
				String payed="No.";
				String delivered="No.";
				if(order_to_change.isPayed()) {
					payed="Si.";
				}
				if(order_to_change.isDelivered()) {
					delivered="Si.";
				}
				
				int option=U.getInt("\n¿Qué desea modificar?\n"+
									"1. Dirección de envio: "+order_to_change.getAdress()+".\n"+
									"2. Pagado: "+payed+"\n"+
									"2. Entregado: "+delivered+"\n");
				while(option<1||option>3) {
					option=U.getInt("\nInserte una opción válida");
				}
				
				switch(option) {
				case 1:
					order_to_change.setAdress(U.getString("\nInserte la dirección de envío"));
					break;
				
				case 2:
					
					if(!order_to_change.isPayed()) {
						order_to_change.setPayed(true);
					}else {
						order_to_change.setPayed(false);
					}
					U.P("\nSe ha modificado correctamente el estado del pago de la orden.");
					break;
				
				default:
					if(!order_to_change.isDelivered()) {
						order_to_change.setDelivered(true);
					}else {
						order_to_change.setDelivered(false);
					}
					U.P("\nSe ha modificado correctamente el estado de entrega de la orden.");
					break;
				}
				
				option=U.getInt("¿Desea continuar? 1 Si, 2 No");
				while(option<1||option>2) {
					option=U.getInt("\nInserte una opción válida");
				}
				if(option==2) {
					completed=true;
					U.P("Su orden ha sido modificada\n"+
						order_to_change.toString());
				}
			}while(!completed);		
			
			ro.getAllOrder().remove(order_to_change);
			ro.saveFile();
			rc.saveFile();
			rp.saveFile();;
		}
		
		
	}

	public void changeOrder(LocalDate d) {
		// TODO Auto-generated method stub
		boolean completed=false;
		Order order_to_change=null;
		
		ArrayList<Order> orders_of_this_date=ro.getOrdersByDate(d);
		order_to_change=uv.chooseOrder(orders_of_this_date);
		U.P(order_to_change.toString());
		
		if(order_to_change!=null) {
			
			do {
				String payed="No.";
				String delivered="No.";
				if(order_to_change.isPayed()) {
					payed="Si.";
				}
				if(order_to_change.isDelivered()) {
					delivered="Si.";
				}
				
				int option=U.getInt("\n¿Qué desea modificar?\n"+
									"1. Dirección de envio: "+order_to_change.getAdress()+".\n"+
									"2. Pagado: "+payed+"\n"+
									"2. Entregado: "+delivered+"\n");
				while(option<1||option>3) {
					option=U.getInt("\nInserte una opción válida");
				}
				
				switch(option) {
				case 1:
					order_to_change.setAdress(U.getString("\nInserte la dirección de envío"));
					break;
				
				case 2:
					
					if(!order_to_change.isPayed()) {
						order_to_change.setPayed(true);
					}else {
						order_to_change.setPayed(false);
					}
					U.P("\nSe ha modificado correctamente el estado del pago de la orden.");
					break;
				
				default:
					if(!order_to_change.isDelivered()) {
						order_to_change.setDelivered(true);
					}else {
						order_to_change.setDelivered(false);
					}
					U.P("\nSe ha modificado correctamente el estado de entrega de la orden.");
					break;
				}
				
				option=U.getInt("¿Desea continuar? 1 Si, 2 No");
				while(option<1||option>2) {
					option=U.getInt("\nInserte una opción válida");
				}
				if(option==2) {
					completed=true;
					U.P("Su orden ha sido modificada\n"+
						order_to_change.toString());
				}
			}while(!completed);		
			
			ro.getAllOrder().remove(order_to_change);
			ro.saveFile();
			rc.saveFile();
			rp.saveFile();
		}
	}
	
	public void deleteOrder(Client c) {
		// TODO Auto-generated method stub
		Order order_to_delete=null;
		
		ArrayList<Order> orders_of_this_client=ro.getOrdersByClient(c.getDni());
		order_to_delete=uv.chooseOrder(orders_of_this_client);
		
		if(order_to_delete!=null) {
			U.P(order_to_delete.toString());
			
			if(order_to_delete!=null) {
				int option=U.getInt("\n¿Está seguro de que desea eliminar la orden? 1 para eliminar, 2 para cancelar");
				while(option<1||option>2) {
					option=U.getInt("\nInserte una opción válida");
				}
				
				if(option==1) {
					ro.getAllOrder().remove(order_to_delete);
					U.p("\nSe ha elminado correctamente su orden\n.");
					ro.saveFile();
				}
			}
		}
	}

	public void deleteOrder(LocalDate d) {
		// TODO Auto-generated method stub
		Order order_to_delete=null;
		
		ArrayList<Order> orders_of_this_client=ro.getOrdersByDate(d);
		order_to_delete=uv.chooseOrder(orders_of_this_client);
		
		if(order_to_delete!=null) {
			int option=U.getInt("\n¿Está seguro de que desea eliminar la orden? 1 para eliminar, 2 para cancelar");
			while(option<1||option>2) {
				option=U.getInt("\nInserte una opción válida");
			}
			
			if(option==1) {
				ro.getAllOrder().remove(order_to_delete);
				U.p("\nSe ha elminado correctamente su orden\n.");
				ro.saveFile();
				rc.saveFile();
				rp.saveFile();
			}
		}
		else {
			U.P("\nNo se ha encontrado ninguna orden con esos datos.");
		}
		
	}
	
	public void cashToday() {
		double cashToday=0;
		LocalDate day=LocalDate.now();
		for(Order o:ro.getAllOrder()) {
			
			if(o!=null&&o.getDatetime()!=null) {
				LocalDate aux=o.getDatetime();
				if(aux.equals(o)) {
					cashToday+=o.getTotal();
				}
			}	
		}
		
		U.P("\nEl total ganado hoy es de "+String.format("%.1f", cashToday)+" Euros.");
		
	}

	public void cashThisMonth() {
		// TODO Auto-generated method stub
		double cashMonth=0;
		Month mes = LocalDate.now().getMonth();
		int año= LocalDate.now().getYear();
		for(Order o:ro.getAllOrder()) {
			if(o!=null&&o.getDatetime()!=null) {
				if(o.getDatetime().getMonth().equals(mes)&&o.getDatetime().getYear()==año) {
					cashMonth+=o.getTotal();
				}
			}
		}
		
		U.P("\nEl total ganado este mes es "+String.format("%.1f", cashMonth)+" Euros.");
		
	}

	public void cashTotal() {
		// TODO Auto-generated method stub
		double cashTotal=0;
		for(Order o:ro.getAllOrder()) {
			cashTotal+=o.getTotal();
		}
		
		U.P("\nEl total recaudado es de "+String.format("%.1f", cashTotal)+" Euros.");
	}

	public void viewAllOrders() {
		ArrayList<Order> all_orders=ro.getAllOrder();
		if(all_orders!=null&&all_orders.size()>0) {
			for(Order o:all_orders) {
				if(o!=null) {
					U.P(o.toString()+"\n");
				}
				
			}
		}
		
			
		else if(all_orders==null||all_orders.size()<1) {
			U.P("\nNo hay ninguna orden que mostrar.");
		}
	}
	
	public void viewOrdersNotPayed() {
		// TODO Auto-generated method stub
		ArrayList<Order> orders_not_payed=ro.getOrdersNoPayed();
		if(orders_not_payed!=null&&orders_not_payed.size()>0) {
			for(Order o:orders_not_payed) {
				if(o!=null) {
					U.P(o.toString()+"\n");
				}
				
			}
		}
		
			
		else if(orders_not_payed==null||orders_not_payed.size()<1) {
			U.P("\nNo hay ninguna orden que mostrar.");
		}
	}

	public void viewOrdersPendingDelevered() {
		// TODO Auto-generated method stub
		ArrayList<Order> orders_not_delievered=ro.getOrdersNoDelivered();
		if(orders_not_delievered!=null&&orders_not_delievered.size()>0) {
			for(Order o:orders_not_delievered) {
				if(o!=null) {
					U.P(o.toString());
				}
				
			}
		}
		
			
		else if(orders_not_delievered==null||orders_not_delievered.size()<1) {
			U.P("\nNo hay ninguna orden que mostrar.");
		}
	}

	public void saveAllAndClose() {
		// TODO Auto-generated method stub
		
	}
}
