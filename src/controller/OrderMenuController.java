package controller;

import java.util.ArrayList;
import product_generator.Generator;
import interfaces.IOrderMenuController;
import orders.Chart;
import clients.Client;
import orders.Order;
import products.Product;
import products.*;
import utils.U;
import utils.uv;

public class OrderMenuController implements IOrderMenuController {
	RepositoryProducts rp = RepositoryProducts.instance();
	
	public boolean addProduct(Chart c) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		Product p = null;
		if(rp.getAllProducts()!=null&&rp.getAllProducts().size()>0) {
			int cantidad = -1;
			boolean encontrado = false;
			while (!encontrado) {
				int option=U.getInt("\nPulse 1 para buscar un producto, 2 para listarlos todos y seleccionarlo");
				while(option<1||option>2) {
					option=U.getInt("\nInserte una opción válida.");
				}
				
				if(option==1) {
					String nombre = uv.search();
					ArrayList<Product> plist = (ArrayList)rp.searchProducts(nombre);
					p = uv.chooseProduct(plist);
					if (p != null) {
						U.p("\nHa añadido el siguiente producto al carrito:\n"+
							p.toString());
						encontrado = true;
					}
					else {
						U.P("\nNo se ha encontrado el producto. Inténtelo de nuevo.");
					}
				}
				else {
					p = uv.chooseProduct((ArrayList<Product>) rp.getAllProducts());
					if (p != null) {
						U.p("\nHa añadido el siguiente producto al carrito:\n"+
							p.toString());
						encontrado = true;
					}
					else {
						U.P("\nNo se ha encontrado el producto. Inténtelo de nuevo.");
					}
				}
				
			}

			while (cantidad < 1) {
				cantidad = U.getInt("\nInserte cantidad a añadir");
			}

			c.addProducttoChart(p, cantidad);
			result = true;
		}
		else {
			U.p("No hay productos que añadir. Debes crear al menos uno:");
			Generator g=new Generator();
			int n=U.getInt("¿Cuantos productos deseas generar?");
			while(n>0) {
				g.generate();
			}
			
		}
		return result;
	}

	public boolean editLine(Chart chart) {
		// TODO Auto-generated method stub
		boolean result = false;
		boolean  continuar=true;
		int option=-1;
		
		while(chart!=null&&chart.getLane().size()>0&&continuar) {			
			int lane=U.getInt("\nInserte la línea que desea editar de las siguientes en su carrito:\n"+
					chart.toString())-1;
			while(lane<0||lane>chart.getLane().size()-1) {
				lane=U.getInt("\nInserte una opción válida")-1;
			}
			
			U.P("\nEstá modificando el siguiente producto:\n"+
				chart.getLane().get(lane).toString()+"\n");
			
			int cantidad=U.getInt("\nInserte la cantidad que desea comprar de ese producto");
			
			if(cantidad>0) {
				chart.getCant().add(lane,cantidad);
				chart.getCant().remove(lane+1);
				chart.updatePrice();
				result=true;
			}
			
			else {
				option=U.getInt("\nLa cantidad que ha añadido de este producto es 0. ¿Quiere eliminar esta línea?\n"+
								"Inserte 1 para eliminar, 0 para cancelar");
				while(option<0||option>1) {
					option=U.getInt("\nInserte una opción válida. Pulse 1 para eliminar, 0 para cancelar.");
				}
				
				if(option==1) {
					chart.getLane().remove(lane);
					chart.getCant().remove(lane);
					chart.updatePrice();
					result=true;
				}
			}
			
			if(chart.getLane().size()>0) {
				U.p("El carrito actualmente es el siguiente:\n"+
					chart.toString());
			}
			
			option=U.getInt("\n¿Desea continuar editando alguna línea? Pulse 1 para continuar, 0 para salir");
			while(option<0||option>1) {
				option=U.getInt("\nInserte una opción válida. Pulse 1 para continuar, 0 para salir");
			}
			if(option==0) {
				continuar=false;
			}
			
		}
		
		if(chart.getLane().size()<1) {
			U.p("\nNo hay ninguna línea que editar. Añada algún producto al carrito.");
		}

		return result;
	}

	public boolean removeLine(Chart chart) {
		// TODO Auto-generated method stub
		boolean result=false;
		if(chart!=null) {
			boolean continuar=true;
			if(chart.getLane().size()>0) {
				do {
					U.P(chart.toString());
					
					int lane=U.getInt("Inserte la línea que desea eliminar")-1;
					while(lane<0||lane>chart.getLane().size()-1) {
						lane=U.getInt("\nInserte una línea válida")-1;
					}
					
					U.P("\nVa a eliminar el siguiente producto:\n"+
							chart.getLane().get(lane).toString()+"\n");
					int option=U.getInt("¿Seguro que desea eliminar la línea?\n"+
										"Inserte 1 para eliminar, 0 para cancelar");
					while(option<0||option>1) {
						option=U.getInt("\nInserte una opción válida");
					}
					
					if(option==1) {
						chart.getLane().remove(lane);
						chart.getCant().remove(lane);
						if(chart.getLane().size()>0) {
							chart.updatePrice();
						}
						else if(chart.getLane().size()==0){
							chart.setTotal(0.0);
						}
						result=true;
					}
					
					U.p(chart.toString());
					option=U.getInt("¿Desea continuar eliminando líneas?\n"+
									"Pulse 1 para continuar, 0 para salir");
					while(option<0||option>1) {
						option=U.getInt("\nInserte una opción válida");
					}
					if(option==0||chart.getLane().size()<1) {
						continuar=false;
						if(chart.getLane().size()<1) {
							U.p("\nNo hay más lineas que eliminar.");
						}
					}
				}while(continuar);
			}
			else {
				U.P("\nNo hay más lineas que eliminar.");
			}
				
		}
		
		return result;
	}

	public boolean setAdress(Client c) {
		boolean result=false;
		if(c!=null) {
			String adress=U.getString("Inserte la dirección del envio del pedido");
			if(adress!=null) {
				c.setAddress(adress);
				result=true;
			}
		}

		
		return result;
		
	}

	public boolean savePaid(ArrayList<Order> ordersPaid) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean saveNotPaid(ArrayList<Order> ordersNoPaid) {
		// TODO Auto-generated method stub
		return false;
	}

	public void comprobarcampos(Client c, Chart chart, int size, String a) {
		if(c!=null&&chart!=null&&size>0&&a!=null) {
			U.P("\nTodos los campos están introducidos correctamente.");
		}
		else {
			String result="";
			if(c==null) {
				result+="\n-Debe insertar un cliente.";
			}
			if(chart==null) {
				result+="\n-No se ha creado un carrito.";
			}
			if(size<1) {
				result+="\n-No hay ningún producto en el carrito. Inserte al menos uno.";
			}
			if(a==null) {
				result+="\n-No ha insertado ninguna dirección de envio, inserte una.";
			}
			result+="\n";
			U.P(result);
		}
		
		
	}

}
