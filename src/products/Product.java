package products;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import interfaces.IProducto;

@XmlRootElement(name="product")
@XmlSeeAlso({Food.class,Drink.class})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Product implements IProducto,Serializable,Comparable {
	private Integer id;
	private static int count=0;
	private String name;
	private Double price;
	private boolean forCeliac;
	protected int sold;
	
	public Product(){
		this.id=0;
		this.name="";
		this.price=0.0;
		this.forCeliac=false;
	}
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", forCeliac=" + forCeliac + ", sold="
				+ sold + "]";
	}
	public abstract int compareTo(Object o);
}
