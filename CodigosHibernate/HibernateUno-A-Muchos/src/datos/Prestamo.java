package datos;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import datos.Cuota;
import funciones.Funciones;

public class Prestamo {
	private long idPrestamo;
	private GregorianCalendar fecha;
	private double monto;
	private double interes;	
	private int cantCuotas;
	private boolean cancelado;
	private Set<Cuota> cuotas;
	private Cliente cliente;		
	
	public Prestamo(){}
	
	public Prestamo(GregorianCalendar fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
		super();
		this.fecha = fecha;	
		this.monto = monto;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.cancelado = false;
		this.cliente = cliente;
		this.cuotas = new HashSet<Cuota>();
		this.setCuotas();	
	}
	

	public void setCuotas(){  	
		double saldoPendiente = monto; 
		double amortizacion = 0;		
		double interesCuota = 0;	
		int n = cantCuotas;	
		int i = 0;  	
		for (i= 0; i<cantCuotas; i++){
					amortizacion = (saldoPendiente * (interes/100))/((Math.pow((1+(interes/100)), n))-1); //Para la amortizacion necesito el INTERES y CANTCUOTAS -> Atributos de prestamo -> Por eso hacemos la cuenta en prestamo
					interesCuota = (saldoPendiente * (interes/100));
					cuotas.add(new Cuota(i+1, fecha, saldoPendiente, amortizacion, interesCuota, this));
					n = n-1;
					saldoPendiente = (saldoPendiente - amortizacion); 
		 }
		}

	public long getIdPrestamo() {	
		return idPrestamo;
	}
	
	protected void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	
	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	public double getInteres() {
		return interes;
	}
	
	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	public int getCantCuotas() {
		return cantCuotas;
	}
	
	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}
	
	public boolean getCancelado(){	
		return cancelado;
	}
	
	public void setCancelado(boolean cancelado){
		this.cancelado = cancelado;
	}
	
	public Set<Cuota> getCuotas() {
		return cuotas;
	}	
	
	public void setCuotas(Set<Cuota> cuotas) {
		this.cuotas = cuotas;
	}	
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;	
	}
	
	public String toString(){	
		String prestamo= "Prestamo: $ "+monto+"\nFecha: "+Funciones.traerFechaCorta(fecha)+"\nInteres: "+interes+"\nCant.de Cuotas: "+cantCuotas+"\n Cancelado: "+cancelado;
		return prestamo;		
	}
	
	public String toStringConCuotas(){	
		String prestamo= "Prestamo: $ "+monto+"\nFecha: "+Funciones.traerFechaCorta(fecha)+"\nInteres: "+interes+"\nCant.de Cuotas: "+cantCuotas+"\n Cancelado: "+cancelado+"\n Cuotas: "+cuotas;
		return prestamo;				
	}
	
}