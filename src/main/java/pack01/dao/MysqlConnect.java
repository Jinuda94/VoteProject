package pack01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import pack01.beans.JdbcBeans;

public class MysqlConnect implements ConnectMake {
	private Connection con;
	private String url;
	private String id;
	private String pw;

	public MysqlConnect() {
		this.con = null;
		this.url = "jdbc:mysql://118.38.27.44:7878/votedb";
		this.id = "jw01";
		this.pw = "a123";
	}

	@Override
	public Connection connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
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
