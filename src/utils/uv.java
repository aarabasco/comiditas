package utils;

import java.util.ArrayList;

import clients.Client;
import orders.Order;
import products.Product;

public class uv {
	public static void inicio() {
		//imprime un mensaje al inicio del programa
	}

	public static boolean usarcliente() {
		// TODO Auto-generated method stub
		int option=0;
		option=U.getInt("\nInserte 1 para usar cliente existente, 2 para nuevo.");
		while(option<1||option>2) {
			option=U.getInt("\nInserte opcion valida, 1 o 2");
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
		 * Devuelve un Cliente. Este método va pidiendo los datos de las variables que
		 * conforman un cliente. Posteriormente, crea un cliente con esos datos y lo
		 * devuelve como resultado. Cotejar que todos los datos estén en valores
		 * correctos.
		 */
		
		int option = U.getInt();
		char nombre;
		int edad;
		String name=U.getString("\nInserte nombre");
		String dni="";
		boolean correcto=false;

		while(!correcto) {
			dni=U.getString("\nInserte un DNI");
			correcto=validarDNI(dni);
		}
	
		edad=U.getInt("\nInserte una edad");
		if (edad < 12 || edad > 130) {
			option=U.getInt("\nInserte un valor valido");
		} 
		
		String address=U.getString("\nInserte una direccion");
		
		Client result=new Client (name, dni, edad, address);
		return result;
	}
	
	public static boolean validarDNI(String dni) {
		boolean result=false;
		
		if(dni.matches("[0-9]{8}[a-zA-Z]")) {
			return true;
		}
		
		return false;
		
	}
	
	public static Client createClientn() { //para prueba rapida
		Client c=new Client("Juan", "555555A", 18, "Jose nieto muñoz");
		return c;
	}

	public static String search() { //
		String result="";
		result=U.getString("Inserte algo para buscar en la base de datos");
		return result;
	}

	public static Client chooseClient(ArrayList<Client> aux) {
		Client result=null;
		
		String list="";
		
		if(aux!=null&&aux.size()>0) {
			for (int i = 0; i < aux.size(); i++) {
				if(aux.get(i)!=null&&aux.get(i).getDni()!=null) {
					list+=(i+1)+" "+aux.get(i).getDni()+".\n";
					if(i==aux.size()-1) {
						list+="\nElija una opción";
					}
				}
			}
			
			int option=U.getInt("\nHemos encontrado los siguientes resultados.\n"+
					"Elija un producto para añadirlo:\n"+
					list);
			while(option<1||option>aux.size()) {
			option=U.getInt("\nHemos encontrado los siguientes resultados.\n"+
							"Elija una opción válida:\n"+
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
					list+=(i+1)+" "+aux.get(i).getCliente().getDni()+" "+aux.get(i).getCliente().getName()+" "+aux.get(i).getDatetime()+".\n";
					if(i==aux.size()-1) {
						list+="\nElija una opción";
					}
				}
			}
			
			int option=U.getInt("\nHemos encontrado los siguientes resultados.\n"+
					"Elija una orden para operar:\n"+
					list);
			while(option<1||option>aux.size()) {
			option=U.getInt("\nHemos encontrado los siguientes resultados.\n"+
							"Elija una opción válida:\n"+
							list);
			}
			
			result=aux.get(option-1);
		}
		
		return result;
		
	}
	
	public static Product chooseProduct(ArrayList<Product> aux) {
		Product result=null;
		String list="";
		if(aux!=null&&aux.size()>0) {
			for (int i = 0; i < aux.size(); i++) {
				if(aux.get(i)!=null&&aux.get(i).getName()!=null) {
					list+=(i+1)+" "+aux.get(i).getName()+".\n";
					if(i==aux.size()-1) {
						list+="\nElija una opción";
					}
				}
			}
			
			int option=U.getInt("\nHemos encontrado los siguientes resultados.\n"+
					"Elija un producto para añadirlo:\n"+
					list);
			
			while(option<1||option>aux.size()) {
				option=U.getInt("\nHemos encontrado los siguientes resultados.\n"+
								"Elija una opción válida:\n"+
								list);
			}
			
			result=aux.get(option-1);
		}
		
		return result;
	}
	//imprime el menu de Order menu Controller y devuelve la opción
	
	public static int ChooseOrderMenu() {

		/*
		 * Imprime un menu con las siguientes opciones: 1 Añadir un producto a la orden
		 * 2 Editar una linea de la orden 3 Eliminar una linea de la orden 4 Pedir la
		 * direccion de envio 5 Guardar como orden pagada 6 Guardar como orden no pagada
		 * 0 Cancelar pedido y salir
		 */

		System.out.println("\nPulsa 1) para añadir un producto");
		System.out.println("Pulsa 2) para editar una orden");
		System.out.println("Pulsa 3) eliminar una orden");
		System.out.println("Pulsa 4) direccion de envío");
		System.out.println("Pulsa 5) guardar orden como pagada");
		System.out.println("Pulsa 6) guardar orden como no pagada");
		System.out.println("Pulsa 0) cancelar pedido y salir");

		int option = U.getInt("\nInserte una opcion");
		while (option < 0 || option > 6) {
			option = U.getInt("\nInserte un valor valido");
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
			result=U.getString("Inserte un DNI valido. Formato: (8 Números + 1 Letra)");
			correcto=validarDNI(result);
		}
		return result;
	}
	
	public static int MainOrderMenu() {
		
		System.out.println("\nPulsa 1) para crear una nueva orden");
		System.out.println("Pulsa 2) para editar una orden");
		System.out.println("Pulsa 3) para eliminar una orden");
		System.out.println("Pulsa 4) para ver el dinero recaudado");
		System.out.println("Pulsa 5) para ver las ordenes por pagar");
		System.out.println("Pulsa 0) para guardar y cerrar");
	
		int option = U.getInt("\nInserte una opcion");
		while (option < 0 || option > 5) {
			option = U.getInt("\nInserte un valor valido");
		} 
		return option;
	}
}
