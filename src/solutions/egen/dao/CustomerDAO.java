package solutions.egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import solutions.egen.exceptions.AppException;
import solutions.egen.model.Customer;
import solutions.egen.utils.DBUtil;

public class CustomerDAO {

	
	public List<Customer> getAll() throws AppException{
		List<Customer> custList = new ArrayList<Customer>();
		
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				ps = con.prepareStatement("SELECT * from customers");
				rs = ps.executeQuery();
				
				while(rs.next()){
					Customer cust = new Customer();
					
					cust.setID(rs.getInt("ID"));
					cust.setFirstName(rs.getString("FIRST_NAME"));
					cust.setLastName(rs.getString("LAST_NAME"));
					cust.setPhoneNum(Long.parseLong(rs.getString("PHONE_NUM")));
					cust.setEmail(rs.getString("EMAIL"));
					cust.setConfCode(rs.getString("CONF_CODE"));
					
					custList.add(cust);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException("Error fetching records from the database", e.getCause());
			}
			finally{
					DBUtil.releaseResources(ps, rs, con);
			}
		return custList;
	}
	
	public Customer getCustById (int custId) throws AppException{
		
		Customer customer = new Customer();
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				ps = con.prepareStatement("SELECT * from customers WHERE Id =?");
				ps.setInt(1, custId);
				rs = ps.executeQuery();
				
				if(rs.next()){
										
					customer.setID(rs.getInt("ID"));
					customer.setFirstName(rs.getString("FIRST_NAME"));
					customer.setLastName(rs.getString("LAST_NAME"));
					customer.setPhoneNum(Long.parseLong(rs.getString("PHONE_NUM")));
					customer.setEmail(rs.getString("EMAIL"));
					customer.setConfCode(rs.getString("CONF_CODE"));
					
				}
				else{
					throw new AppException("Customer with ID " + custId +"does not exist");
				}
			
			}catch (SQLException e) {
				e.printStackTrace();
				throw new AppException("Error fetching record from the database", e.getCause());
			}
			finally{
					DBUtil.releaseResources(ps, rs, con);
			}
			
			return customer;
	}

	public Customer addCustomer(Customer cust) throws AppException{
		Customer customer = new Customer();
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				ps = con.prepareStatement("INSERT INTO customers (FIRST_NAME, LAST_NAME, PHONE_NUM, EMAIL, CONF_CODE) VALUES (?, ?, ?, ?, ?)",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, cust.getFirstName());
				ps.setString(2, cust.getLastName());
				ps.setLong(3, cust.getPhoneNum());
				ps.setString(4, cust.getEmail());
				ps.setString(5, cust.getConfCode());
				ps.executeUpdate();
				
				rs= ps.getGeneratedKeys();
				
				if(rs.next()){
										
					cust.setID(rs.getInt(1));
					
				}
				else{
					throw new AppException("Customer not added to the database");
				}
			
			}catch (SQLException e) {
				e.printStackTrace();
				throw new AppException("Error adding record to the database", e.getCause());
			}
			finally{
					DBUtil.releaseResources(ps, rs, con);
			}
			
			return cust;

	}
}
