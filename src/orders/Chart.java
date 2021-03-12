package orders;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import products.Product;
import utils.U;

@XmlRootElement(name="chart")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chart implements Serializable{
	private ArrayList<Product> lane;
	private ArrayList<Integer> cant;
	double total;
	double finalprice;

	public Chart() {
		super();
		this.lane = new ArrayList<Product>();
		this.cant = new ArrayList<Integer>();
	}

	public ArrayList<Product> getLane() {
		return lane;
	}

	public void setLane(ArrayList<Product> lane) {
		this.lane = lane;
	}

	public ArrayList<Integer> getCant() {
		return cant;
	}

	public double getTotal() {
		return total;
	}

	public void updatePrice() {
		double result = 0;

		for (int i = 0; i < lane.size(); i++) {
			result += lane.get(i).getPrice() * cant.get(i);
		}

		this.total = result;
	}

	public void addProducttoChart(Product p, int cantidad) {
		boolean añadido=false;
		if (p != null && cantidad > 0) {
			if(this.getLane()!=null&&this.getCant()!=null&&this.getLane().size()<1) {
				lane.add(p);
				cant.add(cantidad);
				this.updatePrice();
				añadido=true;
			}
			else {
				for (int i = 0; i < lane.size()&&!añadido; i++) {
					if (lane.get(i).getName().equals(p.getName())) {
						int increase = cant.get(i) + cantidad;
						cant.add(i, increase);
						cant.remove(i + 1);
						this.updatePrice();
						añadido=true;
					}
				}
			}
		}
		if(añadido==false){
			U.P("\nNo se ha podido añadir el producto al carrito.");
		}
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < cant.size(); i++) {
			result += (i + 1) + ". " + lane.get(i).getName() + " --> " + "x " + cant.get(i) + ".\n";
		}
		result += "\nEl total es: " + this.getTotal() + ".";
		return result;
	}

	public ArrayList<Product> ChartToOrder() {
		// TODO Auto-generated method stub
		ArrayList<Product> result = null;
		if (this.getLane().size() > 0) {
			result = new ArrayList<Product>();
			for (int i = 0; i < this.getLane().size(); i++) {
				for (int contador = this.getCant().get(i); contador > 0; contador--) {
					result.add(this.getLane().get(i));
				}
			}
		}
		return result;
	}

	public void setTotal(double total) {
		// TODO Auto-generated method stub
		this.total=total;
	}

}
