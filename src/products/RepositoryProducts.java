package products;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import orders.Chart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;


@XmlRootElement(name="repository")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepositoryProducts {
	private List<Product> products;
	private static RepositoryProducts productRepository;
	
	private RepositoryProducts(){
		products=new ArrayList<Product>();
	}

	public static RepositoryProducts instance(){
		if(productRepository==null){
			productRepository=new RepositoryProducts();
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
	
	public List<Product> getMostSoldProducts(){
		List<Product> result=null;
		
		if(products!=null&&products.size()>0) {
			for(Product p:products) {
				if(p.getSold()>0) {
					if(result==null) {
						result=new ArrayList<Product>();
					}
					result.add(p);
				}
			}
			
			result.sort(null);
		}
		
		return result;
	}
	
	public void updateProductsInfo(Chart c) {
		Iterator i= products.iterator();
		while(i.hasNext()) {
			Product rep=(Product) i.next();
			for(int j=0;j<c.getLane().size();j++) {
				if(c.getLane().get(j).equals(rep)) {
					rep.setSold(rep.getSold()+c.getCant().get(j));
				}
			}
		}
			
	}
	
	public void saveFile(){
		JAXBContext jaxbC;
		try {
			jaxbC=JAXBContext.newInstance(RepositoryProducts.class);
			Marshaller m = jaxbC.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(productRepository, new File("products.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void loadFile(){
		JAXBContext jaxbC;
		try {
			jaxbC=JAXBContext.newInstance(RepositoryProducts.class);
			Unmarshaller um = jaxbC.createUnmarshaller();
			RepositoryProducts r=(RepositoryProducts)um.unmarshal(new File("products.xml"));
			for(Product i:r.getAllProducts()){
				addProduct(i);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
