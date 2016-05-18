package negocio;

import datos.ItemFactura;

public class ItemFacturaABM {
	
	// METODO generarItemEstadia //////////////////////////////////////////////////////////////////
	
	public ItemFactura generarItemEstadia(int cantidad, String descripcion, double precio){
		
		double totalIt = precio * cantidad;
		
		ItemFactura itemEstadia = new ItemFactura(1, 1, descripcion, cantidad, precio, totalIt);
		
		return itemEstadia;
		
	} // end_public_itemEstadia

} // end_class_ItemFacturaABM