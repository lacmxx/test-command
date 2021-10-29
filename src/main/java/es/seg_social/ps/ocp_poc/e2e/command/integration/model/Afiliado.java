package es.seg_social.ps.ocp_poc.e2e.command.integration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AFILIADO")
public class Afiliado {
	
	@Id
	private Integer codAfiliado;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private String direccion;
	private String telefono;
	private String email;
	private Integer idProvincia;
	private String provincia;

	public Afiliado() {
	}

	public Afiliado(Integer codAfiliado, String nombre, String apellido1, String apellido2, String dni, String direccion, String telefono, String email, Integer idProvincia, String provincia) {
		this.codAfiliado = codAfiliado;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.idProvincia = idProvincia;
		this.provincia = provincia;
	}

	public Integer getCodAfiliado() {
		return codAfiliado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public String getProvincia() {
		return provincia;
	}

	@Override
	public String toString() {
		return "Afiliado{" +
				"codAfiliado=" + codAfiliado +
				", nombre='" + nombre + '\'' +
				", apellido1='" + apellido1 + '\'' +
				", apellido2='" + apellido2 + '\'' +
				", dni='" + dni + '\'' +
				", direccion='" + direccion + '\'' +
				", telefono='" + telefono + '\'' +
				", email='" + email + '\'' +
				", idProvincia=" + idProvincia +
				", provincia='" + provincia + '\'' +
				'}';
	}
}
