package datos;

	public class Producto {
		
		private int idProducto;
		private String nombre;
		private String descripcion;	
		private float precio;
		private Servicio servicio;
		
		//Constructores	
		
		public Producto(){}	
		
		public Producto(String nombre, String descripcion, float precio, Servicio servicio) {
			super();
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.precio = precio;	
			this.servicio = servicio;			
		}
					
		
		//Gets y sets

		public int getIdProducto() {
			return idProducto;
		}

		protected void setIdProducto(int idProducto) {
			this.idProducto = idProducto;
		}

		public float getPrecio() {
			return precio;
		}

		public void setPrecio(float precio) {
			this.precio = precio;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;	
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Servicio getServicio() {
			return servicio;
		}

		public void setServicio(Servicio servicio) {
			this.servicio = servicio;
		}		
		
		@Override	
		public String toString(){	
			return ("idProducto: "+idProducto+" || Nombre: "+nombre+" || Descripcion: "+descripcion+" || Precio: "+precio+" || Servicio: "+servicio);
		}	
	}
	// end_class_Producto 
