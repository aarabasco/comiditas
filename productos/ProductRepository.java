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
	public List<Product> getAllNoAlcoholicDrinks(){
		List<Product> allNoAlcoholicDrinks=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Drink){
				Drink aux=(Drink) products.get(i);
				if(!aux.isAlcoholic()){
					allNoAlcoholicDrinks.add(products.get(i));
				}
			}
		}
		return allNoAlcoholicDrinks;
	}
	public List<Product> getAllAlcoholicDrinks(){
		List<Product> allAlcoholicDrinks=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Drink){
				Drink aux=(Drink) products.get(i);
				if(aux.isAlcoholic()){
					allAlcoholicDrinks.add(products.get(i));
				}
			}
		}
		return allAlcoholicDrinks;
	}
	public List<Product> getAllForVeganFood(){
		List<Product> allForVeganFood=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Food){
				Food aux=(Food) products.get(i);
				if(aux.isForVegans()){
					allForVeganFood.add(products.get(i));
				}
			}
		}
		return allForVeganFood;
	}
	public List<Product> getBundleProducts(Product prod){
	//TODO Aun no hay bundles
		List<Product> bundleProducts=new ArrayList<Product>();
		return bundleProducts;
	}
	public List<Product> searchProduct(String name){
		List<Product> result=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			if(products.get(i).getName()==name){
				result.add(products.get(i));
			}
		}
		return result;
	}
	public List<Product> searchDrink(String name){
		List<Product> result=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Drink && products.get(i).getName()==name){
				result.add(products.get(i));
			}
		}
		return result;
	}
	public List<Product> searchFood(String name){
		List<Product> result=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			if(products.get(i) instanceof Food && products.get(i).getName()==name){
				result.add(products.get(i));
			}
		}
		return result;
	}
}