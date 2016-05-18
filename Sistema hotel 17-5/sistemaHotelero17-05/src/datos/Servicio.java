package datos;

import java.util.ArrayList;

public class Servicio {
	
	private int idServicio;
	private String nombreServicio;
	private String descripcionServicio;
	private ArrayList<Producto> productos; //Todo puede tratarse como un producto. Servicio Lavanderia -> LAVADO PANTALON $15. Se puede tratar, no quiere decir que EXACTAMENTE lo sea, perfectamente como un producto. 
	
	public Servicio(){} // CONSTRUCTOR HIBERNATE

	public Servicio(String nombreServicio, String descripcionServicio) {
		super();
		this.nombreServicio = nombreServicio;
		this.descripcionServicio = descripcionServicio;
		this.productos = new ArrayList<Producto>();	
	}
	
	public void agregarProducto(String nombre, String descripcion, float precio){
		productos.add(new Producto(nombre, descripcion, precio, this));				
	}
	
	public Producto traerProducto(String nombre){ //Lo traigo por nombre porque no estamos trabajando con id's en memoria. 
		int i = 0;	
		int indiceEncontrado = -1; 
		for (i= 0; i<productos.size(); i++){
			if (productos.get(i).getNombre().equalsIgnoreCase(nombre)){				
				indiceEncontrado = i;
				i = productos.size();			
			}				
		}
		return productos.get(indiceEncontrado); 
	}

	public int getIdServicio() {
		return idServicio;
	}

	protected void setIdServicio(int idServicio) { //Coincido. Protected. 
		this.idServicio = idServicio;
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

	public ArrayList<Producto> getProductos(){
		return productos;
	}
	
	public void setProductos (ArrayList<Producto> productos){
		this.productos = productos; 
	}

	@Override
	public String toString() {			
		return ("ID: " + idServicio + " Servicio: " + nombreServicio + " Descripcion: "+ descripcionServicio);			
	}
	
	public String toStringConProductos(){
		return ("ID: " + idServicio + " Servicio: " + nombreServicio + " Descripcion: "+ descripcionServicio+" Productos: "+productos);			
	}	

} // end_class_Servicio