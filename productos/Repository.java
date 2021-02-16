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
}