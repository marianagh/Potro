package mx.itson.potro.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

/**
 * Representa el contacto del cliente.
 * @author Mariana Garcia
 *
 */
@Entity
@Table(name="contacto")
public class Contacto {
	
	private int id;
	private String nombre;
	private String telefono;
	private String correo;
	/**
	 * @return El valor de id.
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	/**
	 * @param Asigna el valor de id a id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return El valor de nombre.
	 */
	@Basic
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param Asigna el valor de nombre a nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return El valor de telefono.
	 */
	@Basic
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param Asigna el valor de telefono a telefono.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return El valor de correo.
	 */
	@Basic
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param Asigna el valor de correo a correo.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Contacto> obtenerTodos(){
		
		Session sesion = null;
		List<Contacto> contactos = new ArrayList<Contacto>();
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			contactos = (List<Contacto>) sesion.createQuery("from Contacto").list();
			sesion.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return contactos;
		
		
	}

	
	public String[][] datos()
	{ 	Contacto contacto = new Contacto();
		int filas = contacto.obtenerTodos().size();
		String[][] data = new String[filas][6];
		
	
		int i = 0;
			for(Contacto c : contacto.obtenerTodos())
			{
				data[i][0] = String.valueOf(c.getId());
				data[i][1] = c.getNombre();
				data[i][2] = c.getTelefono();
				i++;
			}
	
		return data;
	}
}
