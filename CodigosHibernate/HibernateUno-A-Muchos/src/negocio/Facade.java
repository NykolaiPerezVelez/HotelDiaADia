package negocio;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
public class Facade {
	
	
public PrestamoABM getPrestamoABM(){
return new PrestamoABM();
}
public ClienteABM getClienteABM(){
return new ClienteABM();
}
public CuotaABM getCuotaABM(){
return new CuotaABM();
}
}