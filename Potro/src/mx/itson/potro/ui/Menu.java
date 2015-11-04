package mx.itson.potro.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import mx.itson.potro.entidades.Cliente;
import mx.itson.potro.entidades.Contacto;
import mx.itson.potro.entidades.Linea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTable tableOrdenes;
	private static JTable tableClientes;
	private static JTable tableContactos;
	private static JTable tableLineas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					tablaContactos(tableContactos);
					tablaClientes(tableClientes);
					tablaLineas(tableLineas);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unused")
	public static void tablaContactos (JTable table) {
		DefaultTableModel modelo = new DefaultTableModel();
		Contacto contacto = new Contacto();
				 String[] columnas = {
						"ID","Nombre", "Telefono"};
				 modelo.setColumnIdentifiers(columnas);
	for (int filas = 0; filas < contacto.datos().length; filas++) {
		for (int i = 0; i < contacto.datos().length; i++ ) 
		{
		 modelo.addRow(contacto.datos()[i]);	
		}break;
	}
	modelo.setColumnIdentifiers(columnas);
	table.setModel(modelo);
		
	}
	
	@SuppressWarnings("unused")
	public static void tablaClientes (JTable table) {
		Cliente cliente = new Cliente();
		DefaultTableModel modelo = new DefaultTableModel();
		Contacto contacto = new Contacto();
				 String[] columnas = {
						"ID","Nombre", "Direccion"};
				 modelo.setColumnIdentifiers(columnas);
	for (int filas = 0; filas < cliente.datos().length; filas++) {
		for (int i = 0; i < cliente.datos().length; i++ ) 
		{
		 modelo.addRow(cliente.datos()[i]);	
		}break;
	}
	modelo.setColumnIdentifiers(columnas);
	table.setModel(modelo);
		
	}
	@SuppressWarnings("unused")
	public static void tablaLineas(JTable table) {
		DefaultTableModel modelo = new DefaultTableModel();
		Linea linea = new Linea();
				 String[] columnas = {
						"ID","Nombre", "Telefono"};
				 modelo.setColumnIdentifiers(columnas);
	for (int filas = 0; filas < linea.datos().length; filas++) {
		for (int i = 0; i < linea.datos().length; i++ ) 
		{
		 modelo.addRow(linea.datos()[i]);	
		}break;
	}
	modelo.setColumnIdentifiers(columnas);
	table.setModel(modelo);
		
	}
	
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 563, 417);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Ordenes", null, panel, null);
		panel.setLayout(null);
		
		tableOrdenes = new JTable();
		tableOrdenes.setBorder(new TitledBorder(null, "Ordenes Guardadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tableOrdenes.setBounds(0, 24, 547, 255);
		panel.add(tableOrdenes);
		
		JButton btnNuevaOrden = new JButton("Nueva Orden");
		btnNuevaOrden.setBounds(22, 319, 116, 28);
		panel.add(btnNuevaOrden);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Clientes & Contactos", null, panel_1, null);
		panel_1.setLayout(null);
		
		tableClientes = new JTable();
		tableClientes.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tableClientes.setBounds(6, 31, 224, 350);
		panel_1.add(tableClientes);
		
		tableContactos = new JTable();
		tableContactos.setBorder(new TitledBorder(null, "Contactos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tableContactos.setBounds(254, 43, 303, 162);
		panel_1.add(tableContactos);
		
		JButton btnNuevoCliente = new JButton("Nuevo Cliente");
		btnNuevoCliente.setBounds(254, 233, 120, 28);
		panel_1.add(btnNuevoCliente);
		
		JButton btnNuevoContacto = new JButton("Nuevo Contacto");
		btnNuevoContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNuevoContacto.setBounds(254, 273, 120, 28);
		panel_1.add(btnNuevoContacto);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Lineas de Produccion", null, panel_2, null);
		panel_2.setLayout(null);
		
		tableLineas = new JTable();
		tableLineas.setBorder(new TitledBorder(null, "Lineas de Produccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tableLineas.setBounds(6, 213, 551, 168);
		panel_2.add(tableLineas);
	}
}
