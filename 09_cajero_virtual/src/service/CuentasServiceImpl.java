package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Cliente;
import model.Cuenta;

//esto es un cambio realizado por el equipo 2
@Service
public class CuentasServiceImpl implements CuentasService {
	@PersistenceContext(unitName = "bancaPU")
	EntityManager em;
	@Override
	public List<Cuenta> obtenerCuentasNoCliente(int dni) {
		String jpql="Select c From Cuenta c where c not in ";
		//jpql+="(Select c From Cuenta c join c.clientes t Where t.dni=?1)";
		jpql+="(Select c From Cuenta c join c.clientes t Where t.dni=:dni)";
		TypedQuery<Cuenta> query=em.createQuery(jpql,Cuenta.class);
		//query.setParameter(1, dni);
		query.setParameter("dni", dni);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void actualizarCuenta(int numeroCuenta, int dni) {
		Cuenta cuenta=em.find(Cuenta.class, numeroCuenta);
		Cliente cliente=em.find(Cliente.class, dni);
		/*cuenta.getClientes().add(cliente);
		em.merge(cuenta);*/
		//La actualización se realiza en la entidad propietaria de la relación
		cliente.getCuentas().add(cuenta);
		em.merge(cliente);

	}
	@Override
	public void ingresar(int numeroCuenta, double cantidad) {
		Cuenta cuenta=em.find(Cuenta.class, numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		em.merge(cuenta);
		
	}
	@Override
	public void extraer(int numeroCuenta, double cantidad) {
		Cuenta cuenta=em.find(Cuenta.class, numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo()-cantidad);
		em.merge(cuenta);
		
	}

}
