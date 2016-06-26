package br.com.teste.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.teste.business.ClienteBusiness;
import br.com.teste.model.Cliente;

@Path("cliente")
public class ClienteService {

	@EJB
	private ClienteBusiness clienteBusiness;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente create(Cliente cliente) {
		return clienteBusiness.create(cliente);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente read(@PathParam("id") Long id) {
		return clienteBusiness.read(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> read() {
		return clienteBusiness.read();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean update(Cliente cliente) {
		return clienteBusiness.update(cliente);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(Cliente cliente) {
		return clienteBusiness.delete(cliente);
	}
}
