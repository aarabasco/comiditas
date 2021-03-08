package products;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import clients.*;

public class ProductRepository implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
		List<Product> bundleProducts=new ArrayList<Product>();
		Integer[] bundledProducts=prod.getBundlePack();
		for(Product p:products) {
			if(p!=null&&p.getBundlePack()!=null&&p.getBundlePack().length>0) {
				bundleProducts.add(p);
			}
		}
		return bundleProducts;
	}
	
	public List<Product> searchProducts(String name){
		List<Product>result=null;
		if(name!=null&&products!=null&&products.size()>0) {
			for(Product p:products) {
				if(p!=null&&p.getName()!=null&&p.getName().toLowerCase().contains(name.toLowerCase())) {
					if(result==null) {
						result=new ArrayList<Product>();
					}
					result.add(p);
				}	
			}
		}
		return result;
	}
	
	public List<Product> searchFood(String name){
		List<Product>result=null;
		
		if(name!=null&&products!=null&&products.size()>0) {
			for(Product p:products) {
				if(p!=null&&p instanceof Food &&p.getName()!=null&&p.getName().toLowerCase().contains(name.toLowerCase())) {
					if(result==null) {
						result=new ArrayList<Product>();
					}
					result.add(p);
				}	
			}
		}
		
		return result;
	}
	
	public List<Product> searchDrink(String name){
		List<Product>result=null;
		
		if(name!=null&&products!=null&&products.size()>0) {
			for(Product p:products) {
				if(p!=null&&p instanceof Drink &&p.getName()!=null&&p.getName().toLowerCase().contains(name.toLowerCase())) {
					if(result==null) {
						result=new ArrayList<Product>();
					}
					result.add(p);
				}	
			}
		}
		
		return result;
	}
	
	public void saveFile(){
		try {
			FileOutputStream fo=new FileOutputStream(new File("products.dat"));
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			oo.writeObject(products);
			oo.flush();
			oo.close();
		} catch (FileNotFoundException e) {
			System.out.println("Product file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadFile(){
		//NO FURULA
		try {
			FileInputStream fi=new FileInputStream("products.dat");
			ObjectInputStream oi=new ObjectInputStream(fi);
			products=(List<Product>) oi.readObject();
			oi.close();
		} catch (FileNotFoundException e) {
			System.out.println("Product file not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
