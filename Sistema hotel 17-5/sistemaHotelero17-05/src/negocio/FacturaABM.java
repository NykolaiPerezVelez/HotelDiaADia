package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

import datos.Estadia;
import datos.Factura;
import datos.ItemFactura;
import datos.FormaPago;
import funciones.Funciones;
import negocio.ItemFacturaABM;

public class FacturaABM {
	
	ItemFacturaABM ItemFactura = new ItemFacturaABM();
	
	List<ItemFactura> lstItemFactura = new ArrayList<ItemFactura>();
	
	public Factura facturarEstadia(Estadia estadia, FormaPago formaPago){
		
		GregorianCalendar fecha = new GregorianCalendar();
		
		int cantidadDias = Funciones.cantidadDiasEstadia(estadia.getDiaCheckIn(), estadia.getDiaCheckOut());
		double precio = estadia.getHabitacion().getPrecio();		
		double total = cantidadDias * precio;
		
		Factura factura = new Factura(1, fecha, estadia, total, estadia.getFormaPago(), "0", 0);
		
		factura.agregarItem(1, 1, estadia.getHabitacion().getTipoHabitacion().getDescripcion(),
					cantidadDias,  precio, cantidadDias * precio);
		
		return factura;
	} // end_public_facturarEstadia
	
	public Factura facturarServicios(Estadia estadia, FormaPago formaPago){
		
		GregorianCalendar fecha = new GregorianCalendar();
		
		double subtotal = 0.0;
		double total = 0.0;
		
		Factura factura = new Factura(2, fecha, estadia, total, formaPago, "0", 0);
		
		for(int i=0; i< estadia.getTicketConsumos().size(); i++){
			int j = 1;
			int cantidad = estadia.getTicketConsumos().get(i).getCantidad();
			double precio = estadia.getTicketConsumos().get(i).getServicio().getPrecio();
			total = cantidad * precio;
			subtotal = subtotal + total;
			factura.agregarItem(2, j, estadia.getTicketConsumos().get(i).getServicio().getDescripcionServicio(),
					cantidad, precio, total);
			j++;
		} // end_for
		
		factura.setTotal(subtotal);
		
		return factura;
	} // end_public_facturarServicios

} // end_class_FacturaABM