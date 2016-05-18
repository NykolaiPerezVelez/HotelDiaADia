package datos;

public class ItemTicketConsumo {

	
	private long idItemTicketConsumo;
	private int cantidad;
	private float totalItem;
	
	//Relacione
	private TicketConsumo ticketConsumo;
	private Producto producto;
	
	//Constructores
	public ItemTicketConsumo(int cantidad, float totalItem, TicketConsumo ticketConsumo, Producto producto) {
		
		this.cantidad = cantidad;
		this.totalItem = totalItem;
		this.ticketConsumo = ticketConsumo;
		this.producto = producto;
	}
	
	public ItemTicketConsumo(){}
	
	//Sets y gets

	public long getIdItemTicketConsumo() {
		return idItemTicketConsumo;
	}

	protected void setIdItemTicketConsumo(long idItemTicketConsumo) {
		this.idItemTicketConsumo = idItemTicketConsumo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(float totalItem) {
		this.totalItem = totalItem;
	}

	public TicketConsumo getTicketConsumo() {
		return ticketConsumo;
	}

	public void setTicketConsumo(TicketConsumo ticketConsumo) {
		this.ticketConsumo = ticketConsumo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
	
	
}
