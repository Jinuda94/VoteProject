package pack01.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcBeans {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psmt;
	
	public JdbcBeans(Connection con, ResultSet rs, PreparedStatement psmt) {
		this.con = con;
		this.rs = rs;
		this.psmt = psmt;
	}
	
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public PreparedStatement getPsmt() {
		return psmt;
	}
	public void setPsmt(PreparedStatement psmt) {
		this.psmt = psmt;
	}
	
	
}
