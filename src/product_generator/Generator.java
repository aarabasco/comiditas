package product_generator;

import java.util.ArrayList;
import java.util.List;

import products.*;
import utils.U;
import utils.uv;

public class Generator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepositoryProducts rp=RepositoryProducts.instance();

		int n=U.getInt("\nInserte el número de productos que se van a generar");
		
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
		int type = U.getInt("\nInserte 1 para generar una comida, 2 para una bebida");
		while(type<1|type>2) {
			int option = U.getInt("\nInserte 1 para generar una comida, 2 para una bebida");
		}
		
		String name=U.getString("\nInserte un nombre");
		double price=(double)U.getDouble("\nInserte un precio");
		
		int option=U.getInt("\n¿Producto para Celiacos? 1 Si, 2 No.");
		while(option<1|option>2) {
			option = U.getInt("\nInserte 1 para generar una comida, 2 para una bebida");
		}
		if(option==1) {
			forCeliac=true;
		}
		
		option=U.getInt("\n¿Desea añadir descuentos de BundlePack a este producto? 1 Si, 2 No");
		while(option<1|option>2) {
			option = U.getInt("\nInserte 1 o 2");
		}
		
		if(option==1) {
			boolean continuar=true;
			while(continuar) {
				int bp=U.getInt("\nInserte el Id del producto que desea combinar en un BundlePack");
				bundlePack.add(bp);
				
				option=U.getInt("\n¿Desea continuar añadiendo más Id? 1 Si, 2 No");
				while(option<1|option>2) {
					option = U.getInt("\nInserte 1 o 2");
				}
				
				if(option==2) {
					continuar=false;
				}
			}
		}
		
		if(type==1) { //COMIDA
			option=U.getInt("\n¿Producto para veganos? 1 Si, 2 No.");
			while(option<1|option>2) {
				option = U.getInt("\nInserte 1 o 2");
			}
			if(option==1) {
				vegan=true;
			}
			
			Integer[] bundlePackA=new Integer[bundlePack.size()];
			for(int i=0; i<bundlePack.size();i++) {
				bundlePackA[i]=bundlePack.get(i);
			}
			
			
			result=new Food(name, price, forCeliac, vegan,bundlePackA);
		}
		
		
		else { //BEBIDA
			option=U.getInt("\n¿Producto con alcohol? 1 Si, 2 No.");
			while(option<1|option>2) {
				option = U.getInt("\nInserte 1 o 2");	
			}
			if(option==1) {
				alcoholic=true;
			}
			
			Integer[] bundlePackA=new Integer[bundlePack.size()];
			for(int i=0; i<bundlePack.size();i++) {
				bundlePackA[i]=bundlePack.get(i);
			}
			result=new Drink(name, price, forCeliac, alcoholic,bundlePackA);
		}
		
		System.out.println(result.toString());
		
		return result;
	}
}
