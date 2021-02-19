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
		if(product!=null&&!products.contains(product)){
			products.add(product);
		}
	}
	public void removeProduct(Product product){
		if(product!=null&&products.contains(product)){
			products.remove(product);
		}
	}
	public List<Product> getAllProducts(){
		List<Product> allProducts=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			allProducts.add(products.get(i));
		}
		return allProducts;
	}
	public List<Product> getAllDrinks(){
		List<Product> allDrinks=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Drink){
				allDrinks.add(products.get(i));
			}
		}
		return allDrinks;
	}
	public List<Product> getAllFoods(){
		List<Product> allFoods=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Food){
				allFoods.add(products.get(i));
			}
		}
		return allFoods;
	}
}