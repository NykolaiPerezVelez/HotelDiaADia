package controladores;
import java.util.GregorianCalendar;
import java.util.List;
import datos.Cliente;
import datos.Cuota;

import negocio.Facade;
import Vistas.VistaConsola;
public class ControladorMostrarClienteConsola {
	
	
// Vista y modelo. También podrían inyectarse desde afuera
VistaConsola vista=new VistaConsola();
Facade facade=new Facade();
// recibimos un dni desde la vista
public boolean esperaryProcesarEvento() throws Exception{
// mostramos el cliente seleccionado o un error
boolean salir=false;
String strdni=vista.entradaTeclado();
if(strdni.compareTo("salir")==0){
vista.despedirse();
salir=true;
} else {
int dni=Integer.parseInt(strdni);
Cliente cliente=facade.getClienteABM().traerCliente(dni);
if(cliente!=null){
vista.mostrarCliente(cliente);
} else
vista.errorClienteNoExiste();
} return salir;
}
}