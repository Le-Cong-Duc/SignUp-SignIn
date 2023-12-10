package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionJDBC {

	public  Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-K7HVB4T:1433;databaseName=QUANLI";
			String user = "sa";
			String pass = "18112005";

			conn = DriverManager.getConnection(url, user, pass);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		return conn;
	}

}
