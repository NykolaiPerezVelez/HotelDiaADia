package datos;

import java.util.Set;

public class Login {

	
	private long idLogin;	
	private String nombreUsuario;
	private String contrasenia;
	private int numPermiso;
	
	//Relaciones
	private Set<Factura> facturas;
	private Set<Estadia> estadias;
	private Set<TicketConsumo> ticketConsumos;
	private Empleado empleado;
	private Set<Habitacion> habitaciones;
	private Set<ParteReparacion> parteReparaciones;
	
	
	
	//Constructures
	public Login(String nombreUsuario, String contrasenia, int numPermiso) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.numPermiso = numPermiso;
	}
	
	public Login(){}

	//Gets y Sets
	public long getIdLogin() {
		return idLogin;
	}

	protected void setIdLogin(long idLogin) {
		this.idLogin = idLogin;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getNumPermiso() {
		return numPermiso;
	}

	public void setNumPermiso(int numPermiso) {
		this.numPermiso = numPermiso;
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

	public Set<TicketConsumo> getTicketConsumos() {
		return ticketConsumos;
	}

	public void setTicketConsumos(Set<TicketConsumo> ticketConsumos) {
		this.ticketConsumos = ticketConsumos;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Set<ParteReparacion> getParteReparaciones() {
		return parteReparaciones;
	}

	public void setParteReparaciones(Set<ParteReparacion> parteReparaciones) {
		this.parteReparaciones = parteReparaciones;
	}
	
	
}
