package productos;

public class Food extends Product{
	private boolean forVegans;

	public Food(String name, Double price, boolean forCeliac, boolean forVegans) {
		super(name, price, forCeliac);
		this.forVegans = forVegans;
	}

	public boolean isForVegans(){
		return this.forVegans;
	}
	@Override
	public String getBundlePack() {
		// TODO Auto-generated method stub
		return null;
	}
}