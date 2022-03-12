/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Customer;
import Utils.PGConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aykut
 */
public class CustomerDAO{
	
	private final Connection con = PGConn.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	private Customer tmp;
	private List<Customer> customers; 
	
	public List<Customer> findAll(){
		
	
		
		try{
				customers = new ArrayList<>();
				this.ps = this.con.prepareStatement("Select * from Customer");
				rs = ps.executeQuery();
				while(rs.next()){
					tmp = new Customer(
								rs.getInt("id"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getInt("addressId"),
								rs.getInt("accountTypeId"));
				customers.add(tmp);
				}
				System.out.println(customers);
				
		}catch(SQLException e){
				System.out.println(e.getMessage());
		}
		return customers;
	}
	
	public Customer findById(int id){
		
		try{
			this.ps = this.con.prepareStatement("Select * from Customer where id =?");
			this.ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()){
				tmp = new Customer(
								rs.getInt("id"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getInt("addressId"),
								rs.getInt("accountTypeId"));
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return tmp;
	
	}
	
	public Customer findByPhone(String phone){
		try{
			this.ps = this.con.prepareStatement("Select * from Customer where phone =?");
			this.ps.setString(1, phone);
			rs = ps.executeQuery();
			
			while(rs.next()){
				tmp = new Customer(
								rs.getInt("id"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getInt("addressId"),
								rs.getInt("accountTypeId"));
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return tmp;
	}
	
	public Customer findByEmail(String email){
		try{
			this.ps = this.con.prepareStatement("Select * from Customer where email =?");
			this.ps.setString(1, email);
			rs = ps.executeQuery();
			
			while(rs.next()){
				tmp = new Customer(
								rs.getInt("id"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getInt("addressId"),
								rs.getInt("accountType"));
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return tmp;
	}
	
	public Customer findByAddressId(int addressId){
		try{
			this.ps = this.con.prepareStatement("Select * from Customer where addressId =?");
			this.ps.setInt(1, addressId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				tmp = new Customer(
								rs.getInt("id"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getInt("addressId"),
								rs.getInt("accountTypeId"));
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return tmp;
	}
	
	public List<Customer> findByAccountType(int accountTypeId){
		
		
		
		try{
				customers = new ArrayList<>();
				this.ps = this.con.prepareStatement("Select * from Customer where accountTypeId =?");
				this.ps.setInt(1, accountTypeId);
				rs = ps.executeQuery();
				while(rs.next()){
					tmp = new Customer(
								rs.getInt("id"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getInt("addressId"),
								rs.getInt("accountTypeId"));
				customers.add(tmp);
				}
				System.out.println(customers);
				
		}catch(SQLException e){
				System.out.println(e.getMessage());
		}
		System.out.println(customers.size());
		return customers;
		
	}
}
