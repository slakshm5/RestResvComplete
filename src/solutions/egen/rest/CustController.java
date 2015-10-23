package solutions.egen.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import solutions.egen.dao.CustomerDAO;
import solutions.egen.exceptions.AppException;
import solutions.egen.model.Customer;

@Path("/customer")
public class CustController {
	
	//path - RESTApp/api/customer/all
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAll(){
		
		AppResponse resp = new AppResponse();
		
		try {
			CustomerDAO dao = new CustomerDAO();
			List<Customer> custList = null;
			custList = dao.getAll();
			
			resp.setStatus(AppResponse.SUCCESS);
			resp.setPayload(custList);
			
		} catch (AppException e) {
			e.printStackTrace();
			
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		
		return resp;
	}
	
	//path - RESTApp/api/customer/get/xxx
	@GET
	@Path("/get/{ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getEmployee(@PathParam("ID") int custId){
		
		AppResponse resp = new AppResponse();
		
		try{
			CustomerDAO dao = new CustomerDAO();
			Customer customer = dao.getCustById(custId);

			resp.setStatus(AppResponse.SUCCESS);
			resp.setPayload(customer);
			
		} catch (AppException e) {
			e.printStackTrace();
			
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		
		return resp;
		
	}
	
	@GET
	@Path("/add")
	public String addPerson(){
		return "added";
	}

}
