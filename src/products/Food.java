package products;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="food")
@XmlAccessorType(XmlAccessType.FIELD)
public class Food extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean forVegans;
	private Integer[] bundlePack;
	
	public Food(){
		super();
		this.forVegans=false;
		this.bundlePack=new Integer[] {0};
	}
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int resultado=0;
		
        if(o instanceof Food) {
        	
        	Food aux=(Food) o;
        	
        	if (this.sold<aux.sold) {
        		resultado = -1;      
        	}
            else if (this.sold>aux.sold) {    
            	resultado = 1;      
            }
        }
        	
        return resultado;
	}
}
