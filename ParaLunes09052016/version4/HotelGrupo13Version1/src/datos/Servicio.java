package datos;

import java.util.Set;

public class Servicio {
	
	private long idServicio;
	private String nombreServicio;
	private String descripcionServicio;
	
	
	private Set<Producto> productos;


	public Servicio(String nombreServicio, String descripcionServicio) {
		this.nombreServicio = nombreServicio;
		this.descripcionServicio = descripcionServicio;
	}
	
	public Servicio(){}


	
	public long getIdServicio() {
		return idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	protected void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	
	

}
