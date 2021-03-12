package tests;

import products.*;

public class prueba1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductRepository rp=ProductRepository.instance();
		
		Product f1=new Food("Hamburguesa de Pollo", 0.0, false, false, new Integer[] {1,2});
		Product f2=new Food("Hamburguesa de Ternera", 0.0, false, false, new Integer[] {3,4});
		Product d1=new Drink("Pepsi", 0.0, false, false, new Integer[] {1,3});
		rp.addProduct(f1);
		rp.addProduct(f2);
		rp.addProduct(d1);
		//ArrayList<Product> lista_buscada=new ArrayList();
		//lista_buscada.add(f1);lista_buscada.add(f2);
		
		//Product p_a_añadir=uv.chooseProduct(lista_buscada);
		//System.out.println(p_a_añadir);
		rp.saveFile();
		
	}		
}