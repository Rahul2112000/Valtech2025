package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.Employee.Gender;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
		
	}
	
	
	@Override
	public void save(Employee e) {
		try (Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("INSERT INTO EMPLOYEE(NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID) VALUES(?,?,?,?,?,?,?)");
			setValuesToPreparaedStatements(e, ps);
			
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows Inserted="+rowsAffected);
			
		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
		
	}


	private void setValuesToPreparaedStatements(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1,e.getName());
		ps.setInt(2,e.getAge());
		ps.setString(3,e.getGender().name());
		ps.setFloat(4,(int) e.getSalary());
		ps.setInt(5,e.getExperience());
		ps.setInt(6,e.getLevel());
		ps.setLong(7,e.getId());
	}

	@Override
	public void update(Employee e) {
		try(Connection conn =getConnection()) {
			PreparedStatement ps=conn.prepareStatement("UPDATE EMPLOYEE SET NAME=?, AGE=? , GENDER=? ,SALARY=? ,EXPERIENCE=?,LEVEL=? WHERE ID=?");
			setValuesToPreparaedStatements(e, ps);
			int rowsAffected=ps.executeUpdate();
			System.out.println("Rows updated= "+rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}

	@Override
	public void delete(int id) {
		try (Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
			 ps.setInt(1, id);

		        int rowsAffected = ps.executeUpdate();
		        if (rowsAffected > 0) {
		            System.out.println("Employee with ID " + id + " deleted successfully.");
		        } else {
		            throw new RuntimeException("No employee with ID " + id + " found.");
		        }
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Employee get(int id) {
		
		try (Connection conn=getConnection()){
			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) { // if this next returns true then we have another row, next return false,we are at end the resultset 
			
			
			Employee e=populateEmployee(rs);
			return e;
			
			}else {
				new RuntimeException("No employee with Id "+id+" Found.");
			}
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException {
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3))
				.gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).build();
		
	}


	@Override
	public List<Employee> getAll() {
		List<Employee> emps=new ArrayList<Employee>();
		
		try(Connection conn=getConnection()) {
			PreparedStatement ps=conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL FROM EMPLOYEE");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return emps;
	}

}
