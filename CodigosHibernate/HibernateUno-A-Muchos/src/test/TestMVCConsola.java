package test;
import controladores.ControladorMostrarClienteConsola;
public class TestMVCConsola {
public static void main(String[] args) throws Exception {
// Instanciamos el controlador e iniciamos el main loop
ControladorMostrarClienteConsola controlador=
new ControladorMostrarClienteConsola();
boolean salir=false;
while(!salir){
salir=controlador.esperaryProcesarEvento();
}
}
}