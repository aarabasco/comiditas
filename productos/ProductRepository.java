package productos;

import java.util.List;
import java.util.ArrayList;

public class ProductRepository{
	private List<Product> products;
	private static ProductRepository productRepository;
	
	private ProductRepository(){
		products=new ArrayList<Product>();
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
	public void removeProduct(Product product){
		products.remove(product);
	}
	public void gelAllProducts(){
		for(int i=0;i<products.size();i++){
			System.out.println(products.get(i));
		}
	}
	public void gelAllDrinks(){
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Drink){
				System.out.println(products.get(i));
			}
		}
	}
	public void gelAllFoods(){
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Food){
				System.out.println(products.get(i));
			}
		}
	}
}