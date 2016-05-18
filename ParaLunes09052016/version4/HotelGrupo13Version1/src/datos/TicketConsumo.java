package datos;

import java.util.Set;

public class TicketConsumo {

	
	private long idTicketConsumo;
	private float total;
	
	//Relacion
	private Set<ItemTicketConsumo> itemTickConsumos;
	private Estadia estadia;
	private Login login;
	
	
	
	public TicketConsumo(float total, Set<ItemTicketConsumo> itemTickConsumos, Estadia estadia, Login login) {
		this.total = total;
		this.itemTickConsumos = itemTickConsumos;
		this.estadia = estadia;
		this.login = login;
	}
	
	public TicketConsumo(){}

	public long getIdTicketConsumo() {
		return idTicketConsumo;
	}

	protected void setIdTicketConsumo(long idTicketConsumo) {
		this.idTicketConsumo = idTicketConsumo;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Set<ItemTicketConsumo> getItemTickConsumos() {
		return itemTickConsumos;
	}

	public void setItemTickConsumos(Set<ItemTicketConsumo> itemTickConsumos) {
		this.itemTickConsumos = itemTickConsumos;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
	
}
