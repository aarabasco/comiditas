package productos;

public abstract class Product implements IProducto {
	private Integer id;
	private static int count=0;
	private String name;
	private Double price;
	private boolean forCeliac;

	public Product(String name, Double price, boolean forCeliac) {
		this.id=count;
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
}