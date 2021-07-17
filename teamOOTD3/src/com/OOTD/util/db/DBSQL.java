package com.OOTD.util.db;

public class DBSQL {

	// 공지사항 쿼리 =============================================================================
	// 1. 공지 리스트
	// 1-1. 모든 공지
	public static final String NOTICE_LIST_ALL 
	= "select rnum, no, title, "
	+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
	+ " to_char(endDate, 'yyyy-mm-dd') endDate, "
	+ " to_char(writeDate, 'yyyy-mm-dd') writeDate "
	+ " from( "
		+ " select rownum rnum, no, title, startDate, endDate, writeDate from ("
			+ " select no, title, startDate, endDate, writeDate from notice "
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 1-2. 현재 공지
	public static final String NOTICE_LIST_PRE
	= "select rnum, no, title, "
	+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
	+ " to_char(endDate, 'yyyy-mm-dd') endDate, "
	+ " to_char(writeDate, 'yyyy-mm-dd') writeDate "
	+ " from( "
		+ " select rownum rnum, no, title, startDate, endDate, writeDate from ("
			+ " select no, title, startDate, endDate, writeDate from notice "
			+ " where startDate < sysdate and endDate >= trunc(sysdate) "
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 1-3. 지난 공지
	public static final String NOTICE_LIST_OLD 
	= "select rnum, no, title, "
	+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
	+ " to_char(endDate, 'yyyy-mm-dd') endDate, "
	+ " to_char(writeDate, 'yyyy-mm-dd') writeDate "
	+ " from( "
		+ " select rownum rnum, no, title, startDate, endDate, writeDate from ("
			+ " select no, title, startDate, endDate, writeDate from notice "
			+ " where endDate < trunc(sysdate)"
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 1-4. 예약공지
	public static final String NOTICE_LIST_RES
	= "select rnum, no, title, "
	+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
	+ " to_char(endDate, 'yyyy-mm-dd') endDate, "
	+ " to_char(writeDate, 'yyyy-mm-dd') writeDate "
	+ " from( "
		+ " select rownum rnum, no, title, startDate, endDate, writeDate from ("
			+ " select no, title, startDate, endDate, writeDate from notice "
			+ " where startDate > sysdate "
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 1-5. 전체 데이터
	public static final String NOTICE_GET_TOTALROW
	= " select count(*) from notice ";
	
	// 2. 공지 작성
	public static final String NOTICE_WRITE 
	= " insert into notice(no, title, content, startDate, endDate) "
	+ " values(notice_seq.nextval, ?, ?, ?, ?) ";

	// 3. 공지 글보기
	public static final String NOTICE_VIEW
	= "SELECT no, title, content, "
			+ "to_char(startDate, 'yyyy-mm-dd') startDate, "
			+ "to_char(endDate, 'yyyy-mm-dd') endDate, "
			+ "to_char(writeDate, 'yyyy-mm-dd') writeDate "
	+ "FROM notice WHERE no = ? ";
	
	// 4. 공지 수정
	public static final String NOTICE_UPDATE 
	= "UPDATE notice SET title=?, content=?, "
			+ " startDate=?,  endDate=? "
			+ " WHERE no = ? ";
	
	// 5. 공지 삭제
	public static final String NOTICE_DELETE 
	= "DELETE notice WHERE no = ? ";
	
		
	
	// QNA 쿼리 =============================================================================
	// 질문답변 리스트
	public static final String QNA_LIST 
	= "select rnum, no, title, name, id, "
	+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, levNo "
	+ " from( "
		+ " select rownum rnum, no, title, name, id, writeDate, levNo from ("
			+ " select q.no, q.title, m.name, q.id, q.writeDate, q.levNo "
			+ " from qna q, member m "
			+ " where q.id = m.id "
			+ " order by q.refNo desc, q.ordNo "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 전체데이터 출력
	public static final String QNA_GET_TOTALROW
	= " select count(*) from qna ";
	
	//질문 답변 보기 
	public static final String QNA_VIEW
	= " select q.no, q.title, q.content, m.name, q.id, q.writeDate, "
			+ " q.refNo, q.ordNo, q.levNo "
			+ " from qna q, member m "
			+ " where ( q.no = ? ) and ( m.id = q.id ) ";
	
	// 조회수 1증가
	public static final String QNA_INCREASE 
	= " update qna set hit = hit + 1 where no = ? ";
	
	// 질문하기
	public static final String QNA_QUESTION 
	= " insert into qna(no, title, content, id, refNo, ordNo, levNo, parentNo) "
	+ " values(qna_seq.nextval, ?, ?, ?, qna_seq.nextval, 1, 0, qna_seq.nextval) ";
	
	//  답변하기 
	public static final String QNA_ANSWER 
	= " insert into qna(no, title, content, id, refNo, ordNo, levNo, parentNo) "
			+ " values(qna_seq.nextval, ?, ?, ?, ?, ?, ?, ?) ";
	
	//  답변하기의 경우 등록하기 전에 관련글번호가 같고 순서번호가 같거나 큰경우는 순서번호를 1증가 시킨다.
	public static final String QNA_ANSWER_INCREASE_ORDNO 
	= " update qna set ordNo = ordNo + 1 where refNo = ? and ordNo >= ? ";
	
	// 질문답변 글 삭제
	public static final String QNA_DELETE
	= " delete from qna where no = ? ";
	
	
	// 회원관리 쿼리 =============================================================================
	// 로그인 처리
	public static final String MEMBER_LOGIN
	= " select m.id, m.name, m.gradeNo, g.gradeName from member m, grade g "
	+ " where (m.id = ? and m.pw = ?) and (m.gradeNo = g.gradeNo) ";
	
	// 회원리스트 - id, name, gender, birth, tel, status, gradeNo, gradeName
	public static final String MEMBER_LIST 
	= "select rnum, id, name, gender,"
	+ " to_char(birth, 'yyyy.mm.dd') birth, tel, status, gradeNo, gradeName from( "
		+ " select rownum rnum, id, name, gender, birth, tel, status,"
		+ " gradeNo, gradeName from ("
			+ " select m.id, m.name, m.gender, m.birth, m.tel, m.status,"
			+ " m.gradeNo, g.gradeName"
			+ " from member m, grade g "
			+ " where m.gradeNo = g.gradeNo "
			+ " order by id "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 회원 정보 보기
	public static final String MEMBER_VIEW
	= "select m.id, m.name, m.gender, "
			+ " to_char(m.birth, 'yyyy.mm.dd') birth, m.tel, m.email, "
			+ " to_char(m.regDate,'yyyy.mm.dd') regDate, m.status, m.gradeNo, g.gradeName "
			+ " from member m, grade g where (m.id = ?) and (m.gradeNo = g.gradeNo)";
	
	// 회원 가입
	public static final String MEMBER_WRITE
	= " insert into member(id, pw, name, alias, gender, birth, tel, email) " + 
			" VALUES(?, ?, ?, ?, ?, ?, ?, ?) ";
	
	// 아이디 중복 체크
	public static final String MEMBER_CHECK_ID
	= "select id from member where id = ?";
	
	
	// 타임라인 쿼리 =============================================================================
	// 1. 타임라인 리스트 - 번호, 제목, 작성자이름(작성자ID), 작성일, 파일명
	public static final String TIMELINE_LIST 
	= "select rnum, no, title, id, "
	+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, fileName, hit "
	+ " from( "
		+ " select rownum rnum, no, title, id, writeDate, fileName, hit from ("
			+ " select t.no, t.title, m.id, t.writeDate, t.fileName, t.hit "
			+ " from timeline t, member m "
			+ " where t.id = m.id "
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 1-1. 전체 데이터 갯수 - 페이지 처리 : 리스트
	public static final String TIMELINE_GET_TOTALROW
	= " select count(*) from timeline ";
	
	// 2. 타임라인 보기 - 번호, 제목, 내용, 이름, 아이디, 작성일, 파일명
	public static final String TIMELINE_VIEW
	= " select t.no, t.title, t.content, m.id, "
			+ " to_char(t.writeDate, 'yyyy.dd.mm') writeDate, t.fileName, t.hit "
			+ " from timeline t, member m "
			+ " where (no = ?) and (t.id = m.id) ";  
	
	// 2-1 타임라인 조회수 1증가
	public static final String TIMELINE_INCREASE
	= " update timeline set hit = hit + 1 where no = ? ";
	
	// 3. 타임라인 등록 - 번호, 제목, 내용, 작성자ID, 파일명
	public static final String TIMELINE_WRITE 
	= " insert into timeline(no, title, content, id, fileName) "
	+ " values(timeline_seq.nextval, ?, ?, ?, ?) ";
	
	// 4-1. 타임라인 수정
	public static final String TIMELINE_UPDATE 
	= " update image set title = ?, content = ? where no = ? ";
	
	// 4-2. 타임라인 이미지 파일 정보 수정 - 파일 바꾸기
	public static final String TIMELINE_UPDATE_FILE 
	= " update timeline set fileName = ? where no = ? ";
	
	// 5. 타임라인 삭제
	public static final String TIMELINE_DELETE 
	= " delete from timeline where no = ? ";
	
	// 6. 게시판 댓글 리스트
	public static final String TIMELINE_REPLY_LIST 
	= "select rnum, rno, no, content, id,"
			+ " to_char(writeDate, 'yyyy.mm.dd') writeDate from( "
			+ " select rownum rnum,rno, no, content, id, writeDate  from ("
				+ " select rno, no, content, id, writeDate from timeline_reply "
				+ " where no = ? "
				+ " order by rno desc "
			+ " ) "
			+ ") where rnum between ? and ?  ";
	
	// 7. 현개 게시판에 등록된 댓글의 전체 갯수 
	public static final String TIMELINE_GET_REPLY_TOTALROW
	= " select count(*) from timeline_reply"
			+ " where no = ? ";
	
	// 8. 댓글 등록
	public static final String TIMELINE_REPLY_WRITE
	= " insert into timeline_reply(rno, no, content, id) "
			+ " values(board_reply_seq.nextval, ?, ?, ?) ";
	
	// 9. 댓글 수정
	public static final String TIMELINE_REPLY_UPDATE
	= " update timeline_reply set content = ?, id = ? "
			+ " where rno = ? ";
	
	// 10. 댓글 삭제
	public static final String TIMELINE_REPLY_DELETE
	= " delete from timeline_reply where rno = ? ";
	
	
	// 좋아요 쿼리 =============================================================================
	public static final String FASHION_VIEW
	=" SELECT NO,ID FROM FASHION_LIKE WHERE NO =? AND ID= ? ";
	
	public static final String FASHION_LIKE
	=" INSERT INTO FASHION_LIKE (NO,ID) VALUES (?,?)";
	
	public static final String FASHION_CNT
	=" SELECT COUNT(*) CNT FROM FASHION_LIKE WHERE NO =? ";
	
	public static final String FASHION_DELETE
	=" DELETE FROM FASHION_LIKE WHERE NO=? AND ID= ? ";
	
	public static final String TIME_VIEW
	=" SELECT NO,ID,(SELECT COUNT(*) FROM TIME_LIKE FL WHERE (TL.NO = T.NO)AND(TL.ID=M.ID)) "
			+ " CNT FROM TIMELINE T, MEMBER M WHERE (NO = ? AND ID = ?)";
	
	public static final String TIME_LIKE
	=" INSERT INTO TIME_LIKE (NO,ID) VALUES (?,?) ";
	
	
	public static final String TIME_DELETE
	=" DELETE FROM TIME_LIKE WHERE NO =? ";
	
	

	// 패션 쿼리 =============================================================================
	// 1.리스트 - 번호, 제목, 작성자이름(작성자 ID), 작성일, 파일명
	public static final String IMAGE_LIST 
	= "SELECT rnum, no, fileName "
	+ "FROM( "
			+ "SELECT ROWNUM rnum, no, fileName "
			+ "FROM ( "
				+ "SELECT no, fileName "
				+ "FROM fashion "
				+ "ORDER BY no DESC "
			+ ") "
	+ ") "
	+ "WHERE rnum BETWEEN  ? AND ?";
	
	// 1-1. 전체 데이터 갯수 가져오기 - 페이지 처리:리스트
	public static final String IMAGE_GET_TOTALROW
	// notice의 모든 데이터를 가져오기
	= "SELECT COUNT(*) FROM fashion ";
	
	// 2. 이미지 보기 - 번호, 제목, 내용, 이름, 아이디, 작성일, 파일명
	public static final String IMAGE_VIEW
	// notice의 모든 데이터를 가져오기
	= "SELECT no, name1, link1, name2, link2, name3, link3, name4, link4, fileName "
	+ "FROM fashion "
	+ "WHERE no = ? ";
	
	// 3.이미지 등록 - 번호, 제목, 내용, 작성자ID, 파일명
	public static final String IMAGE_WRITE
	= "INSERT INTO fashion (no, seasonNo, name1, link1, name2, link2, name3, link3, name4, link4, fileName) "
	+ "values(fashion_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ? ,? , ? ) ";
	
	// 4-1. 이미지 파일 정보 수정 - 파일 바꾸기
	public static final String IMAGE_UPDATE_FILE
	= "UPDATE fashion set fileName = ?"
	+ "WHERE no = ? ";
	
	// 4-2.이미지 글정보 수정
	public static final String IMAGE_UPDATE 
	= "UPDATE fashion SET name1=?, link1=?, name2=?, link2=?, name3=?, link3=?, name4=?, link4=?, seasonNo = ?  "
	+ "WHERE no = ? ";
	
	// 5. 이미지 게시글 삭제
	public static final String IMAGE_DELETE
	= "DELETE FROM fashion "
	+ "WHERE no = ? ";

	// 6.게시판 댓글 리스트 가져오기
	public static final String IMAGE_REPLY_LIST
	= "SELECT rnum, rno, no, content, alias, to_char(writeDate, 'yyyy.mm.dd') writeDate "
	+ "FROM( "
			+ "SELECT ROWNUM rnum, rno, no, content, alias, writeDate "
			+ "FROM ( "
				+ "SELECT rno, no, content, alias, writeDate "
				+ "FROM fashion_reply "
				+ "WHERE no = ? "
				+ "ORDER BY rno DESC "
			+ ") "
	+ ") "
	+ "WHERE rnum BETWEEN ? AND ?";
	
	// 6-1.게시판 댓글의 모든 데이터 가져오기
	public static final String IMAGE_GET_REPLY_TOTALROW
	// image의 모든 데이터를 가져오기
	= "SELECT COUNT(*) FROM fashion_reply "
	+ "WHERE no = ?";
	
	// 7.댓글 등록
	public static final String IMAGE_REPLY_WRITE
	// board의 모든 데이터를 가져오기
	= "INSERT INTO fashion_reply(rno, no, content, alias) "
	+ "values(fashion_reply_seq.nextval, ?, ?, ?) ";
	
	// 8.댓글 수정
	public static final String IMAGE_REPLY_UPDATE 
	= "UPDATE fashion_reply SET content=?, alias=? "
	+ "WHERE rno = ? AND no = ? ";
	
	// 9.댓글 삭제
	public static final String IMAGE_REPLY_DELETE
	= "DELETE FROM fashion_reply "
	+ "WHERE rno = ? AND no = ? ";
}
