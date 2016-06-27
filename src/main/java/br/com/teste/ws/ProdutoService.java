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

import br.com.teste.business.ProdutoBusiness;
import br.com.teste.model.Produto;

@Path("produto")
public class ProdutoService {

	@EJB
	private ProdutoBusiness produtoBusiness;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Produto create(Produto produto) {
		return produtoBusiness.create(produto);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto read(@PathParam("id") Long id) {
		
		try {
			Thread.sleep(2000);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return produtoBusiness.read(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> read() {
		return produtoBusiness.read();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean update(Produto produto) {
		return produtoBusiness.update(produto);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(Produto produto) {
		return produtoBusiness.delete(produto);
	}
}
