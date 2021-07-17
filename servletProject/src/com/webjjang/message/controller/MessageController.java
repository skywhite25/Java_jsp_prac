package com.webjjang.message.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.webjjang.message.vo.MessageVO;
import com.webjjang.main.controller.Beans;
import com.webjjang.main.controller.Controller;
import com.webjjang.main.controller.ExeService;
import com.webjjang.member.vo.LoginVO;
import com.webjjang.util.PageObject;
import com.webjjang.util.filter.AuthorityFilter;

public class MessageController implements Controller{

	private final String MODULE = "message";
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception{
		System.out.println("MessageController.execute()");
		
		// 페이지를 위한 처리
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("pageObject", pageObject); // 페이지를 보여주기 위해 서버객체에 담는다.
		
		switch (AuthorityFilter.url) {
		// 1. 메시지 리스트
		case "/" + MODULE +"/list.do":
			// service - dao --> request에 저장까지 해준다.
			list(request, pageObject);
		
			// "message/list" 넘긴다. -> /WEB-INF/views/ + message/list + .jsp를 이용해서 HTML을 만든다.
			jspInfo = MODULE + "/list";			
			break;

		// 2. 메시지 보기
		case "/" + MODULE +"/view.do":
			// service - dao --> request에 저장까지 해준다.
			view(request);
		
			// "message/view" 넘긴다. -> /WEB-INF/views/ + message/view + .jsp를 이용해서 HTML을 만든다.
			jspInfo = MODULE + "/view";			
			break;
		
		// 3-1. 메시지 보내기 폼
		case "/" + MODULE +"/writeForm.do":
			// "message/view" 넘긴다. -> /WEB-INF/views/ + message/view + .jsp를 이용해서 HTML을 만든다.
			jspInfo = MODULE + "/writeForm";			
			break;
		
		// 3-2. 메시지 글쓰기 처리
		case "/" + MODULE +"/write.do":
			// service - dao --> request에 저장까지 해준다.
			write(request);
		
			// "message/view" 넘긴다. -> /WEB-INF/views/ + message/view + .jsp를 이용해서 HTML을 만든다.
			jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();			
			break;
		
		// 4. 메시지 글삭제 처리
		case "/" + MODULE +"/delete.do":
			// service - dao --> request에 저장까지 해준다.
			delete(request);
		
			// "message/view" 넘긴다. -> view.do로 자동으로 이동
			jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();			
			break;
		
		default:
			throw new Exception("페이지 오류 404 - 존재하지 않는 페이지입니다.");
		}
		
		// jsp의 정보를 가지고 리턴한다.
		return jspInfo;
	}
	
	
	// 1. 메시지 리스트 처리.
	private void list (HttpServletRequest request, PageObject pageObject) throws Exception {

		// 내 아이디를 가져와서 pageObject에 저장해둔다.
		pageObject.setAccepter(((LoginVO)request.getSession().getAttribute("login")).getId());

		//DB에서 데이터 가져오기
		@SuppressWarnings("unchecked")
		List<MessageVO> list = (List<MessageVO>)ExeService.execute(Beans.get(AuthorityFilter.url), pageObject);

		//서버객체 request에 담는다.
		request.setAttribute("list", list);
	}
	
	// 2. 메시지 글보기 처리.
	private void view (HttpServletRequest request) throws Exception {
		String strNo = request.getParameter("no");
		// Long no = Long.parseLong(strNo); ==> 더 간단하게 만든 vo.setNo(Long.parseLong(strNo));가 아래에 있다.

		// 내 아이디 정보를 꺼내야한다.
		String id = ((LoginVO)request.getSession().getAttribute("login")).getId();
		// vo 객체 생성
		MessageVO vo = new MessageVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setAccepter(id); // 받는 사람이 본인인 데이터를 읽기 표시하기 위해서

		// 1. 받은사람이 로그인한 사람과 같아야하고 번호가 같고 받은 날짜가 null인 데이터 메시지를 
//		    (읽지않은) 받은 메시지는 읽음표시를 한다.(acceptDate를 현재 날짜로 넣어준다 - update)
		// 2. 메시지 번호에 맞는 전체 메시지 정보 가져오기
		MessageVO viewVO = (MessageVO)ExeService.execute(Beans.get(AuthorityFilter.url), vo);

		// 서버객체 request에 담는다.
		request.setAttribute("vo", viewVO);

	}
	
	// 3. 메시지 글쓰기 처리.
	private void write (HttpServletRequest request) throws Exception {

		String accepter = request.getParameter("accepter");
		String content = request.getParameter("content");

		// session에서 내 아이디 가져오기
		// session의 내용은 /member.login.jsp를 확인하세요 - 이 때 key = login이 다르면 null이 나온다.
		LoginVO vo = (LoginVO) request.getSession().getAttribute("login");
		String sender = vo.getId();

		// vo 객체를 생성하고 데이터를 넣는다.
		MessageVO messageVO = new MessageVO();
		messageVO.setContent(content);
		messageVO.setSender(sender);
		messageVO.setAccepter(accepter);

		// 2. DB 처리 - write.jsp -> service - dao - db
		// ExeService.execute(실행할 service, service에 전달되는 데이터)
		ExeService.execute(Beans.get(AuthorityFilter.url), messageVO);
	}

	// 5. 메시지 글삭제 처리
	private void delete (HttpServletRequest request) throws Exception {
		// 1. 데이터 수집
		String strNo= request.getParameter("no");
		long no = Long.parseLong(strNo);

		// 2. DB 처리 - delete.jsp -> service - dao
		// String url = request.getServletPath();
		ExeService.execute(Beans.get(AuthorityFilter.url), no);

	}
	
}
