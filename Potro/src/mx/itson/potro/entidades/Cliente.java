package mx.itson.potro.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

/**
 * Representa el cliente que coloca la orden.
 * @author Mariana Garcia
 *
 */
@Entity
@Table(name="cliente")
public class Cliente {
	
	private int id;
	private Contacto contacto;
	private String nombre;
	private String direccion;
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
	 * @return El valor de contacto.
	 */
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idContacto")
	public Contacto getContacto() {
		return contacto;
	}
	/**
	 * @param Asigna el valor de contacto a contacto.
	 */
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
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
	 * @return El valor de direccion.
	 */
	@Basic
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param Asigna el valor de direccion a direccion.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> obtenerTodos(){
		
		Session sesion = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			clientes = (List<Cliente>) sesion.createQuery("from Cliente").list();
			sesion.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return clientes;
		
		
	}
	
	public String[][] datos()
	{ 	Cliente cliente = new Cliente();
		int filas = cliente.obtenerTodos().size();
		String[][] data = new String[filas][6];
		
	
		int i = 0;
			for(Cliente c : cliente.obtenerTodos())
			{
				data[i][0] = String.valueOf(c.getId());
				data[i][1] = c.getNombre();
				data[i][2] = c.getDireccion();

				i++;
			}
	
		return data;
	}
	

}
