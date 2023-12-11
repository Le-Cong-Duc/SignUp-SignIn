package DAO;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import JDBC.ConnectionJDBC;
import Model.Users;

public class UserDAO {

	public static UserDAO getInstance() {
		return new UserDAO();
	}

	public int insert(Users s) {
		Connection conn = ConnectionJDBC.getConnection();
		try {
			Statement stm = conn.createStatement();
			String sql = "INSERT INTO USERS " + " VALUES ( '" + s.getUser() + "' , ' " + s.getPass() + "' , '"
					+ s.getHovaten() + "' )";
			stm.executeUpdate(sql);
			
			ConnectionJDBC.close(conn);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi kết nối ");
		}
		return 0;
	}
}
