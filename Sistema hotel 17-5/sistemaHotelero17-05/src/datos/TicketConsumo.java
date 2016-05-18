package datos;

public class TicketConsumo {	//Miren despues el toString() el servicio se da a conocer igual... 	
	private int idTicketConsumo;		
	private Producto producto; 
	private Estadia estadia;
	private int cantidad;	
	private float total;
	private boolean facturado;															 		 		
	
	public TicketConsumo(){} // CONSTRUCTOR HIBERNATE	

	public TicketConsumo(Producto producto, Estadia estadia, int cantidad, float total) {		 
		super();
		this.producto = producto;												
		this.estadia = estadia;						
		this.cantidad = cantidad;			
		this.total = total;		
		this.facturado = false;					
	}

	public int getIdTicketConsumo() {						
		return idTicketConsumo;
	}

	protected void setIdTicketConsumo(int idTicketConsumo) { //Coincido. Protected 
		this.idTicketConsumo = idTicketConsumo;
	}

	public Producto getProducto() {
		return producto;	
	}

	public void setProducto(Producto producto) {
		this.producto = producto;	
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public boolean isFacturado() {
		return facturado;
	}

	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}
	
	public String toString(){
		return ("idTicketConsumo: "+idTicketConsumo+" || Servicio: "+producto.getServicio()+" || Producto: "+producto+ " || Cantidad: "+cantidad+" || Total: "+total+" || Facturado: "+facturado);
	}

} // end_class_TicketConsumo