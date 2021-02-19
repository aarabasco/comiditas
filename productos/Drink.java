package productos;

public class Drink extends Product{
	private boolean alcoholic;	
	
	public Drink(String name, Double price, boolean forCeliac, boolean alcoholic) {
		super(name, price, forCeliac);
		this.alcoholic=alcoholic;
	}
	
	public boolean isAlcoholic(){
		return this.alcoholic;
	}
	@Override
	public String getBundlePack() {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString() {
		return super.toString()+" Drink [alcoholic="+alcoholic+"]";
	}
}