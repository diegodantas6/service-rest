package br.com.teste.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.teste.model.Cliente;

@Stateless
public class ClienteBusiness {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Cliente create(Cliente cliente) {
		try {
			entityManager.persist(cliente);
			
			return cliente;
		} catch (Exception e) {
			return null;
		}
	}

	public Cliente read(Long id) {
		TypedQuery<Cliente> query = entityManager.createNamedQuery("clienteFindById", Cliente.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	public List<Cliente> read() {
		TypedQuery<Cliente> query = entityManager.createNamedQuery("clienteFindAll", Cliente.class);
		
		return query.getResultList();
	}

	public boolean update(Cliente cliente) {
		try {
			entityManager.merge(cliente);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(Cliente cliente) {
		try {
			Cliente exc = entityManager.find(Cliente.class, cliente.getId());
			
			entityManager.remove(exc);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
