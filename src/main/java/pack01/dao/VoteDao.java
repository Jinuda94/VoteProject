package pack01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pack01.beans.JdbcBeans;
import pack01.beans.Person;

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
	
    public int votecheck(Person person) {
		String sql = "SELECT NAME FROM vote_info WHERE NAME = ? AND SE_NUM = ?";
		try {
			con = cm.connect();
			

			psmt = con.prepareStatement(sql);
			psmt.setString(1, person.getName());
			psmt.setString(2, person.getSe_num());
			
			rs = psmt.executeQuery();
			
			if(!rs.next()) {
				//로그인 못한 상태다. 정보불일치
				return 1;
			} else {
				sql = "SELECT VOTE FROM vote_info WHERE NAME = ? AND SE_NUM = ?";
				
				psmt = con.prepareStatement(sql);
				psmt.setString(1, person.getName());
				psmt.setString(2, person.getSe_num());
				
				rs = psmt.executeQuery();
				while(rs.next()) {
					
					if(rs.getInt("vote") != 0) {
						//로그인은 했지만 투표가 중복 투표다
						return 2;
					} else {
						//투표를 제대로 할수있다.
						return 3;
					}
				}
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jb = new JdbcBeans(con, rs, psmt);
			cm.close(jb);
		}
		//DB에서 오류가 났거나 할것임.
		return 4;
	}
	
	public int voteinsert(Person person) {
		String sql = "UPDATE vote_info set vote=? where se_num=?";
		
		try {
			int result1 = votecount(person);
			System.out.println(result1);
			con = cm.connect();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, 1);
			psmt.setString(2, person.getSe_num());
			int result2 = psmt.executeUpdate();
			System.out.println(result2);

			return result2;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cm.close(jb);
		}
		
		//DB에서 오류가 났거나 할것임.
		return 0;
	}
	
	public int votecount(Person person) {
		String sql = "UPDATE vote_count set count = count+1 WHERE candidate=?";
		try {
			con = cm.connect();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, person.getVote());
			int result = psmt.executeUpdate();
			System.out.println(result);
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cm.close(jb);
		}
		
		//DB에서 오류가 났거나 할것임.
		return 0;
	}
}
