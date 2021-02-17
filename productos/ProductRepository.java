package productos;

import java.util.List;
import java.util.ArrayList;

public class ProductRepository{
	private List<Product> products=new ArrayList<Product>();
	private static ProductRepository productRepository;
	
	private ProductRepository(){
	}

	public static ProductRepository instance(){
		if(productRepository==null){
			productRepository=new ProductRepository();
		}
		return productRepository;
	}

	public void addProduct(Product product){
		products.add(product);
	}
	public void gelAllProducts(){
		for(int i=0;i<products.size();i++){
			System.out.println(products.get(i));
		}
	}
}
