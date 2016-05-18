package datos;

import java.util.GregorianCalendar;
import java.util.Set;

public class Estadia {
	
	private long idEstadia;
	private String activa;
	private GregorianCalendar diaCheckIn;
	private GregorianCalendar diaCheckOut;
	private int cantidadAdultos;
	private int cantidadNinios;
	
	
	//Relaciones
	private TipoEstadiaInactiva tipoEstadiaInactiva;
	private Set<TicketConsumo> ticketConsumos;
	private Habitacion habitacion;
	private Login login;
	private Cliente cliente;
	
	//Constructores
	public Estadia(String activa, GregorianCalendar diaCheckIn, GregorianCalendar diaCheckOut, int cantidadAdultos,
			int cantidadNinios, TipoEstadiaInactiva tipoEstadiaInactiva, Habitacion habitacion, Login login,
			Cliente cliente) {
		super();
		this.activa = activa;
		this.diaCheckIn = diaCheckIn;
		this.diaCheckOut = diaCheckOut;
		this.cantidadAdultos = cantidadAdultos;
		this.cantidadNinios = cantidadNinios;
		this.tipoEstadiaInactiva = tipoEstadiaInactiva;
		this.habitacion = habitacion;
		this.login = login;
		this.cliente = cliente;
	}
	
	public Estadia(){}
	
	//gets and Sets

	public long getIdEstadia() {
		return idEstadia;
	}

	protected void setIdEstadia(long idEstadia) {
		this.idEstadia = idEstadia;
	}

	public String getActiva() {
		return activa;
	}

	public void setActiva(String activa) {
		this.activa = activa;
	}

	public GregorianCalendar getDiaCheckIn() {
		return diaCheckIn;
	}

	public void setDiaCheckIn(GregorianCalendar diaCheckIn) {
		this.diaCheckIn = diaCheckIn;
	}

	public GregorianCalendar getDiaCheckOut() {
		return diaCheckOut;
	}

	public void setDiaCheckOut(GregorianCalendar diaCheckOut) {
		this.diaCheckOut = diaCheckOut;
	}

	public int getCantidadAdultos() {
		return cantidadAdultos;
	}

	public void setCantidadAdultos(int cantidadAdultos) {
		this.cantidadAdultos = cantidadAdultos;
	}

	public int getCantidadNinios() {
		return cantidadNinios;
	}

	public void setCantidadNinios(int cantidadNinios) {
		this.cantidadNinios = cantidadNinios;
	}

	public TipoEstadiaInactiva getTipoEstadiaInactiva() {
		return tipoEstadiaInactiva;
	}

	public void setTipoEstadiaInactiva(TipoEstadiaInactiva tipoEstadiaInactiva) {
		this.tipoEstadiaInactiva = tipoEstadiaInactiva;
	}

	public Set<TicketConsumo> getTicketConsumos() {
		return ticketConsumos;
	}

	public void setTicketConsumos(Set<TicketConsumo> ticketConsumos) {
		this.ticketConsumos = ticketConsumos;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	

}
