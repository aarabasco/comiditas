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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu
		MainMenuController mmc=new MainMenuController();
		ProductRepository rp=ProductRepository.instance();
		RepositoryOrders ro=RepositoryOrders.getInstance_O();
		RepositoryClients rc=RepositoryClients.getMiRepository();
		
		rp.loadFile();
		ro.loadFile();
		rc.loadFile();
		
		U.P("¡Bienvenido a la aplicación de Muslitos_Picantes!\n");
			int option=-1;
		do {
			option=uv.MainOrderMenu();
			
			switch(option) {
			case 1:
				mmc.newOrder();
				break;
			
			case 2:
				
				break;
			
			case 3:
				break;
			
			case 4:
				U.P("\nEl total recaudado es de "+ro.getAllInput()+" Euros.");
				break;
				
			case 5:
				if(ro.getOrdersNoPayed()!=null&&ro.getOrdersNoPayed().size()>0) {
					for(Order o: ro.getOrdersNoPayed()) {
						U.P(o.toString()+"\n");
					}
				}
				
				else {
					U.P("\nNo hay ordenes que mostrar.");
				}
				
				break;
				
			default:
				break;
			}
		}while(option>0);
		
		
	}
	
	
	
	public MainMenuController() {}
	
	public void newOrder() {
		// TODO Auto-generated method stub
		RepositoryOrders ro=RepositoryOrders.getInstance_O();
		RepositoryClients rc=RepositoryClients.getMiRepository(null);
		ProductRepository rp=ProductRepository.instance();
		OrderMenuController omc= new OrderMenuController();	
		Client c=null;
		String a=null;
		Chart chart=new Chart();
		boolean payed=false;
		//BUSQUEDA DE CLIENTE O CREACIÓN DE UNO
		boolean nuevoCliente=uv.usarcliente(); //
		if(nuevoCliente) {
			c=uv.createClientn();  //
		}
		else {
			boolean encontrado=false;
			while(!encontrado) {
				String dni=uv.search(); //
				ArrayList<Client> clist= rc.searchClientsDNI(dni);
				c=uv.chooseClient(clist); //
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
			
			option=uv.ChooseOrderMenu();
		
			switch (option) {
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
					U.P("No hay ninguna línea que editar.");
				}
				
				if(result) {
					U.p("Se ha editado la linea correctamente.");
				}
				break;
				
			case 3:
				result=false;
				if(chart.getLane().size()>0) {
					result= omc.removeLine(chart);
					if(result) {
						U.P("Se ha eliminado la linea correctamente.");
					}
					else {
						U.P("No se ha podido eliminar la linea.");
					}
				}
				else{
					U.p("No hay ninguna linea que eliminar.");
				}
				break;
				
			case 4:
				if(c!=null) {
					result=omc.setAdress(c);
					if(result&&c.getAddress()!=null) {
						a=c.getAddress();
						U.P("Se ha insertado correctamente la dirección de envio.\n");
					}
					else {
						U.P("No se ha podido insertar correctamente la dirección de envio.\n");
					}
				}
				else {
					U.P("No se ha podido insertar la dirección, no hay ningún cliente.\n");
				}
				
				break;
				
			case 5:
				payed=true;
				break;
				

			default:
				break;
			}
		
			if(option>=5&&c!=null&&a!=null&&chart!=null&&chart.getLane().size()>0) {
				LocalDateTime ldc=LocalDateTime.now();
				ArrayList<Product> productos=chart.ChartToOrder();
				Order o=new Order(c,productos ,chart.getTotal(), ldc, a, chart, false, payed);
				if(payed=true) {
					U.P("Se ha guardado la orden correctamente como pagada.");
				}
				else {
					U.P("Se ha guardado la orden correctamente como no pagada.");
				}
				ro.addOrder(o);
				if(result) {
					U.P("Se ha añadido la orden completamente.");
					c.getOrders().add(o);
					System.out.println(c.getOrders().size());
					//prueba toString Order:
					System.out.println(o);
					
					completed=true;
				}
				else {
					U.p("No se ha podido añadir tu orden, ya existe una orden con este código.");
				}
				completed=true;
			}
			else if(option>=5){
				U.P("\nDebe rellenar todos los campos:");
				omc.comprobarcampos(c, chart, chart.getLane().size(), a);
			}
		}while(!completed);
		
	}

	public void changeOrder(Order o) {
		// TODO Auto-generated method stub
		
	}

	public void changeOrder(LocalDateTime d) {
		// TODO Auto-generated method stub
		
	}

	public void changeOrder(Order o, LocalDateTime d) {
		// TODO Auto-generated method stub
		
	}
	
	public void deleteOrder(Order o) {
		// TODO Auto-generated method stub
		
	}

	public void deleteOrder(LocalDateTime d) {
		// TODO Auto-generated method stub
		
	}

	public void deleteOrder(Order o, LocalDateTime d) {
		// TODO Auto-generated method stub
		
	}

	public void cashToday() {
		double cashToday=0;
		RepositoryOrders ro=RepositoryOrders.getInstance_O();
		LocalDate day=LocalDate.now();
		for(Order o:ro.getAllOrder()) {
			
			if(o!=null&&o.getDatetime()!=null) {
				LocalDate aux=o.getDatetime().toLocalDate();
				if(aux.equals(o)) {
					cashToday+=o.getTotal();
				}
			}	
		}
		
		U.P("\nEl total ganado hoy es de "+cashToday+" Euros.");
		
	}

	public void cashThisMonth() {
		// TODO Auto-generated method stub
		double cashMonth=0;
		RepositoryOrders ro=RepositoryOrders.getInstance_O();
		Month mes = LocalDate.now().getMonth();
		int año= LocalDate.now().getYear();
		for(Order o:ro.getAllOrder()) {
			if(o!=null&&o.getDatetime()!=null) {
				if(o.getDatetime().getMonth().equals(mes)&&o.getDatetime().getYear()==año) {
					cashMonth+=o.getTotal();
				}
			}
		}
		
		U.P("\nEl total ganado este mes es "+cashMonth+" Euros.");
		
	}

	public void cashTotal() {
		// TODO Auto-generated method stub
		double cashTotal=0;
		RepositoryOrders ro=RepositoryOrders.getInstance_O();
		for(Order o:ro.getAllOrder()) {
			cashTotal+=o.getTotal();
		}
		
		U.P("\nEl total ganado en total es de "+cashTotal+" Euros.");
	}

	public void viewOrdersNotPayed() {
		// TODO Auto-generated method stub
		RepositoryOrders ro=RepositoryOrders.getInstance_O();
		ArrayList<Order> orders_not_payed=ro.getOrdersNoPayed();
		if(orders_not_payed!=null&&orders_not_payed.size()>0) {
			for(Order o:orders_not_payed) {
				if(o!=null) {
					U.P(o.toString());
				}
				
			}
		}
		
			
		else if(orders_not_payed==null||orders_not_payed.size()<1) {
			U.P("\nNo hay ninguna orden que mostrar.");
		}
	}

	public void viewOrdersPendingDelevered() {
		// TODO Auto-generated method stub
		RepositoryOrders ro=RepositoryOrders.getInstance_O();
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
