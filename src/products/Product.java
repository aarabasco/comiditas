package products;
import java.io.Serializable;
import java.util.List;

import interfaces.IProducto;
public abstract class Product implements IProducto,Serializable,Comparable {
	private Integer id;
	private static int count=0;
	private String name;
	private Double price;
	private boolean forCeliac;
	protected int sold;

	public Product(String name, Double price, boolean forCeliac) {
		this.id=count+1;
		this.name=name;
		this.price=price;
		this.forCeliac=forCeliac;
		count++;
		sold=0;
	}

	public String getName() {	
		return this.name;
	}
	public Double getPrice() {
		return this.price;
	}
	public boolean getIsForCeliac() {
		return this.forCeliac;
	}
	
	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", forCeliac=" + forCeliac + "]";
	}
	
	@Override
	public abstract int comparteTo(Object o);
}
