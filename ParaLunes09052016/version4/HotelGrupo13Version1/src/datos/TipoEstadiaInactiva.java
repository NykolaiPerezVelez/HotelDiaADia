package datos;

import java.util.Set;

public class TipoEstadiaInactiva {
	
	private long idTipoEstadiaInactiva;
	private String nombreTipo;
	private String descripcionTipo;
	
	//Relaciones
	private Set<Estadia> estadias;

	public TipoEstadiaInactiva(String nombreTipo, String descripcionTipo, Set<Estadia> estadias) {
		
		this.nombreTipo = nombreTipo;
		this.descripcionTipo = descripcionTipo;
		this.estadias = estadias;
	}
	
	public TipoEstadiaInactiva(){}
	
	//Gets y sets

	public long getIdTipoEstadiaInactiva() {
		return idTipoEstadiaInactiva;
	}

	protected void setIdTipoEstadiaInactiva(long idTipoEstadiaInactiva) {
		this.idTipoEstadiaInactiva = idTipoEstadiaInactiva;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public String getDescripcionTipo() {
		return descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

	public Set<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(Set<Estadia> estadias) {
		this.estadias = estadias;
	}
	
	
	

}
