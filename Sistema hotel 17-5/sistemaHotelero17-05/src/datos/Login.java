package datos;

public class Login {

	private int idLogin;	 
	private String usuario;
	private String clave;
	private String palabraClave; //¿A que hace referencia "PalabraClave"? 					
	private Empleado empleado;
	private Permiso permiso;	
	private int cantHabAsignadas;
	
	public Login(){} // CONSTRUCTOR HIBERNATE			

	public Login(String usuario, String clave, String palabraClave, Empleado empleado, Permiso permiso) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.palabraClave = palabraClave;
		this.empleado = empleado;
		this.permiso = permiso;
		//Mano de nico u.u
		empleado.setLogin(this);
		this.cantHabAsignadas = 0;
	}

	public int getIdLogin() {				
		return idLogin;
	}

	protected void setIdLogin(int idLogin) { //Coincido. Protected. 
		this.idLogin = idLogin;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPalabraClave() {
		return palabraClave;
	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
	
	
	
	public String toString(){
		return ("idLogin: "+idLogin+" || Usuario: "+usuario+" || Empleado: "+empleado);
	}

	public int getCantHabAsignadas() {
		return cantHabAsignadas;
	}

	public void setCantHabAsignadas(int cantHabAsignadas) {
		this.cantHabAsignadas = cantHabAsignadas;
	}
	
} // end_class_Login