package com.OOTD.timeline.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.OOTD.like.vo.LikeVO;
import com.OOTD.main.controller.Beans;
import com.OOTD.main.controller.Controller;
import com.OOTD.main.controller.ExeService;
import com.OOTD.member.vo.LoginVO;
import com.OOTD.timeline.vo.TimelineReplyVO;
import com.OOTD.timeline.vo.TimelineVO;
import com.OOTD.util.PageObject;
import com.OOTD.util.file.FileUtil;
import com.OOTD.util.filter.AuthorityFilter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class TimelineController implements Controller {

	private HttpSession session = null;
	private LoginVO loginVO = null;
	private String id = null;

	private final String MODULE = "timeline";
	private String jspInfo = null;

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		System.out.println("TimelineController.execute()_실행");

		// 세션과 아이디 저장
		session = request.getSession();
		loginVO = (LoginVO) session.getAttribute("login");
		if (loginVO != null)
			id = loginVO.getId();

		// 페이지를 위한 처리
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("pageObject", pageObject); // 페이지를 보여주기 위해 서버 객체에 담음
		
		switch (AuthorityFilter.url) {
		// 1.타임라인 목록
		case "/" + MODULE + "/list.do":
			// service - dao --> request에 저장 해줌
			list(request, pageObject);
			// "list/list 넘김-> /WEB-INF/views/ + timeline/list + .jsp를 이용해서 HTML을 만듦"
			jspInfo = MODULE + "/list";
			break;

		// 2.타임라인 보기
		case "/" + MODULE + "/view.do":
			// service - dao --> request에 저장 해줌
//			view(request);
			timeView(request);
			replyList(view(request), pageObject, request); // 댓글 리스트 가져오기
			// "view/list 넘김-> /WEB-INF/views/timeline/view.jsp를 이용해서 HTML을 만듦"
			jspInfo = MODULE + "/view";
			break;
		// 3-1.타임라인 글쓰기폼
		case "/" + MODULE + "/writeForm.do":
			// "/writeForm/list" 넘김-> /WEB-INF/views/timeline/view.jsp를 이용해서 HTML을 만듦
			jspInfo = MODULE + "/writeForm";
			break;
		// 3-2.타임라인 글쓰기 처리
		case "/" + MODULE + "/write.do":
			// service - dao --> request에 저장 해줌
			write(request);
			// 글쓰기 처리 완료 후 메시지
			session.setAttribute("msg", "타임라인 게시판 글쓰기가 성공적으로 완료되었습니다.");
			// "write.do" 넘김-> /WEB-INF/views/timeline/view.jsp를 이용해서 HTML을 만듦
			jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();
			break;

		// 4-1.타임라인 글수정폼
		case "/" + MODULE + "/updateForm.do":
			updateForm(request);
			// "/updateForm/list" 넘김-> /WEB-INF/views/timeline/updateForm +.jsp를 이용해서 HTML을
			// 만듦
			jspInfo = MODULE + "/updateForm";
			break;
		// 4-2.타임라인 글수정 처리
		case "/" + MODULE + "/update.do":
			// service - dao --> request에 저장 해줌
			Long no = update(request);
			// "view.do" 넘김-> /view.do로 자동이동
			jspInfo = "redirect:view.do?no=" + no + "&inc=0&page=" + pageObject.getPage() + "&perPageNum="
					+ pageObject.getPerPageNum();
			break;

		// 5.타임라인 글삭제 처리
		case "/" + MODULE + "/delete.do":
			// service - dao --> request에 저장 해줌
			delete(request);
			// "view.do" 넘김-> /view.do로 자동이동
			jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();
			break;

		// 6. 이미지 게시판 첨부 이미지 파일 바꾸기
		case "/" + MODULE + "/updateFile.do":
			// service - dao --> request에 저장까지 해준다.
			Long viewNo = updateFile(request);

			// list.do로 자동으로 이동
			String query = (request.getQueryString() == null) ? "" : request.getQueryString();
			jspInfo = "redirect:view.do?" + query + "&no=" + viewNo + "&inc=0&page=" + pageObject.getPage() + "&perPageNum="
					+ pageObject.getPerPageNum();
			break;

		// 7. 게시판 댓글 등록 처리
		case "/" + MODULE + "/replyWrite.do":
			// service - dao --> request에 저장까지 해준다.
			replyWrite(request);
			System.out.println("TimelineController [query] - " + request.getQueryString());

			// 글쓰기 처리가 끝난 후 경고창으로 나타나는 메시지
			session.setAttribute("msg", "게시판 댓글등록이 성공적으로 완료되었습니다.");

			// list.do로 자동으로 이동
			jspInfo = "redirect:view.do?" + request.getQueryString() + "&inc=0";
			break;

		// 8. 게시판 댓글 수정 처리
		case "/" + MODULE + "/replyUpdate.do":
			// service - dao --> request에 저장까지 해준다.
			replyUpdate(request);
			System.out.println("BoardController [query] - " + request.getQueryString());

			// 글쓰기 처리가 끝난 후 경고창으로 나타나는 메시지
			session.setAttribute("msg", "게시판 댓글 수정이 성공적으로 완료되었습니다.");

			// list.do로 자동으로 이동
			jspInfo = "redirect:view.do?no=" + request.getParameter("no") + "&inc=0";
			break;

		// 9. 게시판 댓글 삭제 처리
		case "/" + MODULE + "/replyDelete.do":
			// service - dao --> request에 저장까지 해준다.
			replyDelete(request);
			System.out.println("BoardController [query] - " + request.getQueryString());

			// 글쓰기 처리가 끝난 후 경고창으로 나타나는 메시지
			session.setAttribute("msg", "게시판 댓글 삭제가 성공적으로 완료되었습니다.");

			// list.do로 자동으로 이동
			jspInfo = "redirect:view.do?no=" + request.getParameter("no") + "&inc=0";
			break;

		default:
			throw new Exception("페이지 요청 중 오류 발생- 존재하지 않는 페이지입니다.");
		}

		// jsp의 정보를 가지고 리턴
		return jspInfo;
	}

	// 1.타임라인 리스트 처리
	private void list(HttpServletRequest request, PageObject pageObject) throws Exception {

		@SuppressWarnings("unchecked")
		List<TimelineVO> list = (List<TimelineVO>) ExeService.execute(Beans.getService(AuthorityFilter.url),
				pageObject);

		// 서버 객체 requset 에 담음
		request.setAttribute("list", list);

	}

	// 2.타임라인 보기 처리
	private Long view(HttpServletRequest request) throws Exception {
		// servlet-controller(*)-DAO-view.do
		// 넘어오는 데이터 받기
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		System.out.println("strNo " + no);
		// 조회수 1증가
		String strInc = request.getParameter("inc");
		long inc = Long.parseLong(strInc);
		System.out.println("strInc " + inc);

		// 타임라인 게시판 글보기 데이터 1개 가져오기
		TimelineVO vo = (TimelineVO) ExeService.execute(Beans.getService(AuthorityFilter.url), new Long[] { no, inc });

		// 서버 객체 requset 에 담음
		request.setAttribute("vo", vo);

		// 글번호를 리턴한다.
		return no;
	}

	// 3.타임라인 글쓰기
	private void write(HttpServletRequest request) throws Exception {

		// 저장 위치
		String path = ("/upload/timeline/");
		String realPath = request.getServletContext().getRealPath("upload/timeline");
		System.out.println("TimelineController.write().realPath : " + realPath);

		// fileSize : 용량 제한 - 10MByte
		int fileSize = 10 * 1024 * 1024; // 1000 -> 1K, 1000K -> 1M, 1000M -> 1G, 1000G -> 1T

		File dir = new File(realPath);
		if (!dir.exists()) dir.mkdirs();
		// 파일의 정보를 처리해 주는 객체 생성 -> 파일 업로드가 자동으로 이루어 진다.
		// new MultipartRequest(request, 실제적인 저장위치-컴에서, 파일용량제한, 엔코딩방식, 중복된파일이름처리객체);
		MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8",
				new DefaultFileRenamePolicy());
		
		// MultipartRequest 생성 후 request에서는 아무것도 나오지 않는다.
		// System.out.println("/image/write.jsp [request.title] - " +
		// request.getParameter("title"));
		// System.out.println("/image/write.jsp [multi.title] - " +
		// multi.getParameter("title"));
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		// 서버에 저장된 파일명
		String fileName = multi.getFilesystemName("imageFile");
		File f = new File(path + fileName);
//				String alias = ((LoginVO)request.getSession().getAttribute("login")).get

//				System.out.println("timelineControlelr : " + alias);
		System.out.println("TimelineController.write().fileName : " + fileName);

		// VO 객체를 생성하고 저장한다.
		TimelineVO vo = new TimelineVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(id);
		vo.setFileName(path + fileName);

		// DB 처리 - controller -> service -> dao
		Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

		System.out.println("ImageController.write().result : " + result);
		// 전달 메시지 저장
		request.getSession().setAttribute("msg", "타임라인 게시판에 글이 등록되었습니다.");

	}

	// 4-1.타임라인 글수정폼
	private void updateForm(HttpServletRequest request) throws Exception {
		// 1.넘어오는 데이터 받기 - 글 번호
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		// 조회수 1증가하는 부분은 inc=0으로 강제 셋팅해서 넘긴다.
		// 2.글 번호에 맞는 데이터 가져오기 -> TimelineViewService -> /timeline/view.jsp
		String url = "/timeline/view.do"; // 현재 url(update)과 다르므로 강제로 셋팅
		// 조회수는 증가 하지 않도록 inc=0 강제 셋팅
		TimelineVO vo = (TimelineVO) ExeService.execute(Beans.getService(url), new Long[] { no, 0L });
		// 3.서버 객체에 넣기
		request.setAttribute("vo", vo);
		// 넘어오는 데이터 받기
	}

	// 4-2.타임라인 글수정
	private Long update(HttpServletRequest request) throws Exception {
		// 1.데이터 수집
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		TimelineVO vo = new TimelineVO();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);

		// 2.DB처리 - update.jsp -> service-> dao
		Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

		if (result < 1)
			throw new Exception("타임라인 글수정 처리 오류-수정 할 데이터가 존재하지 않습니다.");

		return no;
	}

	// 5. 타임라인 글삭제 처리
	private void delete(HttpServletRequest request) throws Exception {
		String strNo = request.getParameter("no");
		String deleteFile = request.getParameter("deleteFile");

		System.out.println("TimelineController.delete().no : " + strNo);
		System.out.println("/timeline/delete.jsp [deleteFile] : " + deleteFile);

		Long no = Long.parseLong(strNo);

		// DB에서 데이터 삭제하기
		Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), no);
		if(result ==0 ) throw new Exception("TimelineController.delete() - 타임라인 게시판 글삭제 오류 - 존재하지 않는 글은 삭제할 수 없습니다.");

		// 이미지 파일 지우기
		FileUtil.remove(request.getServletContext().getRealPath("/") + deleteFile);
	}

	// 6. 타임라인 게시판 첨부 이미지 파일 바꾸기
	private Long updateFile(HttpServletRequest request) throws Exception {
		// 올라갈 파일의 서버의 상대 위치
		String path = "/upload/timeline/";
		String realPath = request.getServletContext().getRealPath(path);
		int fileSize = 10 * 1024 * 1024;

		// 파일 올리는 라이브러리 MultipartRequest 객체 생성 -> 자동으로 파일이 올라간다.
		MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8",
				new DefaultFileRenamePolicy());

		String strNo = multi.getParameter("no");
		String deleteFile = multi.getParameter("deleteFile");
		String fileName = multi.getFilesystemName("imageFile");

		// Page에 대한 정보를 문자열로 받아서 되돌아가는 url뒤에 정보로 붙여서 이동시킨다.
//			String strPage = multi.getParameter("page");
//			String strPerPageNum = multi.getParameter("perPageNum");

		// 넘겨 받은 정보 확인
		System.out.println("updateFile.jsp [no] : " + strNo);
		System.out.println("updateFile.jsp [deleteFile] : " + deleteFile);
		System.out.println("updateFile.jsp [fileName] : " + fileName);

		// 파일 정보를 수정 - 번호, 파일명
		TimelineVO vo = new TimelineVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setFileName(path + fileName);

		// DB에 파일 정보 수정
		int result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
		if (result == 0)
			throw new Exception("TimelineController - 이미지 게시판 글삭제 오류 - 존재하지 않는 글은 삭제할 수 없습니다.");

		// 이전 파일 삭제
		String deletePath = request.getServletContext().getRealPath("/");
		if (FileUtil.exist(deletePath + deleteFile))
			System.out.println("TimelineController - " + deleteFile + " 파일은 존재합니다.");
		// 실제적으로 지우는 처리
		if (!deleteFile.equals(vo.getFileName()))
			if (!FileUtil.remove(deletePath + deleteFile))
				session.setAttribute("msg", "파일이 존재하지 않아 파일 삭제하지 못했습니다.");
			else
				session.setAttribute("msg", "이미지 파일이 변경되었습니다.");
		return vo.getNo();
	}

	// 6. 댓글 리스트 가져오기
	private void replyList(Long no, PageObject pageObject, HttpServletRequest request) throws Exception {
		// DB에서 데이터 가져오기
		// 연결URL => /timeline/view.do -> 게시판 글보기
		// 댓글 리스트는 URL이 존재하지 않으나 데이터를 가져오기 위해 강제 셋팅해준다.
		// 처리되는 정보를 출력하지 않는다.
//			request.setAttribute("list", 
//					Beans.get("/timeline/replyList.do").service(new Object[] {no, pageObject}));
		// 처리되는 정보를 출력하는 프록시 구조의 프로그램을 거쳐 간다.
		request.setAttribute("list",
				ExeService.execute(Beans.getService("/timeline/replyList.do"), new Object[] { no, pageObject }));
	}

	// 7. 댓글 등록
	private void replyWrite(HttpServletRequest request) throws Exception {
		// 데이터 수집
		String strNo = request.getParameter("no");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		// VO 객체 생성과 저장
		TimelineReplyVO vo = new TimelineReplyVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setContent(content);
		vo.setId(id);
		// 정보를 출력하는 필터 처리가 된다.
		ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
		// 정보를 출력하지 않고 직접 호출해서 실행은 된다.
//			Beans.get(AuthorityFilter.url).service(vo);
	}

	// 8. 댓글 수정
	private void replyUpdate(HttpServletRequest request) throws Exception {
		// 데이터 수집
		String strRno = request.getParameter("rno");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		// VO 객체 생성과 저장
		TimelineReplyVO vo = new TimelineReplyVO();
		vo.setRno(Long.parseLong(strRno));
		vo.setContent(content);
		vo.setId(id);
		// 정보를 출력하는 필터 처리가 된다.
		ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
	}

	// 9. 댓글 삭제
	private void replyDelete(HttpServletRequest request) throws Exception {
		// 데이터 수집
		String strRno = request.getParameter("rno");
		// 정보를 출력하는 필터 처리가 된다.
		ExeService.execute(Beans.getService(AuthorityFilter.url), Long.parseLong(strRno));

	}

	// 1-1.패션 좋아요 보기
	private void timeView(HttpServletRequest request) throws Exception {

		String strNo = request.getParameter("no");
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setId(id);
		String url = "/like2/timeView.do";
		LikeVO likevo = (LikeVO) ExeService.execute(Beans.getService(url), vo);
		request.setAttribute("likevo", likevo);
	}
}
