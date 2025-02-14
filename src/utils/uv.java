package utils;

import java.util.ArrayList;

import clients.Client;
import orders.Order;
import products.Product;

public class uv {
	public static boolean usarcliente() {
		// TODO Auto-generated method stub
		int option=0;
		option=U.getInt("\n Inserte 1 para usar cliente existente, 2 para nuevo.");
		while(option<1||option>2) {
			option=U.getInt("\n Inserte opcion valida, 1 o 2");
		}
		
		if(option==1) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public static Client createClient() {
		/*
		 * Devuelve un Cliente. Este m�todo va pidiendo los datos de las variables que
		 * conforman un cliente. Posteriormente, crea un cliente con esos datos y lo
		 * devuelve como resultado. Cotejar que todos los datos est�n en valores
		 * correctos.
		 */
		
		int edad;
		String name=U.getString("\n Inserte un nombre");
		String dni="";
		boolean correcto=false;

		while(!correcto) {
			dni=U.getString("\n Inserte un DNI");
			correcto=validarDNI(dni);
		}
	
		edad=U.getInt("\n Inserte una edad");
		if (edad < 12 || edad > 130) {
			edad=U.getInt("\n Inserte un valor valido");
		} 
		
		String address=U.getString("\n Inserte una direccion");
		
		Client result=new Client (name, dni, edad, address);
		return result;
	}
	
	public static boolean validarDNI(String dni) {
		
		if(dni.matches("[0-9]{8}[a-zA-Z]")) {
			return true;
		}
		
		return false;
		
	}

	public static String search() { //
		String result="";
		result=U.getString("\n Inserte algo para buscar en la base de datos");
		return result;
	}

	public static Client chooseClient(ArrayList<Client> aux) {
		Client result=null;
		
		String list="";
		
		if(aux!=null&&aux.size()>0) {
			for (int i = 0; i < aux.size(); i++) {
				if(aux.get(i)!=null&&aux.get(i).getDni()!=null) {
					list+=" "+(i+1)+" "+aux.get(i).getDni()+", "+aux.get(i).getName()+", n� pedidos: "+aux.get(i).getOrders().size()+".\n";
					if(i==aux.size()-1) {
						list+="\n Elija una opci�n";
					}
				}
			}
			
			int option=U.getInt("\n Hemos encontrado los siguientes resultados.\n"+
					" Elija un cliente para operar:\n"+
					list);
			while(option<1||option>aux.size()) {
			option=U.getInt("\n Hemos encontrado los siguientes resultados.\n"+
							" Elija una opci�n v�lida:\n"+
							list);
			}
			
			result=aux.get(option-1);
		}
		
		return result;
		
	}
	
	public static Order chooseOrder(ArrayList<Order> aux) {
		Order result=null;
		
		String list="";
		
		if(aux!=null&&aux.size()>0) {

			for (int i = 0; i < aux.size(); i++) {
				if(aux.get(i)!=null&&aux.get(i).getCliente().getDni()!=null&&aux.get(i).getCliente().getName()!=null) {
					list+=" "+(i+1)+" "+aux.get(i).getCliente().getDni()+" "+aux.get(i).getCliente().getName()+" "+aux.get(i).getDatetime()+"  "+aux.get(i).getTotal()+".\n";
					if(i==aux.size()-1) {
						list+="\n Elija una opci�n";
					}
				}
			}
			
			int option=U.getInt("\n Hemos encontrado los siguientes resultados.\n"+
					" Elija una orden para operar:\n"+
					"\n -----DNI-----Nombre---Fecha---Total\n"+
					list);
			while(option<1||option>aux.size()) {
			option=U.getInt("\n Hemos encontrado los siguientes resultados.\n"+
					"\n -----DNI-----Nombre---Fecha---Total\n"+
							list);
			}
			
			result=aux.get(option-1);
		}
		else {
			U.p("\n No se ha encontrado ninguna orden.");
		}
		
		return result;
		
	}
	
	public static Product chooseProduct(ArrayList<Product> aux) {
		Product result=null;
		String list="";
		if(aux!=null&&aux.size()>0) {
			for (int i = 0; i < aux.size(); i++) {
				if(aux.get(i)!=null&&aux.get(i).getName()!=null) {
					list+=" "+(i+1)+" "+aux.get(i).getName()+".\n";
					if(i==aux.size()-1) {
						list+="\n Elija una opci�n";
					}
				}
			}
			
			int option=U.getInt("\n Hemos encontrado los siguientes resultados.\n"+
					"\n Elija un producto para operar:\n"+
					list);
			
			while(option<1||option>aux.size()) {
				option=U.getInt("\n Hemos encontrado los siguientes resultados.\n"+
								"\n Elija una opci�n v�lida:\n"+
								list);
			}
			
			result=aux.get(option-1);
		}
		
		return result;
	}
	//imprime el menu de Order menu Controller y devuelve la opci�n
	
	public static int ChooseOrderMenu() {

		/*
		 * Imprime un menu con las siguientes opciones: 1 A�adir un producto a la orden
		 * 2 Editar una linea de la orden 3 Eliminar una linea de la orden 4 Pedir la
		 * direccion de envio 5 Guardar como orden pagada 6 Guardar como orden no pagada
		 * 0 Cancelar pedido y salir
		 */

		System.out.println("\n Pulsa 1) para a�adir un producto");
		System.out.println(" Pulsa 2) para editar una orden");
		System.out.println(" Pulsa 3) eliminar una orden");
		System.out.println(" Pulsa 4) direccion de env�o");
		System.out.println(" Pulsa 5) guardar orden como pagada");
		System.out.println(" Pulsa 6) guardar orden como no pagada");
		System.out.println(" Pulsa 0) cancelar pedido y salir");

		int option = U.getInt("\n Inserte una opcion");
		while (option < 0 || option > 6) {
			option = U.getInt("\n Inserte un valor valido");
		} 
			return option;
	}
	
	public static String pideDNI() {
		/*
		 * Devuelve un String con un DNI, cotejar que tenga 8 numeros y 1 letra.
		 */
		boolean correcto=false;
		String result="";
		while(!correcto) {
			result=U.getString("\n Inserte un DNI valido. Formato: (8 N�meros + 1 Letra)");
			correcto=validarDNI(result);
		}
		return result;
	}
	
	public static int MainOrderMenu() {
		
		System.out.println("\n Pulsa 1) para crear una nueva orden.");
		System.out.println(" Pulsa 2) para editar una orden.");
		System.out.println(" Pulsa 3) para eliminar una orden.");
		System.out.println(" Pulsa 4) para entrar en la Base de Datos.");
		System.out.println(" Pulsa 5) para eliminar un cliente.");
		System.out.println(" Pulsa 6) para eliminar un producto.");
		System.out.println(" Pulsa 0) para guardar y cerrar.");
	
		int option = U.getInt("\n Inserte una opcion");
		while (option < 0 || option > 6) {
			option = U.getInt("\n Inserte un valor valido");
		} 
		return option;
	}
}
