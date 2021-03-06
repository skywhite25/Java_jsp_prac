package com.OOTD.image.controller;

import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.OOTD.image.vo.ImageVO;
import com.OOTD.like.vo.LikeVO;
import com.OOTD.main.controller.Beans;
import com.OOTD.main.controller.Controller;
import com.OOTD.main.controller.ExeService;
import com.OOTD.member.vo.LoginVO;
import com.OOTD.util.PageObject;
import com.OOTD.util.file.FileUtil;
import com.OOTD.util.filter.AuthorityFilter;

public class ImageController implements Controller{

	private HttpSession session = null;
	private LoginVO loginVO = null;
	private String id = null; 
	
	
	private final String MODULE = "image";
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ImageController.execute() 실행 중-----------------------------------------------------------");
		
		// 세션과 아이디 저장
		session = request.getSession();
		loginVO = (LoginVO) session.getAttribute("login");
		if(loginVO != null)
			id = loginVO.getId();
		
		// 페이지를 위한 처리
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("pageObject", pageObject);
		
		switch (AuthorityFilter.url) {
		// 1.게시판 리스트
		case "/" + MODULE + "/list.do":
			// service를 호출해서 dao에서 데이터를 가져온 후 request에 저장까지 해준다.
			// "image/list"를 넘긴다. -> /WEB-INF/views/ + image/list + .jsp를 이용해서 HTML을 만든다.
			list(request, pageObject);
			jspInfo = MODULE + "/list";
			break;
			
		// 2.게시판 글보기
		case "/" + MODULE + "/view.do":
			view(request);
			fashionView(request);
			jspInfo = MODULE + "/view";
			break;
			
		// 3-1.게시판 글등록 폼
		case "/" + MODULE + "/writeForm.do":
			jspInfo = MODULE + "/writeForm";
			break;
			
		// 3-2.게시판 글등록 처리
		case "/" + MODULE + "/write.do":
			write(request);
			jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();
			break;
			
		// 4.게시판 이미지파일 수정
		case "/" + MODULE + "/updateFile.do":
			Long no = updateFile(request);
			jspInfo = "redirect:view.do?no=" + no + "&page=" + pageObject.getPage()
			 + "&perPageNum=" + pageObject.getPerPageNum();
			break;
			
		// 5.게시판 글정보 수정 폼
		case "/" + MODULE + "/updateForm.do":
			updateForm(request);
			jspInfo = MODULE + "/updateForm";
			break;
			
		//5-1.게시판 글정보 수정 처리
		case "/" + MODULE + "/update.do":
			Long no2 = update(request);
			jspInfo = "redirect:view.do?no=" + no2 + "&page=" + pageObject.getPage()
			 + "&perPageNum=" + pageObject.getPerPageNum();
			break;
		
			
		// 6.게시판 글삭제
		case "/" + MODULE + "/delete.do":
			delete(request);
			jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();
			break;
		
		default:
			throw new Exception("페이지 오류 404 - 존재하지 않는 페이지입니다.");
		}
		
		return jspInfo;
	}
	
	// 1. 이미지 게시판 리스트 처리
	private void list(HttpServletRequest request, PageObject pageObject) throws Exception {
		// DB에서 데이터 가져오기
		@SuppressWarnings("unchecked")
		List<ImageVO> list = (List<ImageVO>) ExeService.execute(Beans.getService(AuthorityFilter.url), pageObject);
		// 가져온 데이터 서버 객체에 담기 - list를 서버객체에 넣어준다.
		request.setAttribute("list", list);
		
	}
	
	// 2. 이미지게시판 글보기 
	public void view(HttpServletRequest request) throws Exception {
		// 넘어오는 데이터 받기 - 번호(, 페이지, 한 페이지당 이미지 갯수 : 나중에 처리)
		String strNo = request.getParameter("no");
		Long no = Long.parseLong(strNo);

		// DB에서 데이터 가져오기
		ImageVO vo = (ImageVO) ExeService.execute(Beans.getService(AuthorityFilter.url), no);
		
		// 서버객체(reauest)에 저장하기
		request.setAttribute("vo", vo);
	}
	
	// 3.이미지 게시판 글쓰기
	public void write(HttpServletRequest request) throws Exception {
		// 저장 위치 선언
		String path = "/upload/image/"; // 이 위치 안에 파일이 존재해야 한다.
		String realPath = request.getServletContext().getRealPath(path);
		System.out.println("/image/write.jsp [realPath] : " + realPath);
		
		// file size : 용량 제한 - 10MB로 제한
		int fileSize = 10 * 1024 * 1024; 
		
		// 파일의 정보를 처리해 주는 객체 생성 -> 파일 업로드가 자동으로 이루어 진다.
		// new MultipartRequest(request, (컴퓨터에서) 실제적인 저장위치, 파일 용량 제한, 엔코딩방식, 중복된 파일 이름을 처리하는 객체)
		MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8", new DefaultFileRenamePolicy());

		// MultipartRequest 생성 후에는 request에서 아무것도 나오지 않는다.
		//System.out.println("/image/write.jsp [request.title] : " + request.getParameter("title")); // 서버에서 가져온 title
		//System.out.println("/image/write.jsp [multi.title] : " + multi.getParameter("title")); //multi에서 가져온 title

		String strSeasonNo = multi.getParameter("seasonNo");
		Long seasonNo = Long.parseLong(strSeasonNo);
		String name1 = multi.getParameter("name1");
		String link1 = multi.getParameter("link1");
		String name2 = multi.getParameter("name2");
		String link2 = multi.getParameter("link2");
		String name3 = multi.getParameter("name3");
		String link3 = multi.getParameter("link3");
		String name4 = multi.getParameter("link4");
		String link4 = multi.getParameter("name4");
		
		// 서버에 저장된 파일명
		String fileName = multi.getFilesystemName("imageFile");
		System.out.println("/image/write.jsp [fileName] : " + fileName);
		System.out.println("/image/write.jsp [seasonNo] : " + seasonNo);


		// vo객체 생성 후 저장
		ImageVO vo = new ImageVO();
		vo.setName1(name1);
		vo.setLink1(link1);
		vo.setName2(name2);
		vo.setLink2(link2);
		vo.setName3(name3);
		vo.setLink3(link3);
		vo.setName4(name4);
		vo.setLink4(link4);
		vo.setFileName(path + fileName);
		vo.setSeasonNo(seasonNo);

		// DB처리
		Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

	}
	
	// 4.이미지 게시글 파일 수정
	public long updateFile(HttpServletRequest request) throws Exception {
		// 올라갈 파일의 서버 상대 위치
		String path = "/upload/image/";
		String realPath = request.getServletContext().getRealPath(path);

		int fileSize = 10 * 1024 * 1024;

		// 파일 올리는 라이브러리 MultipartRequest 객체 생성 -> 생성과 동시에 자동으로 파일이 올라간다.
		// MultipartRequest에서 꺼내서 DefaultFileRenamePolicy를 이용해서 자동으로 올린다.
		MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8", new DefaultFileRenamePolicy());

		String strNo = multi.getParameter("no");
		Long no = Long.parseLong(strNo);
		String deleteFile = multi.getParameter("deleteFile");
		String fileName = multi.getFilesystemName("imageFile");
//
//		// page에 대한 정보를 문자열로 받아서 되돌아가는 view.jsp 뒤에 정보로 붙여서 이동시킨다.
//		String strPage = multi.getParameter("page");
//		String strPerPageNum = multi.getParameter("perPageNum");

		// 위에서 넘겨받은 정보 확인
		System.out.println("updateFile.jsp [no] : " + strNo);
		System.out.println("updateFile.jsp [deleteFile] : " + deleteFile);
		System.out.println("updateFile.jsp [fileName] : " + fileName);

		// 파일 정보 수정 - 번호, 파일명 넘기기
		ImageVO vo = new ImageVO();
		vo.setNo(no);
		vo.setFileName(path + fileName);

		// DB에 파일 정보 수정
		int result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

		// 이전(원본) 파일 삭제
		String deletePath = request.getServletContext().getRealPath("/");
		if(FileUtil.exist(deletePath + deleteFile)){
			System.out.println(deleteFile + "파일은 존재합니다.");
		} else System.out.println(deleteFile + "파일이 존재하지 않습니다.");
		//실제적으로 지우는 처리
		FileUtil.remove(deletePath + deleteFile);
		return no;

	}
	
	//5.게시판 글정보 수정폼
	private void updateForm(HttpServletRequest request) throws Exception {
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);

		String url = "/image/view.do";
		ImageVO vo = (ImageVO) ExeService.execute(Beans.getService(url), no);

		request.setAttribute("vo", vo);
	}
	
	// 5-1.게시판 글 정보 수정처리
	public long update(HttpServletRequest request) throws Exception {
		System.out.println("/image/update.jsp - 글수정 처리 완료");

		String strNo = request.getParameter("no");
		Long no = Long.parseLong(strNo);
		String strSeasonNo = request.getParameter("seasonNo");
		Long seasonNo = Long.parseLong(strSeasonNo);
		String name1 = request.getParameter("name1");
		String link1 = request.getParameter("link1");
		String name2 = request.getParameter("name2");
		String link2 = request.getParameter("link2");
		String name3 = request.getParameter("name3");
		String link3 = request.getParameter("link3");
		String name4 = request.getParameter("name4");
		String link4 = request.getParameter("link4");

		System.out.println("update.jsp [seasonNo] : " + seasonNo);

		ImageVO vo = new ImageVO();
		vo.setNo(no);
		vo.setSeasonNo(seasonNo);
		vo.setName1(name1);
		vo.setLink1(link1);
		vo.setName2(name2);
		vo.setLink2(link2);
		vo.setName3(name3);
		vo.setLink3(link3);
		vo.setName4(name4);
		vo.setLink4(link4);

		System.out.println("/image/update.jsp [vo] : " + vo);

		Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
		
		if(result < 1)
			throw new Exception("게시판 글수정(ImageController.update() - 수정할 데이터가 존재하지 않습니다.");
		
		return no;

	}
	
	// 6. 게시판 글 삭제
	public void delete(HttpServletRequest request) throws Exception {
		// 넘어오는 데이터 받기
		String strNo = request.getParameter("no");
		String strPerPageNum = request.getParameter("perPageNum");
		String deleteFile = request.getParameter("deleteFile");

		System.out.println("/image/delete.jsp [no] : " + strNo);
		System.out.println("/image/delete.jsp [perPageNum] : " + strPerPageNum);
		System.out.println("/image/delete.jsp [deleteFile] : " + deleteFile);

		Long no = Long.parseLong(strNo);

		// DB에서 데이터 삭제하기
		ExeService.execute(Beans.getService(AuthorityFilter.url), no);

		// 이미지 파일 지우기
		FileUtil.remove(request.getServletContext().getRealPath("/") + deleteFile);

	}
	
		//1-1.패션 좋아요 보기 
		private void fashionView(HttpServletRequest request)throws Exception{
			
		String strNo = request.getParameter("no");
		LikeVO vo = new LikeVO();
		vo.setNo(Long.parseLong(strNo));
		vo.setId(id);
		String url = "/like/fashionView.do";
		LikeVO likevo = (LikeVO)ExeService.execute(Beans.getService(url), vo);
		request.setAttribute("likevo", likevo);
	}

		
}
