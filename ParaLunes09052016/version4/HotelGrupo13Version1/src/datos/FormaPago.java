package datos;

import java.util.Set;

public class FormaPago {

	
	private long idFormaPago;
	private String nombreForma;
	private String tarjeta;
	
	//Relaciones
	private Set<Factura> facturas;

	public FormaPago(String nombreForma, String tarjeta) {
		super();
		this.nombreForma = nombreForma;
		this.tarjeta = tarjeta;
	}
	
	public FormaPago (){}

	
	//Gets and sets
	public long getIdFormaPago() {
		return idFormaPago;
	}

	protected void setIdFormaPago(long idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public String getNombreForma() {
		return nombreForma;
	}

	public void setNombreForma(String nombreForma) {
		this.nombreForma = nombreForma;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
	
}
