package DAO;


import Model.EmployeeXSquad;
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
public class EmployeeXSquadDAO {

	private final Connection con = PGConn.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	private EmployeeXSquad tmp;
	private List<EmployeeXSquad> employeeXSquads;

	public List<EmployeeXSquad> findAll() {

		employeeXSquads = new ArrayList<>();
		try {
			this.ps = this.con.prepareStatement("Select * from employeexsquad");
			rs = ps.executeQuery();
			while (rs.next()) {
				tmp = new EmployeeXSquad(
								rs.getInt("employeeId"),
								rs.getInt("squadId"));
				employeeXSquads.add(tmp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return employeeXSquads;
	}

	public EmployeeXSquad findByEmployeeId(int employeeId) {

		try {
			this.ps = this.con.prepareStatement("Select * from employeexsquad where employeeid =?");
			this.ps.setInt(1, employeeId);
			rs = ps.executeQuery();
			while (rs.next()) {
				tmp = new EmployeeXSquad(
								rs.getInt("employeeId"),
								rs.getInt("squadId"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tmp;
	}

	public EmployeeXSquad findBySquadId(int squadId) {

		try {
			this.ps = this.con.prepareStatement("Select * from employeexsquad where squadid =?");
			this.ps.setInt(1, squadId);
			rs = ps.executeQuery();
			while (rs.next()) {
				tmp = new EmployeeXSquad(
								rs.getInt("employeeId"),
								rs.getInt("squadId"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tmp;
	}
	
	public void insert(int employeeId, int squadId){
		try{
			this.ps = this.con.prepareStatement("insert into employeexsquad values (employeeid = ?, squadid = ?)");
			this.ps.setInt(1,employeeId);
			this.ps.setInt(2, squadId);
			rs = ps.executeQuery();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteByEmployeeId(int employeeId){
		
		try {
			this.ps = this.con.prepareStatement("delete from employeexsquad where (employeeid = ?)");
			this.ps.setInt(1, employeeId);
			rs = ps.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteBySquadId(int squadId){
		
		try {
			this.ps = this.con.prepareStatement("delete from employeexsquad where (squadid = ?)");
			this.ps.setInt(1, squadId);
			rs = ps.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
