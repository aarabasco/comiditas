Repositorypackage productos;

import java.util.List;
import java.util.ArrayList;

public class Repository {
	private List<Product> products=new ArrayList<Product>();
	private static Repository productRepository;
	
	private Repository(){
	}

	public static Repository instance(){
		if(productRepository==null){
			productRepository=new Repository();
		}
		return productRepository;
	}

	public void addProduct(Product product){
		products.add(product);
	}
	//			Devuelve solo una línea por alguna razón
//	public Product[] gelAllProducts(){
//		Product[] allProducts=new Product[products.size()];
//		for(int i=0;i<products.size();i++){
//			allProducts[i]=products.get(i);
//		}
//		return allProducts;
//	}
	public void gelAllProducts(){
		for(int i=0;i<products.size();i++){
			System.out.println(products.get(i));
		}
	}
}
