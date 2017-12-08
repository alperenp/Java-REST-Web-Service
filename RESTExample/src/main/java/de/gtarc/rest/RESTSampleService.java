package de.gtarc.rest;

/**
 * @author pulur
 * 
 */
 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/")
public class RESTSampleService {
	/**
	 * rest tag in URL comes from mapping in ../WebContent/WEB-INF/web.xml file <servlet-mapping> tag
	 * http://localhost:8080/RESTExample/rest/sampleService
	 * @param incomingData
	 * @return
	 */
	@POST
	@Path("/sampleService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sampleService(InputStream incomingData) {
		StringBuilder strBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				strBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + strBuilder.toString());
		
		String responseStr = "received '" + strBuilder.toString() + "' from client.";
		// return HTTP response 200 in case of success
		return Response.status(200).entity(responseStr).build();
	}
 
	/**
	 * rest tag in URL comes from mapping in ../WebContent/WEB-INF/web.xml file <servlet-mapping> tag
	 * http://localhost:8080/RESTExample/rest/verify
	 * @return
	 */
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService() {
		String response = "RESTSampleService Successfully started..";
		// return HTTP response 200 in case of success
		return Response.status(200).entity(response).build();
	}
 
}
