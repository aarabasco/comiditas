package product_generator;

import java.util.ArrayList;
import java.util.List;

import products.*;
import utils.U;
import utils.uv;

public class Generator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductRepository rp=ProductRepository.instance();
		int n=U.getInt("Inserte el n�mero de productos que se van a generar");
		
		while(n>0) {
			Product p=generate();
			rp.addProduct(p);
			n--;
		}
		
		rp.saveFile();
		U.P("\nSe han guardado los datos correctamente.");
	}
	
	public static Product generate() {
		Product result=null;
		List<Integer>bundlePack=new ArrayList<Integer>();
		boolean forCeliac=false;
		boolean vegan=false;
		boolean alcoholic=false;
		int type = U.getInt("Inserte 1 para generar una comida, 2 para una bebida");
		while(type<1|type>2) {
			int option = U.getInt("Inserte 1 para generar una comida, 2 para una bebida");
		}
		
		String name=U.getString("Inserte un nombre");
		double price=(double)U.getFloat("Inserte un precio");
		
		int option=U.getInt("�Producto para Celiacos? 1 Si, 2 No.");
		while(option<1|option>2) {
			option = U.getInt("Inserte 1 para generar una comida, 2 para una bebida");
		}
		if(option==1) {
			forCeliac=true;
		}
		
		option=U.getInt("�Desea a�adir descuentos de BundlePack a este producto? 1 Si, 2 No");
		while(option<1|option>2) {
			option = U.getInt("Inserte 1 o 2");
		}
		
		if(option==1) {
			boolean continuar=true;
			while(continuar) {
				int bp=U.getInt("Inserte el Id del producto que desea combinar en un BundlePack");
				bundlePack.add(bp);
				
				option=U.getInt("�Desea continuar a�adiendo m�s Id? 1 Si, 2 No");
				while(option<1|option>2) {
					option = U.getInt("Inserte 1 o 2");
				}
				
				if(option==2) {
					continuar=false;
				}
			}
		}
		
		if(type==1) { //COMIDA
			option=U.getInt("�Producto para veganos? 1 Si, 2 No.");
			while(option<1|option>2) {
				option = U.getInt("Inserte 1 o 2");
			}
			if(option==1) {
				vegan=true;
			}
			
			result=new Food(name, price, forCeliac, vegan,bundlePack);
		}
		
		
		else { //BEBIDA
			option=U.getInt("�Producto con alcohol? 1 Si, 2 No.");
			while(option<1|option>2) {
				option = U.getInt("Inserte 1 o 2");	
			}
			if(option==1) {
				alcoholic=true;
			}
			
			result=new Drink(name, price, forCeliac, alcoholic,bundlePack);
		}
		
		System.out.println(result.toString());
		
		return result;
	}
}