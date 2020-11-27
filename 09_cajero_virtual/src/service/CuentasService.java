package service;

import java.util.List;

import model.Cuenta;

public interface CuentasService {
	List<Cuenta> obtenerCuentasNoCliente(int dni);
	void actualizarCuenta(int numeroCuenta, int dni);
	void ingresar(int numeroCuenta, double cantidad);
	void extraer(int numeroCuenta,double cantidad);
}
