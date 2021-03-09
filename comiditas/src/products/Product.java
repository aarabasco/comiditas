package products;
import java.io.Serializable;

import interfaces.IProducto;
public abstract class Product implements IProducto,Serializable {
	private Integer id;
	private static int count=0;
	private String name;
	private Double price;
	private boolean forCeliac;

	public Product(String name, Double price, boolean forCeliac) {
		this.id=count+1;
		this.name=name;
		this.price=price;
		this.forCeliac=forCeliac;
		count++;
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
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", forCeliac=" + forCeliac + "]";
	}
}
