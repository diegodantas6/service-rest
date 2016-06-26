package br.com.teste.filter;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import br.com.teste.business.UsuarioBusiness;

@Provider
public class Login implements ContainerRequestFilter {

	@EJB
	private UsuarioBusiness usuarioBusiness;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		String user = requestContext.getHeaderString("user");
		String pass = requestContext.getHeaderString("pass");

		if (!(usuarioBusiness.login(user, pass))) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access the resource.").build());
		}
	}
}
