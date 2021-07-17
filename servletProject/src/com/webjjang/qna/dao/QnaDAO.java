package com.webjjang.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.qna.vo.QnaVO;
import com.webjjang.util.PageObject;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class QnaDAO {
	
	// 필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1. list
	public List<QnaVO> list(PageObject pageObject) throws Exception{
		List<QnaVO> list = null;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4
			pstmt = con.prepareStatement(DBSQL.QNA_LIST);
			pstmt.setLong(1, pageObject.getStartRow());
			pstmt.setLong(2, pageObject.getEndRow());
			// 5.
			rs = pstmt.executeQuery();
			
			// 6.
			if(rs != null) {
				while(rs.next()) {
					if(list == null)list = new ArrayList<>();
					QnaVO vo = new QnaVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setName(rs.getString("name"));
					vo.setId(rs.getString("id"));
					vo.setWriteDate(rs.getString("writeDate"));
					vo.setHit(rs.getLong("hit"));
					vo.setLevNo(rs.getLong("levNo"));
					System.out.println("QnaDAO.list().vo : " + vo);
					list.add(vo);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 리스트 DB처리중 오류발생");
		}finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	// 1-1 전체데이터 - getTotalRow
	public Long getTotalRow() throws Exception{
		Long result = 0L;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4
			pstmt = con.prepareStatement(DBSQL.QNA_GET_TOTALROW);
			// 5.
			rs = pstmt.executeQuery();
			
			// 6.
			if(rs != null && rs.next()) {
				result = rs.getLong(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 전체데이터 DB처리중 오류발생");
		}finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		return result;
	}
	
	// 2. 질문답변 보기 
	public QnaVO view(Long no) throws Exception{
		QnaVO vo = null;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4
			pstmt = con.prepareStatement(DBSQL.QNA_VIEW);
			pstmt.setLong(1, no);
			// 5.
			rs = pstmt.executeQuery();
			
			// 6.
			if(rs != null && rs.next()) {
				vo = new QnaVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setWriteDate(rs.getString("writeDate"));
				vo.setHit(rs.getLong("hit"));
				// 글보기 할 때는 관련글번호, 순서번호, 들여쓰기 정보를 필요로 하지 않아서 버린다.
				// 답변쓰기 할 때는 이러한 정보들이 필요하다. 그래서 일단 담아놓는다.
				vo.setRefNo(rs.getLong("refNo"));
				vo.setOrdNo(rs.getLong("ordNo"));
				vo.setLevNo(rs.getLong("levNo"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 글보기 DB처리중 오류발생");
		}finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		return vo;
	}
	
	// 2-1. 질문답변 조회수 1 증가
	public int increase(Long no) throws Exception{
		int result = 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4
			pstmt = con.prepareStatement(DBSQL.QNA_INCREASE);
			pstmt.setLong(1, no);
			// 5.
			result = pstmt.executeUpdate();
			
			// 6.
			System.out.println("조회수 1 증가 완료");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 보기의 조회수 1 증가 처리중 오류발생");
		}finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
	// 3-1 질문하기 - question : 제목, 내용 -> 사용자 입력/ 아이디 -> session의 로그인 정보
	public int question(QnaVO vo) throws Exception{
		int result= 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4
			pstmt = con.prepareStatement(DBSQL.QNA_QUESTION);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getId());
			// 5.
			result = pstmt.executeUpdate();
			
			// 6.
			System.out.println("QnaDAO.question() - 질문등록 완료");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문등록 중 DB처리중 오류발생");
		}finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	

	// 3-2 답변하기 - answer : 제목, 내용 -> 사용자 입력/ 아이디 -> session의 로그인 정보
	// 관련 글번호, 순서번호, 들여쓰기, 부모글번호 -> 전달 받는다.
	public int answer(QnaVO vo) throws Exception{
		int result= 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4
			pstmt = con.prepareStatement(DBSQL.QNA_ANSWER);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getId());
			pstmt.setLong(4, vo.getRefNo());
			pstmt.setLong(5, vo.getOrdNo());
			pstmt.setLong(6, vo.getLevNo());
			pstmt.setLong(7, vo.getParentNo());
			
			// 5.
			result = pstmt.executeUpdate();
			
			// 6.
			System.out.println("QnaDAO.question() - 답변등록 완료");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("답변등록 중 DB처리중 오류발생");
		}finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
	// 3-3. 답변하기 순서번호 1 증가
	public int ordNoIncrease(QnaVO vo) throws Exception{
		int result = 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4
			pstmt = con.prepareStatement(DBSQL.QNA_ANSWER_INCREASE_ORDNO);
			pstmt.setLong(1, vo.getRefNo());
			pstmt.setLong(2, vo.getOrdNo());
			// 5.
			result = pstmt.executeUpdate();
			
			// 6.
			System.out.println("답변하기 순서번호 1 증가 완료");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("질문답변 순서번호 1 증가 처리중 오류발생");
		}finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
		
	// 삭제하기
	// 공지 글삭제 -----------------------------
	public int delete(long no) throws Exception{
		
		// 실행한 결과를 저장하는 객체 선언
		int result = 0;
		
		try {
			//1. 드라이버 확인 - DBInfo의 static 초기화 블록에서 처리함. - main() 처음 시작할때 처리 : 한번만
			//2. 연결객체
			con = DBInfo.getConnection();
			//3. 쿼리 작성 - DBSQL에 선언됨. - 확인
			System.out.println(DBSQL.QNA_DELETE);
			//4. 실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(DBSQL.QNA_DELETE);
			pstmt.setLong(1, no);
			// 5. 실행 - delete -> 결과가 int
			result = pstmt.executeUpdate();
			// 6. 출력 -> 데이터 저장 후 리턴 -> 데이터 한개
			System.out.println("qnaDAO.delete() : 글삭제 완료");
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace(); // 게발자를 위한 출력
			throw new Exception("질문답변 글삭제 처리 중 DB 오류가 발생되었습니다."); // NoticeController에서 예외처리를 위한 처리
		} finally {
			//7. 닫기
			DBInfo.close(con, pstmt, rs);
		} // end of try~catch ~finally
		
	} // end of delete()
}
