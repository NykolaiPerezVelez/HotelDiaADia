package datos;

public class ItemFactura {

	private int idItemFactura;	
	private int nroItem;																		
	private Factura factura; 		
	private String descripcion;
	private int cantidad;
	private double precio;
	private double totalIt;
	
	public ItemFactura(){} // CONSTRUCTOR HIBERNATE
		
	public ItemFactura(int nroItem, Factura factura, String descripcion, int cantidad, double precio) {
		super();			
		this.nroItem = nroItem;
		this.factura = factura;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.totalIt = (precio * cantidad); 
	}								
	
	public int getIdItemFactura() {
		return idItemFactura;
	}

	protected void setIdItemFactura(int idItemFactura) { //Coincido. Protected. -> Perdonen si hincho con esto. Es para que se nos grabe el "PROTECTED setId()"
		this.idItemFactura = idItemFactura;					
	}

	public int getnroItem() {			
		return nroItem;			
	}

	public void setNroItem(int nroItem) {
		this.nroItem = nroItem;	
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTotalIt() {
		return totalIt;
	}

	public void setTotalIt(double totalIt) {
		this.totalIt = totalIt;				
	}
	
	public String toString(){
		return "\nIdItemFactura: "+idItemFactura+" NroItem: "+nroItem+" Descripcion: "+descripcion+" Cantidad: "+cantidad+" Precio: "+precio+" TotalItem: "+totalIt;
	}
		
} // end_class_ItemFactura