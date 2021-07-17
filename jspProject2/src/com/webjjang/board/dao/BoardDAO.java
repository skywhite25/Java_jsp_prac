package com.webjjang.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

import com.webjjang.util.PageObject;

/*
 * 필요한 메소드들
 * list(), getTotalRow view(), increase(), write(), update(), delete()
 */
public class BoardDAO {
	
	// 필요한 객체 선언 - con, pstmt, rs
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1. 게시판 리스트
	public List<BoardVO> list(PageObject pageObject) throws Exception {
		
		// 넘어오는 데이터 확인
		System.out.println("BoardDAO.list().pageObject : " + pageObject);
		
		List<BoardVO> list = null;
		
		try {
			// 1. 드라이버 확인 + 2. 연결
			con = DBInfo.getConnection();
			System.out.println("BoardDAO.list().con : " + con);
			
			// 3. SQL -> DBSQL + 4. 실행객체 + 데이터 셋팅
			System.out.println("BoardDAO.list().DBSQL.BOARD_LIST : " + DBSQL.BOARD_LIST);
			pstmt = con.prepareStatement(DBSQL.BOARD_LIST);
			System.out.println("BoardDAO.list().pstmt: " + pstmt);
			pstmt.setLong(1, pageObject.getStartRow()); // 시작 번호
			pstmt.setLong(2, pageObject.getEndRow()); // 끝 번호
			
			// 5. 실행
			rs = pstmt.executeQuery();
			System.out.println("BoardDAO.list().rs: " + rs);
			
			// 6. 표시 -> 데이터 담기
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
			// 개발자를 위한 오류 출력
			e.printStackTrace();
			// 사용자를 위한 오류 출력
			throw new Exception("게시판 리스트 실행 중 DB처리 오류 발생");
		} finally {
			// 7. 닫기
			DBInfo.close(con, pstmt, rs);
			
		}
		System.out.println("BoardDAO.list().list : " + list);
		return list;
	}
	
	// 1-1. 전체 데이터 갯수 구하기
	public long getTotalRow() throws Exception {
		System.out.println("BoardDAO.getTotalRow()");
		
		long result = 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			System.out.println("BoardDAO.getTotalRow().con : " + con);
			// 3.4.
			// 쿼리 확인
			System.out.println("BoardDAO.getTotalRow().DBSQL.BOARD_GET_TOTALROW : "
						+ DBSQL.BOARD_GET_TOTALROW);
			pstmt = con.prepareStatement(DBSQL.BOARD_GET_TOTALROW);
			System.out.println("BoardDAO.getTotalRow().pstmt : " + pstmt);
			// 5.
			// rs는 출력해 볼 수 있다. 그러나 rs.next()를 출력하면 데이터틀 한 개 넘기게 되므로 출력하지 않는다.
			rs = pstmt.executeQuery();
			System.out.println("BoardDAO.getTotalRow().rs : " + rs);
			// 6.
			if(rs != null && rs.next()) {
				result = rs.getLong(1);
				System.out.println("BoardDAO.getTotalRow().result : " + result);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("게시판 데이터 전체 갯수를 가져오는 DB처리중 오류발생");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		System.out.println("BoardDAO.getTotalRow().result : " + result);
		return result;
	}
	
	// 2. 게시판 글보기
	public BoardVO view(long no) throws Exception {
		BoardVO vo = null;
		
		try {
			// 1. 드라이버 확인 + 2. 연결
			con = DBInfo.getConnection();
			
			// 3. SQL -> DBSQL + 4. 실행객체 + 데이터 셋팅
			pstmt = con.prepareStatement(DBSQL.BOARD_VIEW);
			pstmt.setLong(1, no); // 시작 번호
			
			// 5. 실행 - 데이터 한 개, 반복문 필요없음
			rs = pstmt.executeQuery();
			
			// 6. 표시 -> 데이터 담기
			if(rs != null && rs.next()) {
				vo = new BoardVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getString("writeDate"));
				vo.setHit(rs.getLong("hit"));
			}
			
		}catch (Exception e) {
				// TODO: handle exception
			// 개발자를 위한 오류 출력
			e.printStackTrace();
			// 사용자를 위한 오류 출력
			throw new Exception("게시판 글보기 실행 중 DB처리 오류 발생");
		} finally {
			// 7. 닫기
			DBInfo.close(con, pstmt, rs);
			
		}
		
		return vo;
	}
	
	// 2-1. 조회수 1 증가(리스트 -> 글보기)
	public int increase(long no) throws Exception {
		int result = 0;
		try {

			// 1.확인 2.연결
			con = DBInfo.getConnection();
			// 3.sql 4.실행 객체&데이터 셋팅
			pstmt = con.prepareStatement(DBSQL.BOARD_INCREASE);
			pstmt.setLong(1, no);
			// 5.실행
			result = pstmt.executeUpdate();
			// 6.표시
			System.out.println("조회수 1 증가 성공");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("조회수 1증가 처리중 DB오류 발생");
		}
		return result;
		
	}
	
	// 3. 게시판 글쓰기
	public int write(BoardVO vo) throws Exception {
			int result = 0;
			try {
				// 1. 드라이버 확인 + 2. 연결
				con = DBInfo.getConnection();
				
				// 3. SQL -> DBSQL + 4. 실행객체 + 데이터 셋팅
				pstmt = con.prepareStatement(DBSQL.BOARD_WRITE);
				pstmt.setString(1, vo.getTitle()); // 시작 번호
				pstmt.setString(2, vo.getContent()); // 시작 번호
				pstmt.setString(3, vo.getWriter()); // 시작 번호
				
				// 5. 실행 - 데이터 한 개, 반복문 필요없음
				result = pstmt.executeUpdate();
				
				// 6. 표시 -> 데이터 담기
				System.out.println("글쓰기 처리를 완료했습니다.");
				
			}catch (Exception e) {
					// TODO: handle exception
				// 개발자를 위한 오류 출력
				e.printStackTrace();
				// 사용자를 위한 오류 출력
				throw new Exception("게시판 글쓰기 실행 중 DB처리 오류 발생");
			} finally {
				// 7. 닫기
				DBInfo.close(con, pstmt);
				
			}
			
			return result;
		
	}

	// 4. 게시판 글수정
	public int update(BoardVO vo) throws Exception {
		int result = 0;
		try {
			// 1. 드라이버 확인 + 2. 연결
			con = DBInfo.getConnection();
			
			// 3. SQL -> DBSQL + 4. 실행객체 + 데이터 셋팅
			pstmt = con.prepareStatement(DBSQL.BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle()); 
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter()); 
			pstmt.setLong(4, vo.getNo()); 
			
			// 5. 실행 - 데이터 한 개, 반복문 필요없음
			result = pstmt.executeUpdate();
			
			// 6. 표시 -> 데이터 담기
			System.out.println("글수정 처리를 완료했습니다.");
			
		}catch (Exception e) {
				// TODO: handle exception
			// 개발자를 위한 오류 출력
			e.printStackTrace();
			// 사용자를 위한 오류 출력
			throw new Exception("게시판 글수정 실행 중 DB처리 오류 발생");
		} finally {
			// 7. 닫기
			DBInfo.close(con, pstmt);
			
		}
		
		return result;	
		}
	
	// 5. 게시판 글삭제
	public int delete(long no) throws Exception {
		int result = 0;
		try {
			// 1. 드라이버 확인 + 2. 연결객체
			con = DBInfo.getConnection();
			// 3. sql + 4. 실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(DBSQL.BOARD_DELETE);
			pstmt.setLong(1, no);
			// 5. 실행
			result = pstmt.executeUpdate();
			// 6. 출력
			if(result == 1)
				System.out.println("글삭제 처리를 완료했습니다.");
			else
				System.out.println("삭제하려는 글의 정보를 다시 확인하세요.");
			
		}catch (Exception e) {
			// TODO: handle exception
			// 개발자를 위한 예외출력(500) -> 콘솔
			e.printStackTrace();
			// 사용자를 위한 오류 출력 -> jsp까지 전달된다.
			throw new Exception("게시판 글삭제 실행 중 DB처리 오류 발생");
		} finally {
			DBInfo.close(con, pstmt);
		}
		return result;
	}
	
}
