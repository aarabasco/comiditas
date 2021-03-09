package tests;

import java.util.ArrayList;

import models.Drink;
import models.Food;
import models.Product;
import repositories.ProductRepository;
import utils.uv;

public class prueba1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductRepository rp=ProductRepository.instance();
		
		Product f1=new Food("Hamburguesa de Pollo", 0.0, false, false);
		Product f2=new Food("Hamburguesa de Ternera", 0.0, false, false);
		Product d1=new Drink("Pepsi", 0.0, false, false);
		ArrayList<Product> lista_buscada=new ArrayList();
		lista_buscada.add(f1);lista_buscada.add(f2);
		
		Product p_a_añadir=uv.chooseProduct(lista_buscada);
		System.out.println(p_a_añadir);
	}

}
