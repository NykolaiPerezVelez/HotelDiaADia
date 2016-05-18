package datos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import funciones.Funciones;

public class Cuota  {		
	
	private int idCuota;
	private int nroCuota;
	private GregorianCalendar fechaVencimiento;
	private double saldoPendiente;
	private double amortizacion;
	private double interesCuota;	
	private double cuota;
	private double deuda;							
	private boolean cancelada;
	private GregorianCalendar fechaDePago;
	private double punitorios;
	private Prestamo prestamo; 			
			
	public Cuota(){}			
	
	public Cuota(int nroCuota, GregorianCalendar fecha, double saldoPendiente, double amortizacion, double interesCuota, Prestamo prestamo) {
			this.nroCuota = nroCuota;
		    this.setFechaVencimiento1(fecha);
			this.saldoPendiente = saldoPendiente;
			this.amortizacion = amortizacion;
			this.interesCuota = interesCuota; 
			this.setCuota();
			this.setDeuda();		 
			this.cancelada = false;
			this.fechaDePago = null;				
			this.punitorios = 0;	
			this.prestamo = prestamo;
	}
	
	public int getIdCuota(){
		return idCuota;
	}	
	
	protected void setIdCuota(int idCuota){
		this.idCuota = idCuota; 
	}
	
	public int getNroCuota(){
		return nroCuota;
	}
	
	public void setNroCuota(int nroCuota){
		this.nroCuota = nroCuota;
	}	
	
	public GregorianCalendar getFechaVencimiento(){
		return fechaVencimiento;
	}	
	
	public void setFechaVencimiento1(GregorianCalendar fecha) { //    Inicio prestamo:  29/11 (10 para Java)/2015
		int diaInicio = fecha.get(Calendar.DAY_OF_MONTH); //29
		int mesInicio = fecha.get(Calendar.MONTH); //10
		int anioInicio = fecha.get(Calendar.YEAR); //2015
		int mesVencimiento = mesInicio + nroCuota; // 10 + 1 = 11, , // 10 + 2 = 12
		int anioVencimiento = anioInicio; //2015 //2015 
		if (mesVencimiento > 11){ //NO //SI
			mesVencimiento = (12 - mesVencimiento) * -1; //12 - 12 = 0
			anioVencimiento = anioVencimiento + 1; //2015 + 1 = 2016
		} 
		GregorianCalendar fechaDeVencimiento = new GregorianCalendar(anioVencimiento, mesVencimiento, diaInicio); //(29, 11, 2015), (29, 0, 2016)
		if (Funciones.esHabil(fechaDeVencimiento) == false){
			fechaDeVencimiento = Funciones.traerPrimerDiaHabil(fechaDeVencimiento); 
		}
		this.fechaVencimiento = fechaDeVencimiento;  //(29, 11, 2015) //(29,0,2016)
	}
	
	public void setFechaVencimiento(GregorianCalendar fechaVencimiento){
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public double getInteresCuota() {
		return interesCuota;
	}
 
	public void setInteresCuota(double interesCuota) {
		this.interesCuota = interesCuota; 
	}

	public double getCuota() {
		return cuota;	
	}

	public void setCuota() {
		this.cuota = amortizacion + interesCuota;
	}
	
	public void setCuota(double cuota){
		this.cuota = cuota;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda() {
		this.deuda = saldoPendiente - amortizacion;
	}
	
	public void setDeuda(double deuda) {
		this.deuda = deuda;	
	}	
	
	public boolean getCancelada(){
		return cancelada;
	}
	
	public void setCancelada(boolean cancelada){
		this.cancelada = cancelada;
	}
	
	public GregorianCalendar getFechaDePago(){
		return fechaDePago;	
	}
	
	public Prestamo getPrestamo(){
		return prestamo;
	}
	
	public void setPrestamo(Prestamo prestamo){
		this.prestamo = prestamo; 
	}
	
	public void setFechaDePago(GregorianCalendar fechaDePago){
		this.fechaDePago = fechaDePago;
		setCancelada(true);
	}
	
	public double getPunitorios(){
		return punitorios;
	}
	
	public void setPunitorios(double punitorios){
		this.punitorios = punitorios;
	}
		
	@Override			
	public String toString(){
		return ("\nNro Cuota: "+nroCuota+" || F.Vto: "+Funciones.traerFechaCorta(fechaVencimiento)+" || Saldo pendiente: "+Funciones.aproximar2Decimal(saldoPendiente)+" || Amortizacion: "+Funciones.aproximar2Decimal(amortizacion)+" || Interes: "+Funciones.aproximar2Decimal(interesCuota)+"|| Cuota: "+Funciones.aproximar2Decimal(cuota)+" || Deuda: "+Funciones.aproximar2Decimal(deuda)+" || Estado: "+cancelada+" || Fecha pago: "+fechaDePago);
	}
	
} 