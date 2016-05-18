package datos;

import java.util.Set;

public class Cliente {

	
	private long idCliente;
	private float totalGastadoEnHotel;
	private int cantidadEstadias;
	private String apellido;
	private String nombre;
	private int dni;
	private String tel;
	
	//Realacione

	private Set<Factura> facturas;
	private Set<Estadia> estadias;

	
	//COnstructores
	public Cliente(float totalGastadoEnHotel, int cantidadEstadias) {
		this.totalGastadoEnHotel = totalGastadoEnHotel;
		this.cantidadEstadias = cantidadEstadias;

	}
	
	
	
	
	public Cliente(float totalGastadoEnHotel, int cantidadEstadias, String apellido, String nombre, int dni,
			String tel) {
		this.totalGastadoEnHotel = totalGastadoEnHotel;
		this.cantidadEstadias = cantidadEstadias;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.tel = tel;
	}




	public Cliente(){}


	public long getIdCliente() {
		return idCliente;
	}


	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}


	public float getTotalGastadoEnHotel() {
		return totalGastadoEnHotel;
	}


	public void setTotalGastadoEnHotel(float totalGastadoEnHotel) {
		this.totalGastadoEnHotel = totalGastadoEnHotel;
	}


	public int getCantidadEstadias() {
		return cantidadEstadias;
	}


	public void setCantidadEstadias(int cantidadEstadias) {
		this.cantidadEstadias = cantidadEstadias;
	}



	public Set<Factura> getFacturas() {
		return facturas;
	}


	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}


	public Set<Estadia> getEstadias() {
		return estadias;
	}


	public void setEstadias(Set<Estadia> estadias) {
		this.estadias = estadias;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public int getDni() {
		return dni;
	}




	public void setDni(int dni) {
		this.dni = dni;
	}




	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	
	
}
