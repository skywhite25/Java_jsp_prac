package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	private Connection conn;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String url = "jdbc:mysql://localhost:3306/LectureEvaluation";
			String id = "root";
			String pw = "a135719";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPW) {
		String sql = " select userPW from user where userID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPW))
					return 1; // 로그인 성공
				else
					return 0; // 로그인 실패
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // DB 오류
	}
	
	public int join(UserDTO user) {
		String sql = " insert into user values(?, ?, ?, ?, false)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPW());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserEmailHash());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 회원가입 실패
	}
	
	public String getUserEmail(String userID) {
		String sql = " select userEmail from user where userID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getString(1); // 이메일 주소 반환
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // DB 오류
	}
	
	public boolean getUserEmailChecked(String userID) {
		String sql = " select userEmailChecked from user where userID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getBoolean(1); // 이메일 등록 주소 반환
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // DB 오류
	}
	
	public boolean setUserEmailChecked(String userID) {
		String sql = " update user set userEmailChecked = true where userID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.executeUpdate();
				return true; // 이메일 등록 성공
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}













