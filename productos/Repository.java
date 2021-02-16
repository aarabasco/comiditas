package productos;

import java.util.ArrayList;

public class Repository {
	private static ArrayList<Product> products;
	
	public static ArrayList<Product> instance(){
		if(products==null){
			products=new ArrayList<Product>();
		}
		return products;
	}
	public Product[] gelAllProducts(){
		Product[] allProducts=new Product[products.size()];
		for(int i=0;i<=products.size();i++){
			allProducts[i]=products.get(i);
		}
		return allProducts;
	}
}