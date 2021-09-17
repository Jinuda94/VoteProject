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
		this.url = "jdbc:mysql://115.22.11.155:3333/votedb";
		this.id = "ti";
		this.pw = "1";
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
