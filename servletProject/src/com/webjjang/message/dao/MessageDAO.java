package com.webjjang.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.message.vo.MessageVO;
import com.webjjang.util.PageObject;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class MessageDAO {
	
	// 필요한 객체
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1. 게시판 리스트
		public List<MessageVO> list(PageObject pageObject) throws Exception {
			
			// 넘어오는 데이터 확인
			System.out.println("MessageDAO.list().pageObject : " + pageObject);
			
			List<MessageVO> list = null;
			
			try {
				// 1. 드라이버 확인 + 2. 연결
				con = DBInfo.getConnection();
				System.out.println("MessageDAO.list().con : " + con);
				
				// 3. SQL -> DBSQL + 4. 실행객체 + 데이터 셋팅
				System.out.println("MessageDAO.list().DBSQL.MESSAGE_LIST : " + DBSQL.MESSAGE_LIST);
				pstmt = con.prepareStatement(DBSQL.MESSAGE_LIST);
				System.out.println("MessageDAO.list().pstmt: " + pstmt);
				pstmt.setString(1, pageObject.getAccepter()); // 시작 번호
				pstmt.setString(2, pageObject.getAccepter()); // 끝 번호
				pstmt.setLong(3, pageObject.getStartRow()); // 끝 번호
				pstmt.setLong(4, pageObject.getEndRow()); // 끝 번호
				
				// 5. 실행
				rs = pstmt.executeQuery();
				System.out.println("MessageDAO.list().rs: " + rs);
				
				// 6. 표시 -> 데이터 담기
				if(rs != null) {
					while(rs.next()) {
						if(list == null) list = new ArrayList<>();
						MessageVO vo= new MessageVO();
						vo.setNo(rs.getLong("no"));
						vo.setSender(rs.getString("sender"));
						vo.setSendDate(rs.getString("sendDate"));
						vo.setAccepter(rs.getString("Accepter"));
						vo.setAcceptDate(rs.getString("acceptDate"));
						list.add(vo);
						System.out.println("MessageDAO.list().while().vo: " + vo);
					}
				}
				
			}catch (Exception e) {
					// TODO: handle exception
				// 개발자를 위한 오류 출력
				e.printStackTrace();
				// 사용자를 위한 오류 출력
				throw new Exception("메시지 리스트 실행 중 DB처리 오류 발생");
			} finally {
				// 7. 닫기
				DBInfo.close(con, pstmt, rs);
				
			}
			System.out.println("MessageDAO.list().list : " + list);
			return list;
		} // end of list()
		
		// 1-1. 전체 데이터 갯수 구하기
		public long getTotalRow() throws Exception {
			System.out.println("MessageDAO.getTotalRow()");
			
			long result = 0;
			
			try {
				// 1.2.
				con = DBInfo.getConnection();
				System.out.println("MessageDAO.getTotalRow().con : " + con);
				// 3.4.
				// 쿼리 확인
				System.out.println("MessageDAO.getTotalRow().DBSQL.BOARD_GET_TOTALROW : "
							+ DBSQL.MESSAGE_GET_TOTALROW);
				pstmt = con.prepareStatement(DBSQL.MESSAGE_GET_TOTALROW);
				System.out.println("MessageDAO.getTotalRow().pstmt : " + pstmt);
				// 5.
				// rs는 출력해 볼 수 있다. 그러나 rs.next()를 출력하면 데이터틀 한 개 넘기게 되므로 출력하지 않는다.
				rs = pstmt.executeQuery();
				System.out.println("MessageDAODAO.getTotalRow().rs : " + rs);
				// 6.
				if(rs != null && rs.next()) {
					result = rs.getLong(1);
					System.out.println("MessageDAO.getTotalRow().result : " + result);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new Exception("메시지 데이터 전체 갯수를 가져오는 DB처리중 오류발생");
			} finally {
				DBInfo.close(con, pstmt, rs);
			}
			System.out.println("MessageDAO.getTotalRow().result : " + result);
			return result;
		} // end of getTotalRow()
		
		// 2. 메시지 보내기
		public int write(MessageVO vo) throws Exception {
			int result = 0;
			
			try {
				// 1. 드라이버 확인 + 2. 연결
				con = DBInfo.getConnection();
				
				// 3. SQL -> DBSQL + 4. 실행객체 + 데이터 셋팅
				pstmt = con.prepareStatement(DBSQL.MESSAGE_WRITE);
				pstmt.setString(1, vo.getSender()); // 시작 번호
				pstmt.setString(2, vo.getContent()); // 시작 번호
				pstmt.setString(3, vo.getAccepter()); // 시작 번호
				
				// 5. 실행 - 데이터 한 개, 반복문 필요없음
				result = pstmt.executeUpdate();
				
				// 6. 표시 -> 데이터 담기
				System.out.println("MessageDAO.write() - 메시지 보내기 완료");
				
			}catch (Exception e) {
				// TODO: handle exception
				// 개발자를 위한 오류 출력
				e.printStackTrace();
				// 사용자를 위한 오류 출력
				throw new Exception("메시지 보내기 실행 중 DB처리 오류 발생");
			} finally {
				// 7. 닫기
				DBInfo.close(con, pstmt);
				
			}
			
			return result;
		}
		
		// 메시지 읽음 처리
		public int viewUpdateReaded(MessageVO vo) throws Exception {

			int result = 0;
			
			try {
				// 1. 드라이버 확인 + 2. 연결
				con = DBInfo.getConnection();
				
				// 3. SQL -> DBSQL + 4. 실행객체 + 데이터 셋팅
				pstmt = con.prepareStatement(DBSQL.MESSAGE_VIEW_READ);
				pstmt.setLong(1, vo.getNo()); // 시작 번호
				pstmt.setString(2, vo.getAccepter()); // 시작 번호
				
				// 5. 실행 - 데이터 한 개, 반복문 필요없음
				result = pstmt.executeUpdate();
				
				// 6. 표시 -> 데이터 담기
				System.out.println("MessageDAO.viewUpdateReaded() - 메시지 읽음 처리 완료");
				
			}catch (Exception e) {
				// TODO: handle exception
				// 개발자를 위한 오류 출력
				e.printStackTrace();
				// 사용자를 위한 오류 출력
				throw new Exception("메시지 읽음 처리 중 DB처리 오류 발생");
			} finally {
				// 7. 닫기
				DBInfo.close(con, pstmt);
				
			}
			
			return result;
		}

		// 메시지 읽기
		public MessageVO view(long no) throws Exception {
			MessageVO vo = null;
			
			try {
				// 1. 드라이버 확인 + 2. 연결
				con = DBInfo.getConnection();
				
				// 3. SQL -> DBSQL + 4. 실행객체 + 데이터 셋팅
				System.out.println(DBSQL.MESSAGE_VIEW);
				pstmt = con.prepareStatement(DBSQL.MESSAGE_VIEW);
				pstmt.setLong(1, no); // 시작 번호
				
				// 5. 실행 - 데이터 한 개, 반복문 필요없음
				rs = pstmt.executeQuery();
				// 데이터를 한개만 가져오므로 반복문이 필요없어서 조건2개를 합친다
				// 6. 표시 -> 데이터 담기
				if(rs != null && rs.next()) {
					// 위에서 선언한 vo객체를 재활용.
					vo = new MessageVO();
					vo.setNo(rs.getLong("no"));
					vo.setContent(rs.getString("content"));
					vo.setSender(rs.getString("sender"));
					vo.setSendDate(rs.getString("sendDate"));
					vo.setAccepter(rs.getString("accepter"));
					vo.setAcceptDate(rs.getString("acceptDate"));
				}
				
			}catch (Exception e) {
					// TODO: handle exception
				// 개발자를 위한 오류 출력
				e.printStackTrace();
				// 사용자를 위한 오류 출력
				throw new Exception("메시지 보기 실행 중 DB처리 오류 발생");
			} finally {
				// 7. 닫기
				DBInfo.close(con, pstmt, rs);
				
			}
			
			return vo;
		} // end of view()
				
		// 메시지 삭제
		public int delete(long no) throws Exception {
			int result = 0;
			try {
				// 1. 드라이버 확인 + 2. 연결객체
				con = DBInfo.getConnection();
				// 3. sql + 4. 실행객체 & 데이터 셋팅
				pstmt = con.prepareStatement(DBSQL.MESSAGE_DELETE);
				pstmt.setLong(1, no);
				// 5. 실행
				result = pstmt.executeUpdate();
				// 6. 출력
				if(result == 1)
					System.out.println("메시지 삭제 처리를 완료했습니다.");
				else
					System.out.println("삭제하려는 메시지의 정보를 다시 확인하세요.");
				
			}catch (Exception e) {
				// TODO: handle exception
				// 개발자를 위한 예외출력(500) -> 콘솔
				e.printStackTrace();
				// 사용자를 위한 오류 출력 -> jsp까지 전달된다.
				throw new Exception("메시지 삭제 실행 중 DB처리 오류 발생");
			} finally {
				DBInfo.close(con, pstmt);
			}
			return result;
		}
}

