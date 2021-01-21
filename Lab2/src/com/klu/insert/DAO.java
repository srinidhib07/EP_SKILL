package com.klu.insert;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.klu.Bean.StudentBean;
import com.klu.connections.DBUtil;
import java.sql.ResultSet;
public class DAO {
	public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException
	{
		
		Connection con = DBUtil.DBConnection();
		
			PreparedStatement ps1 = con.prepareStatement("Insert into StudentBean values(?,?,?)");
			ps1.setInt(1,student.getRegNo()); 
			ps1.setString(2,student.getName());  
			ps1.setString(3,student.getEmail());
			
			int i=ps1.executeUpdate();  
			System.out.println(i+" record inserted");  
			return i;
		
	}
	public void StudentDelete(StudentBean student, int id) throws ClassNotFoundException, SQLException
	{
		Connection con =DBUtil.DBConnection();
		PreparedStatement ps2=con.prepareStatement("Delete from StudentBean where RegNo = ?" );
		ps2.setInt(1, id);
		int i=ps2.executeUpdate();
		System.out.println(i+" record deleted");
		
	}
	public void StudentUpdate(StudentBean student, int id, String email) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.DBConnection();
		PreparedStatement ps3= con.prepareStatement("Update StudentBean set email=? where RegNo = ?");
		ps3.setInt(2, id);
		ps3.setString(1, email);
		int i=ps3.executeUpdate();
		System.out.println(i+" record updated");
		
	}
	public void StudentDisplay(StudentBean student) throws ClassNotFoundException, SQLException
	{
		Connection con = DBUtil.DBConnection();
		PreparedStatement ps2 = con.prepareStatement("Select * from StudentBean");
		
		ResultSet rs= ps2.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		
	}

}
