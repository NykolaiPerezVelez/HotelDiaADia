package datos;

import java.util.GregorianCalendar;
//import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import funciones.Funciones;

public class Factura {
			
	private int idFactura;
	private Login empleado;
	private GregorianCalendar fecha;
	private Cliente cliente; 
	private List<ItemFactura> itemsFactura;		
	private double total;
	private FormaPago formaPago;		
	private String nroTarjeta;
	private boolean abonada;								
	
	public Factura(){} // CONSTRUCTOR HIBERNATE
	
	//No siempre se paga con tarjeta, entonces en algunos casos no tendria que pasarlo como parametro.		
	//¿Que podria hacer? -> Dos constructores (uno para las facturas que se van a pagar con tarjeta y otro para los que no)
	//					 -> Un constructor solo, que no reciba nroTarjeta (voy a poder crear cualquier tipo de Factura) y despues, si lo necesito, una vez creada la Factura, completarle el atributo nroTarjeta.
	//Creo un constructor sobrecargado basandome en la primera opcion.
	
	
	//Pagos con tarjeta (debito o credito) 
	public Factura(Login empleado, GregorianCalendar fecha, Cliente cliente, FormaPago formaPago, String nroTarjeta) {
		super();
		this.empleado = empleado;
		this.fecha = fecha;
		this.cliente = cliente;	
		this.formaPago = formaPago;
		this.nroTarjeta = nroTarjeta;
		this.itemsFactura = new ArrayList<ItemFactura>();	
		this.abonada = false;
	}
	
	//Pagos con efectivo 
	public Factura(Login empleado, GregorianCalendar fecha, Cliente cliente, FormaPago formaPago) {
		super();		
		this.empleado = empleado;		
		this.fecha = fecha;	
		this.cliente = cliente;		
		this.formaPago = formaPago;
		this.itemsFactura = new ArrayList<ItemFactura>();	
		this.abonada = false;
	}
	
	//Constructor de prueba. 
	public Factura(Login empleado, GregorianCalendar fecha, Cliente cliente) {
		super();		
		this.empleado = empleado;		
		this.fecha = fecha;	
		this.cliente = cliente;
		this.itemsFactura = new ArrayList<ItemFactura>();	
		this.abonada = false;
	}			


	public int getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(int idFactura) { //Coincido. Protected. 
		this.idFactura = idFactura;
	}

	public Login getEmpleado() {						
		return empleado;
	}

	public void setEmpleado(Login empleado) {
		this.empleado = empleado;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItemsFactura() {
		return itemsFactura;
	}

	public void setItemFactura(List<ItemFactura> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}

	public double getTotal() {
		return total;
	}
	
	public void setTotal(){
		int i = 0;
		for (i = 0; i<itemsFactura.size(); i++){
			total = total + itemsFactura.get(i).getTotalIt();
		}
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public FormaPago getFormaPago() {			
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public String getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta) {			
		this.nroTarjeta = nroTarjeta;
	}

	public boolean isAbonada() {	
		return abonada;
	}

	public void setAbonada(boolean abonada) {
		this.abonada = abonada;
	}

	@Override
	public String toString() {
		return ("Factura Nº: " + idFactura + " |\nCliente: " + cliente +
				" |\nEmpleado:" + empleado +  "|\nFecha de emision: " +Funciones.traerFechaCorta(fecha) + "|\nForma de pago: " + formaPago+
				" |\nTarjeta: "+nroTarjeta+" |\nDetalle: "+itemsFactura+" |\nTotal: "+total+" |\nAbonada: "+abonada);					
	}

	public void agregarItem(int idItemFactura, String descripcion, int cantidad, double precio){												 
		itemsFactura.add(new ItemFactura(idItemFactura, this, descripcion, cantidad, precio));
	}  // end_public_agregarItem
		
		/* Otro comentario: Para mi, los items de la factura se tendrian que crear solos, algo como el setCuotas() que tenia Prestamo. Tenemos los
		 * datos para crearlos solos. Si la factura es de consumo base de estadia -> tenemos la habitacion, el dia que la reservo, cuanto costaba ese dia, etc.
		 * Si la factura es de consumo extra -> tenemos los items de consumo, etc.  
		 * Lo que habria que hacer seria un constructor para esas dos posibilidades de factura porque el "set_items_factura()" llamado desde
		 * el constructor va a ser distinto (va a estar sobrecargado). Aplicado en el sistema, tendriamos 2 funciones (botones que desencadenen una funcion)
		 * "CrearFacturaBase" y "CrearFacturaConsumoExtra". Si no se entiende lo charlamos perfectamente. */		
	
} // end_class_Factura