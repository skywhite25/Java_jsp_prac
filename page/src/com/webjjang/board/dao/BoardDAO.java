package com.webjjang.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.PageObject;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class BoardDAO {	
	
	// 필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 게시판 리스트
	public List<BoardVO> list(PageObject pageObject) throws Exception{
		List<BoardVO> list = null;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4.
			pstmt = con.prepareStatement(DBSQL.BOARD_LIST);
			pstmt.setLong(1, pageObject.getStartRow());
			pstmt.setLong(2, pageObject.getEndRow());
			// 5.
			rs = pstmt.executeQuery();
			// 6.
			if(rs != null) {
				while(rs.next()) {
					if(list == null) list = new ArrayList<BoardVO>();
					BoardVO vo = new BoardVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setWriteDate(rs.getString("writeDate"));
					vo.setHit(rs.getLong("hit"));
					list.add(vo);
					System.out.println("BoardDAO.list().while().vo: " + vo);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("게시판 리스트 DB 처리중 오류 발생");
			
		}finally {
			DBInfo.close(con, pstmt, rs);
		}
		return list;
	} // end of list()
	
	// 전체 데이터 가져오기
	// 게시판 리스트
	public long getTotalRow() throws Exception{
		long result= 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4.
			pstmt = con.prepareStatement(DBSQL.BOARD_GET_TOTALROW);
			// 5.
			rs = pstmt.executeQuery();
			// 6.
			if(rs != null && rs.next()) {
				result = rs.getLong(1); // count(*) -> 1
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("게시판 전체 데이터의 갯수 DB 처리중 오류 발생");
			
		}finally {
			DBInfo.close(con, pstmt, rs);
		}
		return result;
	} // end of getTotalRow()
		
}
