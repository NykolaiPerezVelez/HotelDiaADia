package datos;

public class ItemFactura {

	
	private long idItemFactura;
	private String descripcion;
	private int cantidad;
	private float totalIt;
	
	
	//Relaciones
	private Factura factura;


	public ItemFactura(String descripcion, int cantidad, float totalIt, Factura factura) {
		super();
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.totalIt = totalIt;
		this.factura = factura;
	}
	
	public ItemFactura(){}

	
	//gets and sets
	public long getIdItemFactura() {
		return idItemFactura;
	}

	protected void setIdItemFactura(long idItemFactura) {
		this.idItemFactura = idItemFactura;
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

	public float getTotalIt() {
		return totalIt;
	}

	public void setTotalIt(float totalIt) {
		this.totalIt = totalIt;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
}
