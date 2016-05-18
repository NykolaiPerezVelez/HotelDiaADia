package datos;

import java.util.Set;

public class Factura {
	
	private long idFactura;
	private float subTotal;
	private float total;
	
	
	//Relaciones
	private Cliente cliente;
	private Set<ItemFactura> itemFacturas;
	private FormaPago formaPago;
	private Login login;
	
	//Constructores
	public Factura(float subTotal, float total, Cliente cliente, FormaPago formaPago, Login login) {
		super();
		this.subTotal = subTotal;
		this.total = total;
		this.cliente = cliente;
		this.formaPago = formaPago;
		this.login = login;
	}
	
	public Factura(){}
	
	//Set y gets

	public long getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ItemFactura> getItemFacturas() {
		return itemFacturas;
	}

	public void setItemFacturas(Set<ItemFactura> itemFacturas) {
		this.itemFacturas = itemFacturas;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaDePago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	

}
