package com.OOTD.image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.OOTD.image.vo.ImageReplyVO;
import com.OOTD.image.vo.ImageVO;
import com.OOTD.util.PageObject;
import com.OOTD.util.db.DBInfo;
import com.OOTD.util.db.DBSQL;

public class ImageDAO {
	
	// 필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1.이미지 리스트
	public List<ImageVO> list(PageObject pageObject) throws Exception{
		
		// 넘어오는 데이터 확인
		System.out.println("ImageDAO.list().pageObject : " + "pageObject");
		
		List<ImageVO> list = null;
		
		try {
			// 1.드라이버 확인 + 2.연결객체
			con = DBInfo.getConnection();
			System.out.println("ImageDAO.list().con : " + "con");
			// 3.sql 작성 -> DBSQL에서 작성 완료 + 4.실행 객체+데이터 셋팅
			System.out.println("DBSQL.IMAGE_LIST : " + DBSQL.IMAGE_LIST);
			pstmt = con.prepareStatement(DBSQL.IMAGE_LIST);
			//pstmt.setLong(1, 1); // 가져올 데이터의 시작 번호
			//pstmt.setLong(2, 10); // 가져올 데이터의 끝 번호
			pstmt.setLong(1, pageObject.getSeasonNo());
			pstmt.setLong(2, pageObject.getStartRow()); // 가져올 데이터의 시작 번호
			pstmt.setLong(3, pageObject.getEndRow()); // 가져올 데이터의 끝 번호
			// 5.실행
			rs = pstmt.executeQuery();
			// 6.데이터 표시 -> 데이터 담기
			if(rs != null) {
				while(rs.next()) {
					if(list == null) 
						list = new ArrayList<ImageVO>();
					ImageVO vo = new ImageVO();
					vo.setNo(rs.getLong("no"));
					vo.setFileName(rs.getString("fileName"));
//					vo.setSeasonNo(rs.getLong("seasonNo"));
					
					list.add(vo);
					System.out.println("ImageDAO.list()while().vo : " + vo);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("이미지 리스트 실행 중 DB 처리 오류");
		}finally {
			// 7.닫기
			DBInfo.close(con, pstmt, rs);
		}
		
		System.out.println("ImageDAO.getTotalRow().list : " + list);
		return list;
	}
	
	// 1-1. 이미지 전체 데이터 갯수
	public long getTotalRow(PageObject pageObject) throws Exception {
		System.out.println("ImageDAO.getTotalRow() 실행 중");
		long result = 0;
		
		try {
			// 1. 2.
			con = DBInfo.getConnection();
			System.out.println("ImageDAO.getTotalRow().con : " + con);
			// 3. 4.
			// 쿼리 확인
			System.out.println("ImageDAO.getTotalRow().DBSQL.IMAGE_GET_TOTALROW : " + DBSQL.IMAGE_GET_TOTALROW);
			pstmt = con.prepareStatement(DBSQL.IMAGE_GET_TOTALROW);
			pstmt.setInt(1, pageObject.getSeasonNo());
			System.out.println("ImageDAO.getTotalRow().pstmt : " + pstmt);
			
			// 5.실행
			// rs는 출력해 볼 수 있지만 rs.next는 출력할 수 없다. 출력하면 데이터를 한 개 넘기게 된다.
			rs = pstmt.executeQuery();
			System.out.println("ImageDAO.getTotalRow().rs : " + rs);
			// 6.
			if(rs != null && rs.next()) {
				result = rs.getLong(1); //  첫번째 데이터
				System.out.println("ImageDAO.getTotalRow().result : " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("이미지 데이터 전체 갯수를 가져오는 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		System.out.println("ImageDAO.getTotalRow().result : " + result);
		return result;
	}
	
	// 2. 이미지 보기
	public ImageVO view(Long no) throws Exception {
		System.out.println("ImageDAO.view() 실행 중");
		ImageVO vo = null;
		
		try {
			// 1. 2.
			con = DBInfo.getConnection();
			System.out.println("ImageDAO.view().con : " + con);
			// 3. 4.
			// 쿼리 확인
			System.out.println("ImageDAO.view().DBSQL.IMAGE_VIEW : " + DBSQL.IMAGE_VIEW);
			pstmt = con.prepareStatement(DBSQL.IMAGE_VIEW);
			pstmt.setLong(1, no);
			System.out.println("ImageDAO.view().pstmt : " + pstmt);
			// 5.실행
			// rs는 출력해 볼 수 있지만 rs.next는 출력할 수 없다. 출력하면 데이터를 한 개 넘기게 된다.
			rs = pstmt.executeQuery();
			System.out.println("ImageDAO.view().rs : " + rs);
			// 6.
			if(rs != null && rs.next()) {
				vo = new ImageVO();
				vo.setNo(rs.getLong("no"));
				vo.setName1(rs.getString("name1"));
				vo.setLink1(rs.getString("link1"));
				vo.setName2(rs.getString("name2"));
				vo.setLink2(rs.getString("link2"));
				vo.setName3(rs.getString("name3"));
				vo.setLink3(rs.getString("link3"));
				vo.setName4(rs.getString("name4"));
				vo.setLink4(rs.getString("link4"));
				vo.setFileName(rs.getString("fileName"));
				System.out.println("ImageDAO.view().vo : " + vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("이미지 보기 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		System.out.println("ImageDAO.view().vo : " + vo);
		return vo;
	}
	
	// 3.이미지 등록
	public int write(ImageVO vo) throws Exception {
		int result = 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4.
			pstmt = con.prepareStatement(DBSQL.IMAGE_WRITE);
			pstmt.setLong(1, vo.getSeasonNo());
			pstmt.setString(2, vo.getName1());
			pstmt.setString(3, vo.getLink1());
			pstmt.setString(4, vo.getName2());
			pstmt.setString(5, vo.getLink2());
			pstmt.setString(6, vo.getName3());
			pstmt.setString(7, vo.getLink3());
			pstmt.setString(8, vo.getName4());
			pstmt.setString(9, vo.getLink4());
			pstmt.setString(10, vo.getFileName());
			// 5.
			result = pstmt.executeUpdate();
			// 6.
			System.out.println("ImageDAO.write() - 이미지 등록 완료-----------------------------------------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("이미지 등록 DB 처리 중 오류 발생");
		}finally {
			DBInfo.close(con, pstmt);	
		}
		
		return result;
	}
	
	// 4-1.이미지 파일정보 수정 - 번호, 파일명 필요
	public int updateFile(ImageVO vo) throws Exception {
		int result = 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4.
			pstmt = con.prepareStatement(DBSQL.IMAGE_UPDATE_FILE);
			pstmt.setString(1, vo.getFileName());
			pstmt.setLong(2, vo.getNo());
			// 5.
			result = pstmt.executeUpdate();
			// 6.
			System.out.println("ImageDAO.updateFile() - 이미지 파일 수정 완료-----------------------------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("ImageDAO.updateFile() - 이미지 파일 수정 DB 처리 중 오류 발생");
		}finally {
			DBInfo.close(con, pstmt);	
		}
		
		return result;
	}
	
	// 4-2.이미지 글정보수정
	public int update(ImageVO vo) throws Exception {
		int result = 0;
		try {
			// 1.드라이버 확인 + 2.연결객체
			con = DBInfo.getConnection();
			// 3.sql 작성 -> DBSQL에서 작성 완료 + 4.실행 객체+데이터 셋팅
			System.out.println("ImageDAO.update.DBSQL.IMAGE_UPDATE : " + DBSQL.IMAGE_UPDATE);
			pstmt = con.prepareStatement(DBSQL.IMAGE_UPDATE);
			pstmt.setString(1, vo.getName1());
			pstmt.setString(2, vo.getLink1());
			pstmt.setString(3, vo.getName2());
			pstmt.setString(4, vo.getLink2());
			pstmt.setString(5, vo.getName3());
			pstmt.setString(6, vo.getLink3());
			pstmt.setString(7, vo.getName4());
			pstmt.setString(8, vo.getLink4());
			pstmt.setLong(9, vo.getSeasonNo());
			pstmt.setLong(10, vo.getNo());
			System.out.println("ImageDAO.update() 05:21 실행 중----------------------");
			System.out.println("ImageDAO.update() [pstmt] : " + pstmt);
			// 5.실행 -> 데이터가 한 개 나오므로 반복문 필요 없음
			result = pstmt.executeUpdate();
			System.out.println("ImageDAO.update [result] : " + result);
			// 6.데이터 표시 -> 데이터 담기
			System.out.println("이미지 글정보 수정 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 글수정 실행 중 DB 처리 오류");
		}finally {
			// 7.닫기
			DBInfo.close(con, pstmt);
		}
		return result;
	}
	
	// 5.이미지 게시글 삭제
	public int delete(Long no) throws Exception {
		int result = 0;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4.
			pstmt = con.prepareStatement(DBSQL.IMAGE_DELETE);
			pstmt.setLong(1, no);
			// 5.
			result = pstmt.executeUpdate();
			// 6.
			System.out.println("ImageDAO.delete() - 이미지 게시글 삭제 완료-----------------------------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("ImageDAO.delete() - 이미지 게시글 삭제 DB 처리 중 오류 발생");
		}finally {
			DBInfo.close(con, pstmt);	
		}
		
		return result;
	}

	// 6. 게시판 댓글 리스트
	public List<ImageReplyVO> replyList(Long no, PageObject pageObject) throws Exception {
		
		// 넘어오는 데이터 확인
		System.out.println("ImageDAO.replyList() [no] : " + no + "[pageObject]" + pageObject);
	
		List<ImageReplyVO> list = null;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3. 4.
			System.out.println("ImageDAO.replyList() [DBSQL] : " + DBSQL.IMAGE_REPLY_LIST);
			pstmt = con.prepareStatement(DBSQL.IMAGE_REPLY_LIST);
			pstmt.setLong(1, no);
			pstmt.setLong(2, 1);
			pstmt.setLong(3, 10);
			// 5.
			rs = pstmt.executeQuery();
			System.out.println("ImageDAO.replyList() [rs] : " + rs);
			// 6.
			if(rs != null) {
			while(rs.next()) {
				if(list == null) 
					list = new ArrayList<ImageReplyVO>();
				ImageReplyVO vo = new ImageReplyVO();
				vo.setRno(rs.getLong("rno"));
				vo.setNo(rs.getLong("no"));
				vo.setContent(rs.getString("content"));
				vo.setAlias(rs.getString("alias"));
				vo.setWriteDate(rs.getString("writeDate"));
				
				list.add(vo);
				//System.out.println("BoardDAO.replyList()while().vo : " + vo);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("ImageDAO.replyList() - 이미지게시판 댓글리스트 실행 중 DB 처리 오류");
		} finally {
			DBInfo.close(con, pstmt);
		}
		
		return list;
	}
	
	// 6-1. 글번호에 맞는 전체 데이터 갯수구하기
	public long getReplyTotalRow(Long no) throws Exception {
		System.out.println("ImageDAO.getReplyTotalRow() 실행중");
		System.out.println("ImageDAO.getReplyTotalRow() [no] : " + no);
		
		long result = 0;
		
		try {
			// 1. 2.
			con = DBInfo.getConnection();
			// 3. 4.
			System.out.println("ImageDAO.getReplyTotalRow [DBSQL.IMAGE_GET_REPLY_TOTALROW] : " + DBSQL.IMAGE_GET_REPLY_TOTALROW);
			pstmt = con.prepareStatement(DBSQL.IMAGE_GET_REPLY_TOTALROW);
			pstmt.setLong(1, no);
			// 5.
			rs = pstmt.executeQuery();
			System.out.println("ImageDAO.getReplyTotalRow.rs : " + rs);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("ImageDAO.getReplyTotalRow() - 게시판 데이터 전체 갯수가져오기 실행 중 DB 처리오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		return result;
	}
	
	// 7. 게시판 댓글 등록
	public int replyWrite(ImageReplyVO vo) throws Exception {
		int result = 0;
		
		try {
			// 1. 2.
			con = DBInfo.getConnection();
			// 3. 4.
			System.out.println("ImageDAO.replyWrite() [DBSQL.IMAGE_REPLY_WRITE] : " + DBSQL.IMAGE_REPLY_WRITE);
			pstmt = con.prepareStatement(DBSQL.IMAGE_REPLY_WRITE);
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getAlias());
			// 5.
			result = pstmt.executeUpdate();
			// 6.
			System.out.println("ImageDAO.replyWrite() - 게시판 댓글 등록 성공");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("ImageDAO - 이미지게시판 댓글등록 실행 중 DB처리 오류");
		} finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}

	// 8. 게시판 댓글 수정
	public int replyUpdate(ImageReplyVO vo) throws Exception {
		int result = 0;
		try {
			// 1.드라이버 확인 + 2.연결객체
			con = DBInfo.getConnection();
			// 3.sql 작성 -> DBSQL에서 작성 완료 + 4.실행 객체+데이터 셋팅
			System.out.println("ImageDAO.replyUpdate.DBSQL.IMAGE_REPLY_UPDATE : " + DBSQL.IMAGE_REPLY_UPDATE);
			pstmt = con.prepareStatement(DBSQL.IMAGE_REPLY_UPDATE);
			pstmt.setString(1, vo.getContent());
			pstmt.setString(2, vo.getAlias());
			pstmt.setLong(3, vo.getRno());
			pstmt.setLong(4, vo.getNo());
			System.out.println("ImageDAO.replyUpdate() [pstmt] : " + pstmt);
			// 5.실행 -> 데이터가 한 개 나오므로 반복문 필요 없음
			result = pstmt.executeUpdate();
			System.out.println("ImageDAO.update [result] : " + result);
			// 6.데이터 표시 -> 데이터 담기
			System.out.println("이미지 댓글 수정 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 댓글수정 실행 중 DB 처리 오류");
		}finally {
			// 7.닫기
			DBInfo.close(con, pstmt);
		}
		return result;
	}
	
	// 9. 게시판 댓글 삭제
	public int replyDelete(ImageReplyVO vo) throws Exception {
		int result = 0;
		
		try {
			// 1.드라이버 확인 + 2.연결객체
			con = DBInfo.getConnection();
			// 3.sql 작성 -> DBSQL에서 작성 완료 + 4.실행 객체+데이터 셋팅
			System.out.println("ImageDAO.replyUpdate.DBSQL.IMAGE_REPLY_DELETE : " + DBSQL.IMAGE_REPLY_DELETE);
			pstmt = con.prepareStatement(DBSQL.IMAGE_REPLY_DELETE);
			pstmt.setLong(1, vo.getRno());
			pstmt.setLong(2, vo.getNo());
			System.out.println("ImageDAO.replyDelete() [pstmt] : " + pstmt);
			// 5.실행 -> 데이터가 한 개 나오므로 반복문 필요 없음
			result = pstmt.executeUpdate();
			System.out.println("ImageDAO.replyDelete [result] : " + result);
			// 6.데이터 표시 -> 데이터 담기
			System.out.println("이미지 댓글 삭제 성공");
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("게시판 댓글 삭제 실행 중 DB 처리 오류");
		} finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
		
	}
	
}
