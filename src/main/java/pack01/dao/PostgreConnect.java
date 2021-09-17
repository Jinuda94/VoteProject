package pack01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import pack01.beans.JdbcBeans;

public class PostgreConnect implements ConnectMake {
	private Connection con;
	private String url;
	private String id;
	private String pw;

	public PostgreConnect() {
		this.con = null;
		this.url = "jdbc:postgresql://118.38.27.44:8888/jwdb";
		this.id = "jw01";
		this.pw = "a123";
	}

	@Override
	public Connection connect() {

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, id, pw);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close(JdbcBeans jb) {
		try {
			jb.getCon().close();
			jb.getRs().close();
			jb.getPsmt().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
