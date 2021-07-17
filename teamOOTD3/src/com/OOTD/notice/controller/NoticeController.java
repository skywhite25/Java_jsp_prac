package com.OOTD.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.OOTD.notice.vo.NoticeVO;
import com.OOTD.main.controller.Beans;
import com.OOTD.main.controller.Controller;
import com.OOTD.main.controller.ExeService;
import com.OOTD.util.PageObject;
import com.OOTD.util.filter.AuthorityFilter;

public class NoticeController implements Controller {

	private final String MODULE = "notice";
	private String jspInfo = null;

	@Override
	public String execute(HttpServletRequest request) throws Exception{
		System.out.println("NoticeController.execute()");
		
		// 페이지 처리를 한다.
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("pageObject", pageObject); // 페이지를 보여주기 위해 서버객체에 담는다.
		
		// url에 맞는 처리를 한다.
		// switch case를 이용한다.
		
		switch (AuthorityFilter.url) {
		// 1. 공지사항 리스트
		case "/" + MODULE +"/list.do":
			// service - dao --> request에 저장까지 해준다.
			list(request, pageObject);
		
			// "notice/list" 넘긴다. -> /WEB-INF/views/ + notice/list + .jsp를 이용해서 HTML을 만든다.
			jspInfo = MODULE + "/list";			
			break;

		// 2. 공지사항 글보기
		case "/" + MODULE +"/view.do":
			// service - dao --> request에 저장까지 해준다.
			view(request);
		
			// "notice/view" 넘긴다. -> /WEB-INF/views/ + notice/view + .jsp를 이용해서 HTML을 만든다.
			jspInfo = MODULE + "/view";			
			break;
		
		// 3-1. 공지사항 글쓰기 폼
		case "/" + MODULE +"/writeForm.do":
			// notice/writeForm + .jsp를 이용해서 HTML을 만든다.
			jspInfo = MODULE + "/writeForm";			
			break;
		
		// 3-2. 공지사항 글쓰기 처리
		case "/" + MODULE +"/write.do":
			// service - dao --> request에 저장까지 해준다.
			write(request);
		
			// "notice/view" 넘긴다. -> /WEB-INF/views/ + notice/view + .jsp를 이용해서 HTML을 만든다.
			jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();			
			break;
		
		// 4-1. 공지사항 글수정 폼
		case "/" + MODULE +"/updateForm.do":
			updateForm(request);
			// "notice/updateForm" 넘긴다. -> /WEB-INF/views/ + notice/updateForm + .jsp를 이용해서 HTML을 만든다.
			jspInfo = MODULE + "/updateForm";			
			break;
		
		// 4-2. 공지사항 글수정 처리
		case "/" + MODULE +"/update.do":
			// service - dao --> request에 저장까지 해준다.
			Long no = update(request);
		
			// "notice/view" 넘긴다. -> view.do로 자동으로 이동
			jspInfo = "redirect:view.do?no=" + no + "&perPageNum=" + pageObject.getPerPageNum();			
			break;
		
		// 5. 공지사항 글삭제 처리
		case "/" + MODULE +"/delete.do":
			// service - dao --> request에 저장까지 해준다.
			delete(request);
		
			// 공지 list.do로 자동으로 이동
			jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();			
			break;
		
		default:
			throw new Exception("페이지 오류 404 - 존재하지 않는 페이지입니다.");
		}
		
		// jsp의 정보를 가지고 리턴한다.
		return jspInfo;
	}
	
	
	// 1. 공지사항 리스트 처리.
	private void list(HttpServletRequest request, PageObject pageObject) throws Exception {
		// 여기가 자바 코드입니다. servlet-controller(*)-Service-DAO

		// 넘겨 받은 데이터를 처리 - 공지 종류
		String period = request.getParameter("period");
		if(period == null) period = "pre";
		pageObject.setPeriod(period);
		
		//request.getServletPath(); -> AuthorityFilter 76줄에서 실행한 후 url 저장하도록 하고 있다.
		@SuppressWarnings("unchecked")
		List<NoticeVO> list 
		= (List<NoticeVO>) ExeService.execute(Beans.getService(AuthorityFilter.url), pageObject);
		// 서버객체 request에 담는다.
		request.setAttribute("list", list);
		
	}
	
	// 2. 공지사항 글보기 처리.
	private void view (HttpServletRequest request) throws Exception {
		// 여기가 자바 코드입니다. servlet - Controller-Service-DAO -> /notice/view.do

		// 넘어오는 데이터 받기 
		// - 글번호
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);

		NoticeVO vo = (NoticeVO) ExeService.execute(Beans.getService(AuthorityFilter.url), no);
		// 서버객체 request에 담는다.
		request.setAttribute("vo", vo);

	}
	
	// 3. 공지사항 글쓰기 처리.
	private void write (HttpServletRequest request) throws Exception {

		// 넘어오는 데이터를 받는다.
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		// vo객체를 생성하고 저장한다.
		NoticeVO vo = new NoticeVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setStartDate(startDate);
		vo.setEndDate(endDate);

		// vo 객체 데이터 확인
		System.out.println("/notice/write.do [vo] : " + vo);

		// DB에 데이터를 저장 jsp(controller) - NoticeWriteService - NoticeDAO - notice table insert
		ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

	}

	// 4-1. 공지사항 글수정 폼
	private void updateForm(HttpServletRequest request) throws Exception {
		// 자바 부분입니다.
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		// 조회수 1 증가하는 부분은 inc=0으로 강제 셋팅해서 넘긴다.
		// 2. 글번호에 맞는 데이터 가져오기 - BoardViewService => /board/view.do
		String url = "/notice/view.do"; // 현재 url과 다르므로 강제로 셋팅했다.
		NoticeVO vo = (NoticeVO) ExeService.execute(Beans.getService(url), no);
		// 3. 서버 객체에 넣기
		request.setAttribute("vo", vo);

	}

	// 4-2. 공지사항 글수정 처리
	private Long update(HttpServletRequest request) throws Exception {

		// 1. 데이터 수집
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		NoticeVO vo = new NoticeVO();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setStartDate(startDate);
		vo.setEndDate(endDate);

		// 2. DB 처리 - update.jsp -> service -> dao
//		String url = request.getServletPath();
		Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

		if(result < 1) throw new Exception("공지사항 글수정 - 수정할 데이터가 존재하지 않습니다.");
		
		return no;
	}

	// 5. 공지사항 글삭제 처리
	private void delete(HttpServletRequest request) throws Exception {
		// 1. 데이터 수집
		String strNo= request.getParameter("no");
		long no = Long.parseLong(strNo);

		// 2. DB 처리 - delete.jsp -> service - dao
		String url = request.getServletPath();
		int result = (Integer) ExeService.execute(Beans.getService(url), no);



		if(result ==0 ) throw new Exception("공지사항 글삭제 오류 - 존재하지 않는 글은 삭제할 수 없습니다.");
	}

	
}
