package com.OOTD.timeline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.OOTD.timeline.vo.TimelineVO;
import com.OOTD.util.PageObject;
import com.OOTD.util.db.DBInfo;
import com.OOTD.util.db.DBSQL;

public class TimelineDAO {

	// 필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1. 타임라인 리스트
	public List<TimelineVO> list(PageObject pageObject) throws Exception{
		
		// 넘어오는 데이터 확인
		System.out.println("TimelineDAO.list().pageObject : " + pageObject);
		
		List<TimelineVO> list = null;
		
		try {
			//1. 드라이버 확인 + 2. 연결
			con = DBInfo.getConnection();
			System.out.println("TimelineDAO.list().con : " + con);
			//3. sql -> DBSQL + 4. 실행객체 + 데이터 셋팅
			System.out.println("TimelineDAO.list().DBSQL.TIMELINE_LIST : " + DBSQL.TIMELINE_LIST);
			pstmt = con.prepareStatement(DBSQL.TIMELINE_LIST);
			System.out.println("TimelineDAO.list().pstmt : " + pstmt);
			pstmt.setLong(1, pageObject.getStartRow()); // 시작 번호
			pstmt.setLong(2, pageObject.getEndRow()); // 끝 번호
			// 5. 실행
			rs = pstmt.executeQuery();
			System.out.println("TimelineDAO.list().rs : " + rs);
			// 6. 표시 -> 데이터담기
			if(rs != null) {
				while(rs.next()) {
					if(list == null) list = new ArrayList<TimelineVO>();
					TimelineVO vo = new TimelineVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setNickname(rs.getString("nickname"));
					vo.setId(rs.getString("id"));
					vo.setWriteDate(rs.getString("writeDate"));
					vo.setFileName(rs.getString("fileName"));
					list.add(vo);
					// System.out.println("TimelineDAO.list().while().vo : " + vo);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			// 개발자를 위해서 오류를 콘솔에 출력한다.
			e.printStackTrace();
			// 사용자를 위한 오류 처리
			throw new Exception("타임라인 게시판 리스트 실행 중 DB 처리 오류");
		} finally {
			// 7. 닫기
			DBInfo.close(con, pstmt, rs);
		}
		
		System.out.println("TimelineDAO.list().list : " + list);
		return list;
	}

	
	// 1-1. 타임라인 전체 데이터 갯수
	public long getTotalRow() throws Exception{
		System.out.println("TimelineDAO.getTotalRow()");
		
		long result = 0;
		
		try {
			//1.2.
			con = DBInfo.getConnection();
			System.out.println("TimelineDAO.getTotalRo().con : " + con);
			
			// 3.4.
			// 쿼리 확인
			System.out.println("TimelineDAO.getTotalRo().DBSQL.TIMELINE_GET_TOTALROW : "
					+ DBSQL.TIMELINE_GET_TOTALROW );
			pstmt = con.prepareStatement(DBSQL.TIMELINE_GET_TOTALROW);
			System.out.println("TimelineDAO.getTotalRo().pstmt : " + pstmt);
			
			// 5. 
			// rs는 출력해 볼수 있다. 그러나 rs.next() 출력하면 데이터를 한개 넘기게 된다.
			rs = pstmt.executeQuery();
			System.out.println("TimelineDAO.getTotalRo().rs : " + rs);
			// 6.
			if(rs != null && rs.next()) {
				result = rs.getLong(1);
				System.out.println("TimelineDAO.getTotalRo().result : " + result);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("타임라인 게시판 데이터 전체 갯수를 가져오는 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		System.out.println("TimelineDAO.getTotalRo().result : " + result);
		return result;
	}
	
	// 2. 타임라인 보기
	public TimelineVO view(Long no) throws Exception{
		System.out.println("TimelineDAO.getTotalRow()");
		
		TimelineVO vo = null;
		
		try {
			//1.2.
			con = DBInfo.getConnection();
			System.out.println("TimelineDAO.view().con : " + con);
			
			// 3.4.
			// 쿼리 확인
			System.out.println("TimelineDAO.view().DBSQL.TIMELINE_VIEW : "
					+ DBSQL.TIMELINE_VIEW );
			pstmt = con.prepareStatement(DBSQL.TIMELINE_VIEW);
			pstmt.setLong(1, no);
			System.out.println("TimelineDAO.view().pstmt : " + pstmt);
			
			// 5. 
			// rs는 출력해 볼수 있다. 그러나 rs.next() 출력하면 데이터를 한개 넘기게 된다.
			rs = pstmt.executeQuery();
			System.out.println("TimelineDAO.view().rs : " + rs);
			// 6.
			if(rs != null && rs.next()) {
				vo = new TimelineVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setNickname(rs.getString("nickname"));
				vo.setId(rs.getString("id"));
				vo.setWriteDate(rs.getString("writeDate"));
				vo.setFileName(rs.getString("fileName"));
				System.out.println("TimelineDAO.view().vo : " + vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("타임라인 게시판 타임라인 보기 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		System.out.println("TimelineDAO.view().vo : " + vo);
		return vo;
	}
	
	
	// 3. 타임라인 등록 
	public int write(TimelineVO vo) throws Exception {
		int result = 0;
		
		try {
			//1.2.
			con = DBInfo.getConnection();
			//3.4.
			pstmt = con.prepareStatement(DBSQL.TIMELINE_WRITE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getId());
			pstmt.setString(4, vo.getFileName());
			
			//5. 
			result = pstmt.executeUpdate();
			
			// 6.
			System.out.println("TimelineDAO.write() - 타임라인 등록 완료.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("타임라인 등록 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
	// 4-1. 이미지 정보 수정
		public int update(TimelineVO vo) throws Exception {
			int result = 0;
			
			try {
				//1.2.
				con = DBInfo.getConnection();
				//3.4.
				pstmt = con.prepareStatement(DBSQL.TIMELINE_UPDATE);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setLong(3, vo.getNo());
				
				//5. 
				result = pstmt.executeUpdate();
				
				// 6.
				System.out.println("ImageDAO.update() - 이미지 정보 수정 완료.");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new Exception("ImageDAO.update() - 이미지 정보 수정 DB 처리 중 오류");
			} finally {
				DBInfo.close(con, pstmt);
			}
			
			return result;
		}
	
	// 4-2. 타임라인 파일 정보 수정 - 번호, 파일명
	public int updateFile(TimelineVO vo) throws Exception {
		int result = 0;
		
		try {
			//1.2.
			con = DBInfo.getConnection();
			//3.4.
			pstmt = con.prepareStatement(DBSQL.TIMELINE_UPDATE_FILE);
			pstmt.setString(1, vo.getFileName());
			pstmt.setLong(2, vo.getNo());
			
			//5. 
			result = pstmt.executeUpdate();
			
			// 6.
			System.out.println("TimelineDAO.updateFile() - 타임라인 파일 수정 완료.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("타임라인 파일 수정 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
	// 5. 타임라인 게시판 삭제
	public int delete(Long no) throws Exception {
		int result = 0;
		
		try {
			//1.2.
			con = DBInfo.getConnection();
			//3.4.
			pstmt = con.prepareStatement(DBSQL.TIMELINE_DELETE);
			pstmt.setLong(1, no);
			
			//5. 
			result = pstmt.executeUpdate();
			
			// 6.
			System.out.println("TimelineDAO.delete() - 타임라인 게시판 삭제 완료.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("타임라인 게시판 삭제 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
}