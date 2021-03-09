package interfaces;

import java.util.List;

public interface IProducto {
	public Integer[] getBundlePack();
	public String getName();
	public Double getPrice();
	public boolean getIsForCeliac();
}