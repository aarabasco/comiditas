package orders;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import clients.*;
import products.*;

/**
 * 
 * @author david
 *
 */
@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable{
	private static int tid=0;
		
	private int id;
	private Client cliente;
	private ArrayList<Product> productos;
	private double total;
	private LocalDateTime datetime;
	private String adress;
	private boolean delivered;
	private boolean payed;
	private Chart chart;
	
	/**
	 * 
	 * @param cliente
	 * @param productos2 
	 * @param productos
	 * @param total
	 * @param datetime
	 * @param adress
	 * @param delivered
	 * @param payed
	 */
	public Order(Client cliente, ArrayList<Product> productos2, double total, LocalDateTime datetime, String adress, Chart chart, boolean delivered,
			boolean payed) {
		super();
		this.id=tid+=1;
		tid+=1;
		this.cliente = cliente;
		this.productos = new ArrayList<Product>();
		this.total = total;
		this.datetime = datetime;
		this.adress = adress;
		this.chart=chart;
		this.delivered = delivered;
		this.payed = payed;
	}
	
	public Order() {
		this(null,null,0,null,"",null,false,false);
		this.id=0;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	public Chart getChart() {
		return chart;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public int getId() {
		return id;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	@Override
	public String toString() {
		String pagado="No";
		String entregado="No";
		LocalDate fecha=datetime.toLocalDate();
		if(isDelivered()) {
			entregado="Si";
		}
		
		if(isPayed()) {
			pagado="Si";
		}
		
		return "\nOrder nº"+id+"\n"+
			     "-------------------------------------------\n"+
			     "Cliente:         "+cliente.getName()+".\n"+
			     "DNI del Cliente: "+cliente.getDni()+".\n"+
				 "Dirección:       "+adress+".\n"+
				 "Fecha:           "+fecha+".\n"+
				 "Entregado:       "+entregado+".\n"+
				 "Pagado:          "+pagado+".\n"+
				 "-------------------------------------------\n"+
				 "Total:           "+String.format("%.1f", total)+".\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
}
