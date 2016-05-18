package Vistas;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import datos.Cliente;
import datos.Cuota;
import funciones.Funciones;
// Vista por consola. Recibe entrada por teclado
// y muestra cliente
public class VistaConsola {
	
	
public String entradaTeclado(){
mostrarEncabezado();
Scanner scan= new Scanner(System.in);
System.out.print("Ingrese DNI (o salir): ");
String dni= scan.nextLine();
return dni;
}

public void mostrarEncabezado(){
limpiarConsola();
System.out.println("Sistema Francés");
System.out.println("---------------");
System.out.println();
}

public void despedirse(){
System.out.println("\n\nAdiós!");
}

public void errorClienteNoExiste(){
mostrarEncabezado();
System.out.println("Error: El DNI ingresado no existe.");
esperarEnter();
}
public void mostrarCliente(Cliente cliente){
// Muestra el cliente recibido y sus cuotas a vencer
mostrarEncabezado();
System.out.println("Cliente: "+cliente.getApellido()
+", "+cliente.getNombre());
System.out.println("DNI : "+cliente.getDni());
System.out.println("ID : "+cliente.getIdCliente());


esperarEnter();
}
public void esperarEnter(){
System.out.println("\n\nPresione Enter para continuar...");
try {
System.in.read();
} catch (IOException e) {
e.printStackTrace();
}
}
public void limpiarConsola()
{
for(int k=0;k<4;k++)
System.out.println();
}
}