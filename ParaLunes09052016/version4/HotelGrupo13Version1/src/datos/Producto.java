package datos;

import java.util.Set;

public class Producto {
	
	private long idProducto;
	private float precio;
	private String nombre;
	private String descripcion;
	
	
	//Relaciones
	private Servicio servicio;
	private Set<ItemTicketConsumo> itemTicketConsumos;
	
	//Constructores
	public Producto(float precio, String nombre, String descripcion, Servicio servicio,
			Set<ItemTicketConsumo> itemTicketConsumos) {
		this.precio = precio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.servicio = servicio;
		this.itemTicketConsumos = itemTicketConsumos;
	}
	
	public Producto(){}
	
	
	//Gets y ets

	public long getIdProducto() {
		return idProducto;
	}

	protected void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Set<ItemTicketConsumo> getItemTicketConsumos() {
		return itemTicketConsumos;
	}

	public void setItemTicketConsumos(Set<ItemTicketConsumo> itemTicketConsumos) {
		this.itemTicketConsumos = itemTicketConsumos;
	}
	
	
	
	

}
