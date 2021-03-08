package products;

import java.io.Serializable;
import java.util.List;

public class Food extends Product implements Serializable{
	
	private boolean forVegans;
	private List<Integer> bundlePack;

	public Food(String name, Double price, boolean forCeliac, boolean forVegans,List<Integer>bundlePack) {
		super(name, price, forCeliac);
		this.forVegans = forVegans;
		this.bundlePack=bundlePack;
	}

	public boolean isForVegans(){
		return this.forVegans;
	}

	public List<Integer> getBundlePack() {
		return bundlePack;
	}

	public void setBundlePack(List<Integer> bundlePack) {
		this.bundlePack = bundlePack;
	}

	public String toString() {
		return super.toString()+" Food [forVegans=" + forVegans + "]";
	}
}
