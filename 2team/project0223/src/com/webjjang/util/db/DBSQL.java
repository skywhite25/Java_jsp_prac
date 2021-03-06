package com.webjjang.util.db;

public class DBSQL {
	
	// 게시판1 쿼리
	public static final String Board1_LIST 
	= "SELECT rnum, no, title, writer, to_char(writeDate, 'yyyy.mm.dd') writeDate, hit "
	+ "FROM( "
			+ "SELECT ROWNUM rnum, no, title, writer, writeDate, hit "
			+ "FROM ( "
				+ "SELECT no, title, writer, writeDate, hit "
				+ "FROM board "
				+ "ORDER BY NO DESC "
			+ ") "
	+ ") "
	+ "WHERE rnum BETWEEN  ? AND ?";
	
	public static final String Board1_VIEW
	= "SELECT no, title, content, writer, to_char(writeDate, 'yyyy.mm.dd') writeDate, hit "
	+ "FROM board "
	+ "WHERE no = ? ";
	
	public static final String Board1_WRITE
	= "INSERT INTO board (no, title, content, writer) "
	+ "values(board_seq.nextval, ?, ?, ? )";
	
	public static final String Board1_UPDATE 
	= "UPDATE board SET title=?, content=?, writer=? "
	+ "WHERE no = ? ";
	
	public static final String Board1_DELETE 
	= "DELETE FROM board "
	+ "WHERE no = ?";
	
<<<<<<< .mine
	public static final String Board_INCREASE 
||||||| .r53
	public static final String Board_INCREAS 
=======
	public static final String Board1_INCREAS 
>>>>>>> .r87
	= "UPDATE board SET hit = hit + 1 "
	+ "WHERE no = ?";
	
	public static final String Board1_GET_TOTALROW
	// board의 모든 데이터를 가져오기
	= "SELECT COUNT(*) FROM board ";
	
	// 게시판2 쿼리
	public static final String Board2_LIST 
	= "SELECT rnum, no, title, writer, to_char(writeDate, 'yyyy.mm.dd') writeDate, hit "
			+ "FROM( "
			+ "SELECT ROWNUM rnum, no, title, writer, writeDate, hit "
			+ "FROM ( "
			+ "SELECT no, title, writer, writeDate, hit "
			+ "FROM board "
			+ "ORDER BY NO DESC "
			+ ") "
			+ ") "
			+ "WHERE rnum BETWEEN  ? AND ?";
	
	public static final String Board2_VIEW
	= "SELECT no, title, content, writer, to_char(writeDate, 'yyyy.mm.dd') writeDate, hit "
			+ "FROM board "
			+ "WHERE no = ? ";
	
	public static final String Board2_WRITE
	= "INSERT INTO board (no, title, content, writer) "
			+ "values(board_seq.nextval, ?, ?, ? )";
	
	public static final String Board2_UPDATE 
	= "UPDATE board SET title=?, content=?, writer=? "
			+ "WHERE no = ? ";
	
	public static final String Board2_DELETE 
	= "DELETE FROM board "
			+ "WHERE no = ?";
	
	public static final String Board2_INCREAS 
	= "UPDATE board SET hit = hit + 1 "
			+ "WHERE no = ?";
	
	public static final String Board2_GET_TOTALROW
	// board의 모든 데이터를 가져오기
	= "SELECT COUNT(*) FROM board ";
	
	// 게시판3 쿼리
	public static final String Board3_LIST 
	= "SELECT rnum, no, title, writer, to_char(writeDate, 'yyyy.mm.dd') writeDate, hit "
			+ "FROM( "
			+ "SELECT ROWNUM rnum, no, title, writer, writeDate, hit "
			+ "FROM ( "
			+ "SELECT no, title, writer, writeDate, hit "
			+ "FROM board "
			+ "ORDER BY NO DESC "
			+ ") "
			+ ") "
			+ "WHERE rnum BETWEEN  ? AND ?";
	
	public static final String Board3_VIEW
	= "SELECT no, title, content, writer, to_char(writeDate, 'yyyy.mm.dd') writeDate, hit "
			+ "FROM board "
			+ "WHERE no = ? ";
	
	public static final String Board3_WRITE
	= "INSERT INTO board (no, title, content, writer) "
			+ "values(board_seq.nextval, ?, ?, ? )";
	
	public static final String Board3_UPDATE 
	= "UPDATE board SET title=?, content=?, writer=? "
			+ "WHERE no = ? ";
	
	public static final String Board3_DELETE 
	= "DELETE FROM board "
			+ "WHERE no = ?";
	
	public static final String Board3_INCREAS 
	= "UPDATE board SET hit = hit + 1 "
			+ "WHERE no = ?";
	
	public static final String Board3_GET_TOTALROW
	// board의 모든 데이터를 가져오기
	= "SELECT COUNT(*) FROM board ";

	
	
	
	//=============== 공지사항에 활용되는 쿼리 ==================
	
	
	
		// 공지사항1
		public static final String NOTICE1_LIST 
		= " select rnum, no, title, "
				+ " to_char(startDate, 'yyyy.mm.dd') startDate, "
				+ " to_char(endDate, 'yyyy.mm.dd') endDate, "
				+ " to_char(updateDate, 'yyyy.mm.dd') updateDate "
				+ " from ( "
				+ " select rownum rnum, no, title, startDate, endDate, updateDate from ( "
				+ " select no, title, startDate, endDate, updateDate from notice "
				+ " ORDER BY startDate "
				+ " ) "
				+ " ) where rnum between 1 and 10 ";
		
		public static final String NOTICE1_VIEW
		= " select no, title, "
				+ " to_char(startDate, 'yyyy.mm.dd') startDate, "
				+ " to_char(endDate, 'yyyy.mm.dd') endDate, "
				+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, "
				+ " to_char(updateDate, 'yyyy.mm.dd') updateDate "
				+ " from notice where no = ?";
		
		public static final String NOTICE1_WRITE
		= " insert into notice(no, title, content, startDate, endDate) values(notice_seq.nextval, ?, ?, ?, ?) ";
		
		public static final String NOTICE1_UPDATE
		= " update notice set title = ?, content = ?, startDate = ?, endDate = ? where no = ? ";
		
		public static final String NOTICE1_DELETE
		= " delete from notice where no = ? ";
		
		// 공지사항2
		public static final String NOTICE2_LIST 
		= " select rnum, no, title, "
				+ " to_char(startDate, 'yyyy.mm.dd') startDate, "
				+ " to_char(endDate, 'yyyy.mm.dd') endDate, "
				+ " to_char(updateDate, 'yyyy.mm.dd') updateDate "
				+ " from ( "
				+ " select rownum rnum, no, title, startDate, endDate, updateDate from ( "
				+ " select no, title, startDate, endDate, updateDate from notice "
				+ " ORDER BY startDate "
				+ " ) "
				+ " ) where rnum between 1 and 10 ";
		
		public static final String NOTICE2_VIEW
		= " select no, title, "
				+ " to_char(startDate, 'yyyy.mm.dd') startDate, "
				+ " to_char(endDate, 'yyyy.mm.dd') endDate, "
				+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, "
				+ " to_char(updateDate, 'yyyy.mm.dd') updateDate "
				+ " from notice where no = ?";
		
		public static final String NOTICE2_WRITE
		= " insert into notice(no, title, content, startDate, endDate) values(notice_seq.nextval, ?, ?, ?, ?) ";
		
		public static final String NOTICE2_UPDATE
		= " update notice set title = ?, content = ?, startDate = ?, endDate = ? where no = ? ";
		
		public static final String NOTICE2_DELETE
		= " delete from notice where no = ? ";
		
		// 공지사항3
		public static final String NOTICE3_LIST 
		= " select rnum, no, title, "
				+ " to_char(startDate, 'yyyy.mm.dd') startDate, "
				+ " to_char(endDate, 'yyyy.mm.dd') endDate, "
				+ " to_char(updateDate, 'yyyy.mm.dd') updateDate "
				+ " from ( "
				+ " select rownum rnum, no, title, startDate, endDate, updateDate from ( "
				+ " select no, title, startDate, endDate, updateDate from notice "
				+ " ORDER BY startDate "
				+ " ) "
				+ " ) where rnum between 1 and 10 ";
		
		public static final String NOTICE3_VIEW
		= " select no, title, "
				+ " to_char(startDate, 'yyyy.mm.dd') startDate, "
				+ " to_char(endDate, 'yyyy.mm.dd') endDate, "
				+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, "
				+ " to_char(updateDate, 'yyyy.mm.dd') updateDate "
				+ " from notice where no = ?";
		
		public static final String NOTICE3_WRITE
		= " insert into notice(no, title, content, startDate, endDate) values(notice_seq.nextval, ?, ?, ?, ?) ";
		
		public static final String NOTICE3_UPDATE
		= " update notice set title = ?, content = ?, startDate = ?, endDate = ? where no = ? ";
		
		public static final String NOTICE3_DELETE
		= " delete from notice where no = ? ";
		
	}