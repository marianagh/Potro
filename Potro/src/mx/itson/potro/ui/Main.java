package mx.itson.potro.ui;

import java.util.List;

import mx.itson.potro.entidades.Cliente;
import mx.itson.potro.entidades.Contacto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contacto contacto = new Contacto();
		@SuppressWarnings("unused")
		List<Contacto> contactos = contacto.obtenerTodos();
		Cliente cliente = new Cliente();
		@SuppressWarnings("unused")
		List<Cliente> clientes = cliente.obtenerTodos();

	}

}
