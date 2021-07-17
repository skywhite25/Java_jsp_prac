package com.webjjang.util.db;

public class DBSQL {

	// 게시판1 쿼리
	public static final String BOARD1_LIST 
	= "select rnum, no, title, writer,"
	+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, hit from( "
		+ " select rownum rnum, no, title, writer, writeDate, hit from ("
			+ " select no, title, writer, writeDate, hit from board"
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	public static final String BOARD1_WRITE 
	= " insert into board(no, title, content, writer) "
	+ " values(board_seq.nextval, ?, ?, ?) ";
	
	// 게시판2 쿼리
	public static final String BOARD2_LIST 
	= "select rnum, no, title, writer,"
	+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, hit from( "
		+ " select rownum rnum, no, title, writer, writeDate, hit from ("
			+ " select no, title, writer, writeDate, hit from board"
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	public static final String BOARD2_WRITE 
	= " insert into board(no, title, content, writer) "
	+ " values(board_seq.nextval, ?, ?, ?) ";
	
	// 게시판3 쿼리
	public static final String BOARD3_LIST 
	= "select rnum, no, title, writer,"
	+ " to_char(writeDate, 'yyyy.mm.dd') writeDate, hit from( "
		+ " select rownum rnum, no, title, writer, writeDate, hit from ("
			+ " select no, title, writer, writeDate, hit from board"
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	public static final String BOARD3_WRITE 
	= " insert into board(no, title, content, writer) "
	+ " values(board_seq.nextval, ?, ?, ?) ";
	
	// 공지사항1 쿼리
	public static final String NOTICE1_LIST 
	= "select rnum, no, title,"
	+ " to_char(startDate, 'yyyy.mm.dd') startDate,"
	+ " to_char(endDate, 'yyyy.mm.dd') endDate,"
	+ " to_char(updateDate, 'yyyy.mm.dd') updateDate,"
	+ " from( "
		+ " select rownum rnum, no, title, startDate, endDate, updateDate from ("
			+ " selectno, title, startDate, endDate, updateDate  from notice "
			+ " order by no startDate "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	public static final String NOTICE1_WRITE 
	= " insert into notice(no, title, content, startDate, endDate) "
	+ " values(board_seq.nextval, ?, ?, ?, ?) ";
	
	// 공지사항2 쿼리
	public static final String NOTICE2_LIST 
	= "select rnum, no, title,"
	+ " to_char(startDate, 'yyyy.mm.dd') startDate,"
	+ " to_char(endDate, 'yyyy.mm.dd') endDate,"
	+ " to_char(updateDate, 'yyyy.mm.dd') updateDate,"
	+ " from( "
		+ " select rownum rnum, no, title, startDate, endDate, updateDate from ("
			+ " selectno, title, startDate, endDate, updateDate  from notice "
			+ " order by no startDate "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	public static final String NOTICE2_WRITE 
	= " insert into notice(no, title, content, startDate, endDate) "
	+ " values(board_seq.nextval, ?, ?, ?, ?) ";
	
	// 공지사항3 쿼리
	public static final String NOTICE3_LIST 
	= "select rnum, no, title,"
	+ " to_char(startDate, 'yyyy.mm.dd') startDate,"
	+ " to_char(endDate, 'yyyy.mm.dd') endDate,"
	+ " to_char(updateDate, 'yyyy.mm.dd') updateDate,"
	+ " from( "
		+ " select rownum rnum, no, title, startDate, endDate, updateDate from ("
			+ " selectno, title, startDate, endDate, updateDate  from notice "
			+ " order by no startDate "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	public static final String NOTICE3_WRITE 
	= " insert into notice(no, title, content, startDate, endDate) "
	+ " values(board_seq.nextval, ?, ?, ?, ?) ";
	
}
