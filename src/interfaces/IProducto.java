package interfaces;

import java.util.List;

import products.Product;

public interface IProducto {
	public Integer[] getBundlePack();
	public String getName();
	public Double getPrice();
	public boolean getIsForCeliac();
	int comparteTo(Object o);
}