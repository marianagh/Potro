package mx.itson.potro.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Session;

/**
 * Representa la orden que se recibe.
 * @author Mariana Garcia
 *
 */
@Entity
public class Orden {
	
	private int id;
	private Linea linea;
	private Cliente cliente;
	private String especificacion;
	private Date fechaAsignacion;
	private Date fechaEntrega;
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
	 * @return El valor de lineaProduccion.
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idLinea")
	public Linea getLineaProduccion() {
		return linea;
	}
	/**
	 * @param Asigna el valor de lineaProduccion a lineaProduccion.
	 */
	public void setLineaProduccion(Linea lineaProduccion) {
		this.linea = lineaProduccion;
	}
	/**
	 * @return El valor de cliente.
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCliente")
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param Asigna el valor de cliente a cliente.
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return El valor de especificacion.
	 */
	@Basic
	public String getEspecificacion() {
		return especificacion;
	}
	/**
	 * @param Asigna el valor de especificacion a especificacion.
	 */
	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
	}
	/**
	 * @return El valor de fechaAsignacion.
	 */
	@Basic
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}
	/**
	 * @param Asigna el valor de fechaAsignacion a fechaAsignacion.
	 */
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	/**
	 * @return El valor de fechaEntrega.
	 */
	@Basic
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param Asigna el valor de fechaEntrega a fechaEntrega.
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	@SuppressWarnings("unchecked")
	public List<Orden> obtenerTodos(){
		
		Session sesion = null;
		List<Orden> ordenes = new ArrayList<Orden>();
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			ordenes = (List<Orden>) sesion.createQuery("from Orden").list();
			sesion.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return ordenes;
		
	}
	
	public String[][] datos()
	{ 	Orden orden = new Orden();
		int filas = orden.obtenerTodos().size();
		String[][] data = new String[filas][6];
		
	
		int i = 0;
			for(Orden o : orden.obtenerTodos())
			{
				data[i][0] = String.valueOf(o.getId());
				data[i][1] = String.valueOf(o.getCliente().getNombre());
				data[i][2] = String.valueOf(o.getLineaProduccion());

				i++;
			}
	
		return data;
	}

}
