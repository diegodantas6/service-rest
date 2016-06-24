package br.com.teste.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.teste.model.Cliente;

@Stateless
public class Jovem {

	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean saveCliente(Cliente cliente) {
		try {
			entityManager.persist(cliente);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Cliente> getClientes() {
		TypedQuery<Cliente> query = entityManager.createNamedQuery("findAll", Cliente.class);
		
		return query.getResultList();
	}

	public Cliente getCliente(Long id) {
		TypedQuery<Cliente> query = entityManager.createNamedQuery("findById", Cliente.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
	
}
