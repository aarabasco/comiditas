package products;

import java.io.Serializable;
import java.util.List;

public class Food extends Product implements Serializable{
	
	private boolean forVegans;
	private Integer[] bundlePack;

	public Food(String name, Double price, boolean forCeliac, boolean forVegans,Integer[]bundlePack) {
		super(name, price, forCeliac);
		this.forVegans = forVegans;
		this.bundlePack=bundlePack;
	}

	public boolean isForVegans(){
		return this.forVegans;
	}

	public Integer[] getBundlePack() {
		return bundlePack;
	}

	public void setBundlePack(Integer[] bundlePack) {
		this.bundlePack = bundlePack;
	}

	public String toString() {
		return super.toString()+" Food [forVegans=" + forVegans + "]";
	}
}
