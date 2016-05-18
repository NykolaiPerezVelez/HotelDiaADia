package datos;

public class FormaPago {

	private int idFormaPago;
	private String nombreForma;
	
	public FormaPago (){} // CONSTRUCTOR HIBERNATE
	
	public FormaPago(int idFormaPago, String nombreForma) {
		super();
		this.nombreForma = nombreForma;
	}

	public int getIdFormaPago() {
		return idFormaPago;
	}

	protected void setIdFormaPago(int idFormaPago) { //Coincido. Protected								
		this.idFormaPago = idFormaPago;				
	}

	public String getNombreForma() {
		return nombreForma;
	}

	public void setNombreForma(String nombreForma) {
		this.nombreForma = nombreForma;
	}

	@Override
	public String toString() {
		return nombreForma;
	}
	
} // end_class_FormaPago