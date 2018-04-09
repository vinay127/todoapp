import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.model.Address;
import com.todo.service.AddressService;

@Path("/address")
public class AddressResource {

	@Autowired
	AddressService addressService;

	@POST
	@Path("/insertAddress")
	@Consumes(MediaType.APPLICATION_JSON_PATCH_JSON)
	@Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
	public void insert(Address address) {
		addressService.saveAddress(address)
	}
}
