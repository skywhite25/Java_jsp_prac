package com.webjjang.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInfo {
	
	// 드라이버 정보 
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static boolean driverCheck = false;
	
	// DB 접속 정보 
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "java00";
	private static final String PW = "java00";
	
	// 만약에 클래스를 찾으면 바로 실행이 되어야 하는 것 -> 드라이버 확인 - 정보 필요
	static {
		System.out.println("DBInfo.static{} 실행 중-----------------------------------------");
		// 드라이버 확인
		try {
			Class.forName(DRIVER);
			driverCheck = true;
			System.out.println("DBInfo.static{} - 드라이버 확인");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	// Connection 받기를 하는 메서드 - 정보 필요
	public static Connection getConnection() throws SQLException{
		// driverCheck 가 false면 오류를 넘긴다.
		if(!driverCheck) throw new SQLException("드라이버가 존재하지 않습니다.");
		return DriverManager.getConnection(URL, ID, PW);
	}
	
	// Close 하는 메서드 - insert, update, delete : con, pstmt 필요
	public static void close(Connection con, PreparedStatement pstmt) throws SQLException {
		if(con != null) con.close();
		if(pstmt != null) pstmt.close();
	}
	
	// Close 하는 메서드 - : con, pstmt, rs 필요
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		// 위 close()에서 con과 pstmt 닫는 것을 가져온다.
		close(con, pstmt);
		if(rs != null) rs.close();
	}
}
