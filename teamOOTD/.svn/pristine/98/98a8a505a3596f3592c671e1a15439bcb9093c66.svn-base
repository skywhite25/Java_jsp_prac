package com.OOTD.like.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.OOTD.like.vo.LikeVO;
import com.OOTD.util.db.DBInfo;
import com.OOTD.util.db.DBSQL;

public class LikeDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//1-1.패션 좋아요 보기
	public LikeVO fashionView(LikeVO vo) throws Exception{
		//결과를 저장해서 보여줘야 하는 변수 
		LikeVO likevo = null;
		System.out.println(vo);
		try {
			con = DBInfo.getConnection();
			System.out.println(DBSQL.FASHION_VIEW);
			pstmt = con.prepareStatement(DBSQL.FASHION_VIEW);
			pstmt.setLong(1, vo.getNo());		
			pstmt.setString(2, vo.getId());		
			
			rs = pstmt.executeQuery();
			System.out.println("패션 좋아요 보기 성공");
			
			if(rs!=null&& rs.next()) {
				likevo = new LikeVO();
				likevo.setNo(rs.getLong("no"));
				likevo.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("fashion view 실행 중 DB오류 ");
		}finally {
			DBInfo.close(con, pstmt,rs);
		}
		System.out.println(likevo);
		return likevo;
	}
	
	//1-2.패션 좋아요 갯수
	public long fashionCnt(long no) throws Exception{
		//결과를 저장해서 보여줘야 하는 변수 
		long result = 0;
		
		try {
			con = DBInfo.getConnection();
			System.out.println(DBSQL.FASHION_CNT);
			pstmt = con.prepareStatement(DBSQL.FASHION_CNT);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			System.out.println("패션 좋아요 갯수 세기 성공");
			if(rs!=null && rs.next()) {
				result = rs.getLong(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("fashion view 실행 중 DB오류 ");
		}finally {
			DBInfo.close(con, pstmt,rs);
		}
		System.out.println(no);
		return result;
	}
	
	//1-3.패션 좋아요 클릭 
	public int fashionLike(LikeVO vo) throws Exception{
		int result = 0;
		try {
			con = DBInfo.getConnection();
			pstmt = con.prepareStatement(DBSQL.FASHION_LIKE);
			pstmt.setLong(1, vo.getNo());		
			pstmt.setString(2, vo.getId());	
			result = pstmt.executeUpdate();
			System.out.println("패션 좋아요 클릭 성공");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("fashion like 실행 중 DB오류 ");
		}finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
	//1-4.패션 좋아요 취소 
	public int fashionDelete(long no) throws Exception{
		int result = 0;
		try {
			con = DBInfo.getConnection();
			pstmt = con.prepareStatement(DBSQL.FASHION_DELETE);
			pstmt.setLong(1,no);		
			result = pstmt.executeUpdate();
			if(result==1)
				System.out.println("좋아요 취소 성공");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("fashion like 취소 실행 중 DB오류 ");
		}finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
	
	
	//2-1.타임라인 좋아요 보기
	public LikeVO timeView(LikeVO vo) throws Exception{
		LikeVO likevo = null;
		try {
			con = DBInfo.getConnection();
			pstmt = con.prepareStatement(DBSQL.TIME_VIEW);
			pstmt.setLong(1, vo.getNo());		
			pstmt.setString(2, vo.getId());	
			rs=pstmt.executeQuery();
			if(rs!=null&& rs.next()) {
				likevo = new LikeVO();
				likevo.setNo(rs.getLong("no"));
				likevo.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("time like 실행 중 DB오류 ");
		}finally {
			DBInfo.close(con, pstmt,rs);
		}
		
		return likevo;
	}
	//2-2.타임라인 좋아요 클릭 
	public int timeLike(LikeVO vo) throws Exception{
		int result = 0;
		try {
			con = DBInfo.getConnection();
			pstmt = con.prepareStatement(DBSQL.TIME_LIKE);
			pstmt.setLong(1, vo.getNo());		
			pstmt.setString(2, vo.getId());		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("time like 실행 중 DB오류 ");
		}finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
	//2-2.타임라인 좋아요 취소 
	public int timeDelete(long no) throws Exception{
		int result = 0;
		try {
			con = DBInfo.getConnection();
			pstmt = con.prepareStatement(DBSQL.TIME_LIKE);
			pstmt.setLong(1,no);		
			result = pstmt.executeUpdate();
			if(result==1)
				System.out.println("좋아요 취소 성공");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("time like 취소 실행 중 DB오류 ");
		}finally {
			DBInfo.close(con, pstmt);
		}
		
		return result;
	}
	
	
}
