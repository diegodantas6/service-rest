package br.com.teste.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.teste.model.Usuario;

@Stateless
public class UsuarioBusiness {

	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean login(String user, String pass) {
		if (user != null && pass != null) {
			TypedQuery<Usuario> query = entityManager.createNamedQuery("login", Usuario.class);
			query.setParameter("user", user);
			query.setParameter("pass", pass);
			
			try {
				query.getSingleResult();
				
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
