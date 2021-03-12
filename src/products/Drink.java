package products;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="drink")
@XmlAccessorType(XmlAccessType.FIELD)
public class Drink extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean alcoholic;	
	private Integer[] bundlePack;
	
	public Drink(){
		super();
		this.alcoholic=false;
		this.bundlePack=new Integer[] {0};
	}
	public Drink(String name, Double price, boolean forCeliac, boolean alcoholic, Integer[]bundlePack) {
		super(name, price, forCeliac);
		this.alcoholic=alcoholic;
		this.bundlePack=bundlePack;
	}
	
	public boolean isAlcoholic(){
		return this.alcoholic;
	}
	
	public Integer[] getBundlePack() {
		return bundlePack;
	}

	public void setBundlePack(Integer[] bundlePack) {
		this.bundlePack = bundlePack;
	}

	public String toString() {
		return super.toString()+" Drink [alcoholic="+alcoholic+"]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int resultado=0;
        if(o instanceof Drink) {
        	
        	Drink aux=(Drink) o;
        	
        	if (this.sold<aux.sold) {   resultado = -1;      }
            else if (this.sold>aux.sold) {    resultado = 1;      }
        }
        	
        return resultado;
	}
}