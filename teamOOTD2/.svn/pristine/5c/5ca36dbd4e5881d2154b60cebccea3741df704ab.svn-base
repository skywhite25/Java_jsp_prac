package com.OOTD.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.OOTD.member.vo.LoginVO;
import com.OOTD.member.vo.MemberVO;
import com.OOTD.util.db.DBInfo;
import com.OOTD.util.db.DBSQL;

public class MemberDAO {

	// 필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 로그인 처리를 위한 메서드
	public LoginVO login(LoginVO vo) throws Exception{
		LoginVO loginVO = null;
		
		try {
			// 1. 2. 
			con = DBInfo.getConnection();
			// 3. 4.
			pstmt = con.prepareStatement(DBSQL.MEMBER_LOGIN);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			// 5. 실행
			rs = pstmt.executeQuery();
			// 6. 표시
			if(rs != null && rs.next()) {
				loginVO = new LoginVO();
				loginVO.setId(rs.getString("id"));
				loginVO.setName(rs.getString("name"));
				loginVO.setGradeNo(rs.getInt("gradeNo"));
				loginVO.setGradeName(rs.getString("gradeName"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("로그인 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		return loginVO;
	}

	// 회원 가입
	public Integer write(MemberVO vo) throws Exception {
		Integer result = 0;
		
		try {
			// 1. 2. 
			con = DBInfo.getConnection();
			// 3. 4.
			// 실행쿼리 확인
			pstmt = con.prepareStatement(DBSQL.MEMBER_WRITE);
			// sql 쿼리에 포함되어 있는 ? 의미에 맞는 데이터를 순서대로 셋팅
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAlias());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getBirth());
			pstmt.setString(7, vo.getTel());
			pstmt.setString(8, vo.getEmail());
			// 5. 실행
			//  - insert, update, delete 쿼리 실행 - int pstmt.executeUpdate()
			//  - select - ResultSet pstmt.executeQuery()
			result = pstmt.executeUpdate();
			
			// 6. 표시
			System.out.println("MemberDAO.write() - 회원가입 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("MemberDAO Error - 회원 가입 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt);
		}
		
		System.out.println("MemberDAO.write().result : " + result);
		return result;
	}
	// 아이디 중복 체크
	public String checkId(String id) throws Exception {
		String result = null;
		
		try {
			// 1. 2. 
			con = DBInfo.getConnection();
			// 3. 4.
			pstmt = con.prepareStatement(DBSQL.MEMBER_CHECK_ID);
			// sql 쿼리에 포함되어 있는 ? 의미에 맞는 데이터를 순서대로 셋팅
			pstmt.setString(1, id);
			// 5. 실행
			//  - insert, update, delete 쿼리 실행 - int pstmt.executeUpdate()
			//  - select - ResultSet pstmt.executeQuery()
			rs = pstmt.executeQuery();
			
			// 6. 표시
			if(rs != null && rs.next())
				result = rs.getString("id");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("MemberDAO Error - 아이디 중복 체크 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		System.out.println("MemberDAO.checkId().result : " + result);
		return result;
	}
	
}
