package service;

import java.util.List;

import model.Cliente;

public interface ClientesService {
	List<Cliente> obtenerClientes();
	void actualizarCliente(Cliente cliente);
}
