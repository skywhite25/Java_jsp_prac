/**
 * 서버가 실행될 때 초기화 시켜주는 Servlet
 * 작성자 :OOTD
 * 작성일 : 2021.03.23
 * ver_1.0
 */

package com.OOTD.main.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//import com.OOTD.qna.controller.QnaController;
import com.OOTD.qna.service.QnaAnswerService;
import com.OOTD.qna.service.QnaListService;
import com.OOTD.qna.service.QnaQuestionService;
import com.OOTD.qna.service.QnaViewService;
import com.OOTD.image.controller.ImageController;
import com.OOTD.like.DAO.LikeDAO;
import com.OOTD.like.service.FashionDeleteService;
import com.OOTD.like.service.FashionLikeService;
import com.OOTD.like.service.FashionViewService;
import com.OOTD.like.service.FashionDeleteService;
import com.OOTD.like.service.FashionLikeService;
import com.OOTD.like.service.FashionViewService;
import com.OOTD.like.controller.FashionLikeController;
import com.OOTD.like.service.FashionDeleteService;
import com.OOTD.like.service.FashionLikeService;
import com.OOTD.like.service.FashionViewService;
import com.OOTD.member.controller.MemberController;
import com.OOTD.member.dao.MemberDAO;
import com.OOTD.member.service.MemberCheckIdService;
import com.OOTD.member.service.MemberLoginService;
import com.OOTD.member.service.MemberUpdateService;
import com.OOTD.member.service.MemberWriteService;
import com.OOTD.notice.controller.NoticeController;
import com.OOTD.notice.dao.NoticeDAO;
import com.OOTD.notice.service.NoticeDeleteService;
import com.OOTD.notice.service.NoticeListService;
import com.OOTD.notice.service.NoticeUpdateService;
import com.OOTD.notice.service.NoticeViewService;
import com.OOTD.notice.service.NoticeWriteService;
import com.OOTD.timeline.controller.TimelineController;
import com.OOTD.timeline.dao.TimelineDAO;
import com.OOTD.timeline.service.TimelineDeleteService;
import com.OOTD.timeline.service.TimelineListService;
import com.OOTD.timeline.service.TimelineUpdateFileService;
import com.OOTD.timeline.service.TimelineUpdateService;
import com.OOTD.timeline.service.TimelineViewService;
import com.OOTD.timeline.service.TimelineWriteService;
//import com.OOTD.timeline.service.TimelineViewService;

/**
 * Servlet implementation class Init
 */
@WebServlet(value = "/Init",loadOnStartup = 1)
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("===============OOTD Project 서버 실행===============");
		
		
		
		//controller
		//--생성 확인 필수 Null조심!!--
		Beans.putController("/main", new MainController());
		Beans.putController("/member", new MemberController());
//		Beans.putController("/qna", new QnaController());



		// Beans.putController("/qna", new QnaController());

		Beans.putController("/notice", new NoticeController());
		Beans.putController("/timeline", new TimelineController());
		Beans.putController("/like", new FashionLikeController());
		Beans.putController("/image", new ImageController());

		System.out.println("memberController:"+Beans.getController("/member"));
		System.out.println("qnaController:"+Beans.getController("/qna"));
		System.out.println("qnaController:"+Beans.getController("/notice"));
		
		

		//////////////////// notice ////////////////////
		//--생성 확인 필수 Null조심!!--
		Beans.putDAO("noticeDAO", new NoticeDAO());
		
		// service 생성 저장
		Beans.putService("/notice/list.do", new NoticeListService());
		Beans.putService("/notice/view.do", new NoticeViewService());
		Beans.putService("/notice/write.do", new NoticeWriteService());
		Beans.putService("/notice/update.do", new NoticeUpdateService());
		Beans.putService("/notice/delete.do", new NoticeDeleteService());
		
		// service에 dao 넣기 - 조립
		Beans.getService("/notice/list.do").setDAO(Beans.getDAO("noticeDAO"));
		Beans.getService("/notice/view.do").setDAO(Beans.getDAO("noticeDAO"));
		Beans.getService("/notice/write.do").setDAO(Beans.getDAO("noticeDAO"));
		Beans.getService("/notice/update.do").setDAO(Beans.getDAO("noticeDAO"));
		Beans.getService("/notice/delete.do").setDAO(Beans.getDAO("noticeDAO"));
		
		// 생성 저장이 잘 되었는지 확인
		System.out.println(Beans.getService("/notice/list.do"));
		System.out.println(Beans.getService("/notice/view.do"));
		System.out.println(Beans.getService("/notice/write.do"));
		System.out.println(Beans.getService("/notice/update.do"));
		System.out.println(Beans.getService("/notice/delete.do"));
		System.out.println(Beans.getDAO("noticeDAO"));
		
		//////////////////// QNA ////////////////////
		//--생성 확인 필수 Null조심!!--
		Beans.putService("/qna/list.do", new QnaListService());
		Beans.putService("/qna/view.do", new QnaViewService());
		Beans.putService("/qna/question.do", new QnaQuestionService());
		Beans.putService("/qna/answer.do", new QnaAnswerService());
		
		//저장이 잘되어 있는지 출력
//		System.out.println(Beans.get("notice/list.do"));
//		System.out.println(Beans.getDAO("noticeDAO"));		
		
		Beans.getService("/qna/list.do").setDAO(Beans.getDAO("qnaDAO"));
		Beans.getService("/qna/view.do").setDAO(Beans.getDAO("qnaDAO"));
		Beans.getService("/qna/question.do").setDAO(Beans.getDAO("qnaDAO"));
		Beans.getService("/qna/answer.do").setDAO(Beans.getDAO("qnaDAO"));
		//저장이 잘되어 있는지 출력
		System.out.println(Beans.getService("/qna/list.do"));
		System.out.println(Beans.getService("/qna/view.do"));
		System.out.println(Beans.getService("/qna/question.do"));
		System.out.println(Beans.getService("/qna/answer.do"));
		System.out.println(Beans.getDAO("qnaDAO"));		
		
		//////////////////// fashion ////////////////////
		//--생성 확인 필수 Null조심!!--
		
		//저장이 잘되어 있는지 출력
//		System.out.println(Beans.get("notice/list.do"));
//		System.out.println(Beans.getDAO("noticeDAO"));		
		
		
		
		//////////////////// timeline ////////////////////
		//--생성 확인 필수 Null조심!!--
		
		Beans.putDAO("timelineDAO", new TimelineDAO());

		Beans.putService("/timeline/list.do", new TimelineListService());
		Beans.putService("/timeline/view.do", new TimelineViewService());
		Beans.putService("/timeline/write.do", new TimelineWriteService());
		Beans.putService("/timeline/update.do", new TimelineUpdateService());
		Beans.putService("/timeline/updateFile.do", new TimelineUpdateFileService());
		Beans.putService("/timeline/delete.do", new TimelineDeleteService());
		
			
		Beans.getService("/timeline/list.do").setDAO(Beans.getDAO("timelineDAO"));
//		Beans.getService("/timeline/view.do").setDAO(Beans.getDAO("timelineDAO"));
		Beans.getService("/timeline/write.do").setDAO(Beans.getDAO("timelineDAO"));
		Beans.getService("/timeline/update.do").setDAO(Beans.getDAO("timelineDAO"));
		Beans.getService("/timeline/updateFile.do").setDAO(Beans.getDAO("timelineDAO"));
		Beans.getService("/timeline/delete.do").setDAO(Beans.getDAO("timelineDAO"));
		
		
		
		
		//////////////////// member ////////////////////
		//--생성 확인 필수 Null조심!!--

		Beans.putDAO("memberDAO", new MemberDAO());
		
		Beans.putService("/member/login.do", new MemberLoginService());
		Beans.putService("/member/write.do", new MemberWriteService());
		Beans.putService("/member/update.do", new MemberUpdateService());
		Beans.putService("/ajax/checkId.do", new MemberCheckIdService());

		Beans.getService("/member/login.do").setDAO(Beans.getDAO("memberDAO"));
		Beans.getService("/member/write.do").setDAO(Beans.getDAO("memberDAO"));
		Beans.getService("/member/update.do").setDAO(Beans.getDAO("memberDAO"));
		Beans.getService("/ajax/checkId.do").setDAO(Beans.getDAO("memberDAO"));
		
		
		
		//////////////////// like ////////////////////
		//--생성 확인 필수 Null조심!!--
		Beans.putDAO("LikeDAO", new LikeDAO());
		
		Beans.putService("/like/fashionView.do", new FashionViewService());
		Beans.putService("/like/fashionLike.do", new FashionLikeService());
		Beans.putService("/like/fashionDelete.do", new FashionDeleteService());
		
//		Beans.getService("/like/fashionView.do").setDAO(Beans.getDAO("LikeDAO"));
//		Beans.getService("/like/fashionLike.do").setDAO(Beans.getDAO("LikeDAO"));
//		Beans.getService("/like/fashionDelete.do").setDAO(Beans.getDAO("LikeDAO"));
		
		//저장이 잘되어 있는지 출력
		System.out.println(Beans.getController("/like"));
		System.out.println(Beans.getDAO("LikeDAO"));
		System.out.println(Beans.getService("like/fashionLike.do"));
		
		
		
		
		
		try {
			
			Class.forName("com.OOTD.util.db.DBInfo");
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new ServletException("드라이버 확인 처리 중 오류 발생");
		}
	}
}


