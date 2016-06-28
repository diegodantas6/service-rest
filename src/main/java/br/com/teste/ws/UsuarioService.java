package br.com.teste.ws;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import br.com.teste.business.UsuarioBusiness;
import br.com.teste.model.Usuario;

@Stateless
@Path("usuario")
public class UsuarioService {

	@EJB
	private UsuarioBusiness usuarioBusiness;

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void create(MultipartFormDataInput input) {

		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("foto");

		for (InputPart inputPart : inputParts) {

			try {

				// convert the uploaded file to inputstream
				InputStream inputStream = inputPart.getBody(InputStream.class, null);

				byte[] bytes = IOUtils.toByteArray(inputStream);
				
				usuarioBusiness.setFoto(1L, bytes);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// return Response.status(200).entity("uploadFile is called, Uploaded
		// file name : " + fileName).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario create(Usuario usuario) {
		return usuarioBusiness.create(usuario);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario read(@PathParam("id") Long id) {
		return usuarioBusiness.read(id);
	}

}
