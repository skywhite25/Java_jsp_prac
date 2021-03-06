package com.OOTD.util.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInfo {



		//드라이버 정보
		private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		private  static boolean driverCheck = false;
		
		//접속 정보
		private static final String URL = "jdbc:oracle:thin:@192.168.0.171:1521:xe";
		private static final String ID = "team2";
		private static final String PW = "team2";
		
		//만약에 클래스를 찾으면 바로 실행되는 것 - 드라이버 확인:정보 
		
		static {
			System.out.println("===============DBInfo.static{} 실행===============");
			//여기서 드라이버 확인을 한 번만 함 
			try {
				Class.forName(DRIVER);
				driverCheck = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				
			}
		}
		//Connection 받기 메소드 -> 정보 
		public static Connection getConnection() throws SQLException {
			
			if(!driverCheck)throw new SQLException("드라이버가 존재하지 않습니다");
			return DriverManager.getConnection(URL,ID,PW);
		}
		
		// Close 메소드 -con,psmt:insert,update,delete
		public static void close(Connection con, PreparedStatement pstmt) 
				throws SQLException {
			if(con!=null)con.close();
			if(pstmt!=null)pstmt.close();
		}
		public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) 
				throws SQLException{
			close(con,pstmt);
			if(rs!=null)rs.close();
		}
	}


