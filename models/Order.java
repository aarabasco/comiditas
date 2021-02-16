package models;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import models.*;

/**
 * 
 * @author david
 *
 */
public class Order {
	private UUID id;
	private Client cliente;
	private List<Product> productos;
	private double total;
	private LocalDateTime datetime;
	private String adress;
	private boolean delivered;
	private boolean payed;
	
	/**
	 * 
	 * @param cliente
	 * @param productos
	 * @param total
	 * @param datetime
	 * @param adress
	 * @param delivered
	 * @param payed
	 */
	public Order(Client cliente, List<Product> productos, double total, LocalDateTime datetime, String adress, boolean delivered,
			boolean payed) {
		super();
		this.id=UUID.randomUUID();
		this.cliente = cliente;
		this.productos = productos;
		this.total = total;
		this.datetime = datetime;
		this.adress = adress;
		this.delivered = delivered;
		this.payed = payed;
	}
	
	public Order() {
		this(null,null,0,null,"NO-DATA",false,false);
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

	public void setProductos(List<Product> productos) {
		this.productos = productos;
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

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public UUID getId() {
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
		return "Order [cliente=" + cliente + ", total=" + total + ", datetime=" + datetime + ", adress=" + adress
				+ ", delivered=" + delivered + ", payed=" + payed + "]";
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
