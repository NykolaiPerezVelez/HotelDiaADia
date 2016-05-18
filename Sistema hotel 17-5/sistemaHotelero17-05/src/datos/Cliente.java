package datos;

import java.util.List;
import java.util.ArrayList;

public class Cliente {
	private int idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private String telefono;	
	private List<Factura> cuentaCorriente = new ArrayList<Factura>(); //Yo acá simplemente declararia "cuenta corriente" y luego lo inicializaria asi en el constructor. Pero bueno. Si funciona asi, no me parece tan raro igual. 
	private boolean baja;	

	public Cliente() {} // CONSTRUCTOR HIBERNATE
	
	public Cliente(String apellido, String nombre, int dni, String telefono) {
		super();
		this.apellido = apellido;	
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.baja = false;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) { //Coincido. PROTECTED. 
		this.idCliente = idCliente;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Factura> getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(List<Factura> cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public boolean isBaja() {	
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ ", telefono=" + telefono + ", baja=" + baja + "]";
	}
	
} // end_class_Cliente