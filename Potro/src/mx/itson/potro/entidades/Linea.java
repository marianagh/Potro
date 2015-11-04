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
 * Representa la linea de produccion.
 * @author Mariana Garcia
 *
 */
@Entity
@Table(name="linea")
public class Linea {
	
	private int id;
	private String nombre;
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
	

	@SuppressWarnings("unchecked")
	public List<Linea> obtenerTodos(){
		
		Session sesion = null;
		List<Linea> lineas = new ArrayList<Linea>();
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			lineas = (List<Linea>) sesion.createQuery("from Linea").list();
			sesion.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return lineas;
		
		
	}
	
	public String[][] datos()
	{ 	Linea linea = new Linea();
		int filas = linea.obtenerTodos().size();
		String[][] data = new String[filas][6];
		
	
		int i = 0;
			for(Linea l: linea.obtenerTodos())
			{
				data[i][0] = String.valueOf(l.getId());
				data[i][1] = l.getNombre();

				i++;
			}
	
		return data;
	}

}
