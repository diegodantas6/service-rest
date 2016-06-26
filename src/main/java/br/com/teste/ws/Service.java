package br.com.teste.ws;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.teste.business.Jovem;
import br.com.teste.dto.Track;
import br.com.teste.model.Cliente;

@Path("jovem")
public class Service {

	@EJB
	private Jovem jovem;
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getTrackInJSON() {
		return jovem.getClientes();
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON(@QueryParam("id") Long id) {
//		return jovem.getCliente(id);
		
		Track track = new Track();
		
		track.setSinger("asd");
		track.setTitle("123");
		
		return track;
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente getTrackId(@PathParam("id") Long id) {
		return jovem.getCliente(id);
	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Track createTrackInJSON(Track track) {

		// String result = "Track saved : " + track;
		// return Response.status(201).entity(result).build();

		Cliente cliente = new Cliente();
		cliente.setNome("Diego 2");
		cliente.setNascimento(new Date());
		
		boolean saveCliente = jovem.saveCliente(cliente);
		
		System.out.println(saveCliente ? "salvo com sucesso!" : "falha ao salvar!");
		
		track.setTitle(track.getTitle() + "Testando!!!");

		return track;

	}

}
