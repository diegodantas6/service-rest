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

	public void setFoto(Long id, byte[] foto) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		
		usuario.setFoto(foto);
		
		entityManager.merge(usuario);
	}
	
	public Usuario create(Usuario usuario) {
		try {
			entityManager.persist(usuario);
			
			return usuario;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Usuario read(Long id) {
		return entityManager.find(Usuario.class, id);
	}
}
