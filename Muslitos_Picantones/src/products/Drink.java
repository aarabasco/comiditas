package products;

import java.io.Serializable;
import java.util.List;

public class Drink extends Product implements Serializable{
	private boolean alcoholic;	
	private List<Integer> bundlePack;
	
	public Drink(String name, Double price, boolean forCeliac, boolean alcoholic, List<Integer>bundlePack) {
		super(name, price, forCeliac);
		this.alcoholic=alcoholic;
		this.bundlePack=bundlePack;
	}
	
	public boolean isAlcoholic(){
		return this.alcoholic;
	}
	
	public List<Integer> getBundlePack() {
		return bundlePack;
	}

	public void setBundlePack(List<Integer> bundlePack) {
		this.bundlePack = bundlePack;
	}

	public String toString() {
		return super.toString()+" Drink [alcoholic="+alcoholic+"]";
	}
}
