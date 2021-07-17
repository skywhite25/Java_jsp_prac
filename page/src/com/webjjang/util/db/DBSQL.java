package com.webjjang.util.db;

public class DBSQL {
	
	
	// 게시판 쿼리 ==========================================================================================================
	// 게시판 리스트
	public static final String BOARD_LIST 
	= "select rnum, no, title, writer, "
		+ "to_char(writeDate, 'yyyy.mm.dd') writeDate, hit from( "
			+ " select rownum rnum, no, title, writer, writeDate, hit from ( "
				+ " select no, title, writer, writeDate, hit from board"
				+ " order by no desc "
			+ " ) "
		+ ") where rnum between ? and ? ";
	
	// 게시판 전체 데이터 갯수
	public static final String BOARD_GET_TOTALROW 
	= " select count(*) from board ";
	
	// 공지사항 게시판 쿼리 =====================================================================================
	// 1.리스트 - 번호, 제목, 공지시작일, 공지종료일, 최근수정일
	public static final String NOTICE_LIST
	= "SELECT rnum, no, title, "
		+ "to_char(startDate, 'yyyy.mm.dd') startDate, "
		+ "to_char(endDate, 'yyyy.mm.dd') endDate, "
		+ "to_char(updateDate, 'yyyy.mm.dd') updateDate "
	+ "FROM( "
			+ "SELECT ROWNUM rnum, no, title, startDate, endDate, updateDate "
			+ "FROM ( "
				+ "SELECT no, title, startDate, endDate, updateDate "
				+ "FROM notice "
				+ "ORDER BY NO DESC "
			+ ") "
	+ ") "
	+ "WHERE rnum BETWEEN  ? AND ? ";
	
	public static final String NOTICE_VIEW
	= "SELECT no, title, content, writer, "
			+ "to_char(startDate, 'yyyy.mm.dd') startDate, "
			+ "to_char(endDate, 'yyyy.mm.dd') endDate, "
			+ "to_char(writeDate, 'yyyy.mm.dd') writeDate "
	+ "FROM notice "
	+ "WHERE no = ? ";
	
	public static final String NOTICE_WRITE
	= "INSERT INTO board (no, title, content, writer) "
	+ "values(board_seq.nextval, ?, ?, ? )";
	
	public static final String NOTICE_UPDATE 
	= "UPDATE board SET title=?, content=?, writer=? "
	+ "WHERE no = ? ";
	
	public static final String NOTICE_DELETE 
	= "DELETE FROM board "
	+ "WHERE no = ?";
	
	public static final String NOTICE_INCREASE
	= "UPDATE board SET hit = hit + 1 "
	+ "WHERE no = ?";
	
	public static final String NOTICE_GET_TOTALROW
	// NOTICE의 모든 데이터를 가져오기
	= "SELECT COUNT(*) FROM notice ";
	
	// 회원관리 쿼리 ================================================================================
	// 로그인 처리
	public static final String MEMBER_LOGIN
	= " select m.id, m.name, m.gradeNo, g.gradeName from member m, grade g "
	+ " where (m.id = ? and m.pw = ?) and (m.gradeNo = g.gradeNo) ";
	
	// 회원리스트 - id, name, gender, birth, tel, status, gradeNo, gradeName
	public static final String MEMBER_LIST
	= "select rnum, id, name, gender, "
			+ "to_char(birth, 'yyyy.mm.dd') birth, tel, status, gradeNo, gradeName from ( "
				+ " select rownum rnum, id, name, gender, birth, tel, status, gradeNo, gradeName from ( "
					+ " select m.id, m.name, m.gender, m.birth, m.tel, m.status, m.gradeNo, g.gradeName "
					+ " from member m, grade g "
					+ " where m.gradeNo = g.gradeNo "
					+ " order by id "
				+ " ) "
			+ ") where rnum between ? and ? ";
	
	// 회원등급 수정
	public static final String MEMBER_GRADE_MODIFY
	= "update member set gradeNo = ? where id = ?";
	
	// 회원정보 보기
	public static final String MEMBER_VIEW
	= "select m.id, m.name, m.gender, "
			+ " to_char(m.birth, 'yyyy.mm.dd') birth, m.tel, m.email, "
			+ " to_char(m.regDate,'yyyy.mm.dd') regDate, m.status, m.gradeNo, g.gradeName "
			+ " from member m, grade g where (m.id = ?) and (m.gradeNo = g.gradeNo)";
}
