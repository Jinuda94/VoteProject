package pack01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pack01.beans.JdbcBeans;

public class VoteDao {
	private ConnectMake cm;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement psmt;
	private JdbcBeans jb;

    public VoteDao(ConnectMake cm){
    	this.cm = cm;
    	this.con = null;
    	this.rs = null;
    	this.psmt = null;
    }
	
	public void votecheck() {
		String sql = "";

		try {
			con = cm.connect();
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jb = new JdbcBeans(con, rs, psmt);
			cm.close(jb);
		}
	}
	
	public void voteinsert() {
		String sql = "";

		try {
			con = cm.connect();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cm.close(jb);
		}
	}
}
