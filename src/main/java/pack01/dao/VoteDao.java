package pack01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoteDao {
	private Connection con;
    private ResultSet rs;
    private PreparedStatement psmt;
    private String url;
    private String id;
    private String pw;
    
    public VoteDao(){
    	this.con = null;
    	this.rs = null;
    	this.psmt = null;
    	this.url = "jdbc:mysql://118.38.27.44:7878/votedb";
    	this.id = "jw01";
    	this.pw = "a123";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void votecheck() {
		String sql = "";

		try {
			con = DriverManager.getConnection(url, id, pw);
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				psmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void voteinsert() {
		String sql = "";

		try {
			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				psmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
