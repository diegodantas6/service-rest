package br.com.teste.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.teste.model.Produto;

@Stateless
public class ProdutoBusiness {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Produto create(Produto produto) {
		try {
			entityManager.persist(produto);
			
			return produto;
		} catch (Exception e) {
			return null;
		}
	}

	public Produto read(Long id) {
		TypedQuery<Produto> query = entityManager.createNamedQuery("produtoFindById", Produto.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	public List<Produto> read() {
		TypedQuery<Produto> query = entityManager.createNamedQuery("produtoFindAll", Produto.class);
		
		return query.getResultList();
	}

	public boolean update(Produto produto) {
		try {
			entityManager.merge(produto);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(Produto produto) {
		try {
			Produto exc = entityManager.find(Produto.class, produto.getId());
			
			entityManager.remove(exc);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
