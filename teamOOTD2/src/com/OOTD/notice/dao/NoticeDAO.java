package com.OOTD.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.OOTD.notice.vo.NoticeVO;
import com.OOTD.util.PageObject;
import com.OOTD.util.db.DBInfo;
import com.OOTD.util.db.DBSQL;

public class NoticeDAO {

	// 필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 공지사항 리스트
	public List<NoticeVO> list(PageObject pageObject) throws Exception{
		System.out.println("NoticeDAO.list().pageObect : " + pageObject);
		List<NoticeVO> list = null;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4.
			String period = pageObject.getPeriod();
			String sql = "";
			if(period.equals("pre")) sql = DBSQL.NOTICE_LIST_PRE;
			else if(period.equals("old")) sql = DBSQL.NOTICE_LIST_OLD;
			else if(period.equals("res")) sql = DBSQL.NOTICE_LIST_RES;
			else if(period.equals("all")) sql = DBSQL.NOTICE_LIST_ALL;
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, pageObject.getStartRow());
			pstmt.setLong(2, pageObject.getEndRow());
			//5. 
			rs = pstmt.executeQuery();
			//6.
			if(rs != null) {
				while(rs.next()) {
					if(list == null) list = new ArrayList<>();
					NoticeVO vo = new NoticeVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setStartDate(rs.getString("startDate"));
					vo.setEndDate(rs.getString("endDate"));
					vo.setUpdateDate(rs.getString("updateDate"));
					list.add(vo);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("공지사항 리스트 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	// 공지사항 전체 데이터 갯수 가져오기
	public long getTotalRow(PageObject pageObject) throws Exception{
		System.out.println("NoticeDAO.getTotalRow()");
		long result = 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4.
			// 공지 구분을 처리하는 조건을 붙이기
			String period = pageObject.getPeriod();
			String sql = DBSQL.NOTICE_GET_TOTALROW;
			if(period.equals("pre"))
				sql += " where startDate < sysdate and endDate >= trunc(sysdate) ";
			else if(period.equals("old"))
				sql += " where endDate < trunc(sysdate) ";
			else if(period.equals("res"))
				sql += " where startDate > sysdate ";
			else if(period.equals("all")) ;
			pstmt = con.prepareStatement(sql);
			//5. 
			rs = pstmt.executeQuery();
			//6.
			if(rs != null && rs.next()) {
				result = rs.getLong(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("공지사항 전체 데이터 가져오기 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		return result;
	} // end of getTotalRow()
	
	// 공지 등록 처리
	public int write(NoticeVO vo) throws Exception {
		int result = 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4.
			pstmt = con.prepareStatement(DBSQL.NOTICE_WRITE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate());
			//5.
			result = pstmt.executeUpdate();
			//6.
			System.out.println("NoticeDAO.write() - 공지등록 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("공지 등록 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	// 공지 글보기 -----------------------------
		public NoticeVO view(long no) throws Exception{
			
			// 실행한 결과를 저장하는 객체 선언
			NoticeVO vo = null;
			
			// DB의 정보는 DBInfo 객체이 넣어놨다.
			
			try {
				// 1. 드라이버 확인 - DBInfo의 static 초기화 블록에서 처리함. - main() 처음 시작할때 처리 : 한번만
				// 2. 연결객체
				con = DBInfo.getConnection();
				// 3. 쿼리 작성 - DBSQL에 선언됨. - 확인
				System.out.println(DBSQL.NOTICE_VIEW);
				// 4. 실행객체 & 데이터 셋팅
				pstmt = con.prepareStatement(DBSQL.NOTICE_VIEW);
				pstmt.setLong(1, no);
				// 5. 실행
				rs = pstmt.executeQuery();
				// 6. 출력 -> 데이터 저장 후 리턴 -> 데이터 한개
				if(rs != null & rs.next()) {
					// rs -> vo 저장을 위해 vo 객체 생성
					vo = new NoticeVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					vo.setStartDate(rs.getString("startDate"));
					vo.setEndDate(rs.getString("endDate"));
					vo.setUpdateDate(rs.getString("UpdateDate"));
					
				} // end of if()
				
				return vo;
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("공지 글보기 데이터 처리 중 DB오류가 발생되었습니다.");
			} finally {
				//7. 닫기
				DBInfo.close(con, pstmt, rs);
			} // end of try~catch ~finally
			
		} // end of view()
		// 공지 글수정 -----------------------------
		public int update(NoticeVO vo) throws Exception{
			
			// 실행한 결과를 저장하는 객체 선언
			int result = 0;
			
			try {
				// 1. 드라이버 확인 - DBInfo의 static 초기화 블록에서 처리함. - main() 처음 시작할때 처리 : 한번만
				// 2. 연결객체
				con = DBInfo.getConnection();
				// 3. 쿼리 작성 - DBSQL에 선언됨. - 확인
				System.out.println(DBSQL.NOTICE_UPDATE);
				// 4. 실행객체 & 데이터 셋팅
				pstmt = con.prepareStatement(DBSQL.NOTICE_UPDATE);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getStartDate());
				pstmt.setString(4, vo.getEndDate());
				pstmt.setString(5, vo.getUpdateDate());
				pstmt.setLong(6, vo.getNo());
				// 5. 실행 - update -> 결과가 int
				result = pstmt.executeUpdate();
				// 6. 출력 -> 데이터 저장 후 리턴 -> 데이터 한개
				System.out.println("NoticeDAO.update() : 글수정 완료");
				
			} catch (Exception e) {
				e.printStackTrace(); // 게발자를 위한 출력
				throw new Exception("공지 글쓰기 처리 중 DB오류가 발생되었습니다."); // NoticeController에서 예외처리를 위한 처리
			} finally {
				//7. 닫기
				DBInfo.close(con, pstmt);
			} // end of try~catch ~finally
				return result;
		} // end of update()
		
		
		// 공지 글삭제 -----------------------------
		public int delete(long no) throws Exception{
			
			// 실행한 결과를 저장하는 객체 선언
			int result = 0;
			
			try {
				// 1. 드라이버 확인 - DBInfo의 static 초기화 블록에서 처리함. - main() 처음 시작할때 처리 : 한번만
				// 2. 연결객체
				con = DBInfo.getConnection();
				// 3. 쿼리 작성 - DBSQL에 선언됨. - 확인
				System.out.println(DBSQL.NOTICE_DELETE);
				// 4. 실행객체 & 데이터 셋팅
				pstmt = con.prepareStatement(DBSQL.NOTICE_DELETE);
				pstmt.setLong(1, no);
				// 5. 실행 - delete -> 결과가 int
				result = pstmt.executeUpdate();
				// 6. 출력 -> 데이터 저장 후 리턴 -> 데이터 한개
				System.out.println("NoticeDAO.delete() : 글삭제 완료");
				
				return result;
				
			} catch (Exception e) {
				e.printStackTrace(); // 게발자를 위한 출력
				throw new Exception("공지 글삭제 처리 중 DB 오류가 발생되었습니다."); // NoticeController에서 예외처리를 위한 처리
			} finally {
				// 7. 닫기
				DBInfo.close(con, pstmt);
			} // end of try~catch ~finally
			
		} // end of delete()
	
}
