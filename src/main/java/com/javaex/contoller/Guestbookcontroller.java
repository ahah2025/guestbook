package com.javaex.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GbookDAO;
import com.javaex.vo.GbookVO;

@WebServlet("/gbc")
public class Guestbookcontroller extends HttpServlet {

	// 필드
	private static final long serialVersionUID = 1L;
	private String regDate;

	// 생성자
	public Guestbookcontroller() {	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		
		//작동했는지 확인용
		System.out.println("나오는지 확인하는 용도");
		
		//action 파라미터의 값이 뭔지 알아야됨
		String action = request.getParameter("action");
		System.out.println(action);//업무구분
		
		if("list".equals(action)) { //리스트업무
			System.out.println("리스트");
			//리스트

			// db 데이터 가져온다 --> list
			GbookDAO gbookDAO = new GbookDAO();
			List<GbookVO> gbookList = gbookDAO.gbookSelect();

			System.out.println(gbookList);

			//저밑에 있는 list.jsp에게 후반일을 시킨다
			// 1) request객체에 데이터를 넣어준다
			request.setAttribute("gList",gbookList);
		
			// 2)list.jsp에 request 객체와 reponse 객체를 보낸다
			RequestDispatcher rd = request.getRequestDispatcher("/addlist.jsp");
			rd.forward(request, response);
			
		}
		
		else if("dForm".equals(action)) { //등록폼업무 (등록업무랑 구별할 것)
			System.out.println("등록폼");

			//등록폼을 응답해야한다
			//1)DB관련 할일이 없다 - 안하면된다

			//2)jsp에게 화면을 그리게 한다(포워드)
			//deleteForm.jsp 포워드한다
			RequestDispatcher rd = request.getRequestDispatcher("/deleteForm.jsp");
			rd.forward(request, response);

		}else if("add".equals(action)) { 
			System.out.println("등록");

			//파라미터 꺼내기
			String name = request.getParameter("name");
			String password = request.getParameter("password") ;
			String content = request.getParameter("content") ;
			String regDate = request.getParameter("regDate") ;
			

			//데이터를 묶는다
			GbookVO gbookVO = new GbookVO(name,password,content,regDate);
			System.out.println(gbookVO);
		
			//DAO 를 통해서 저장시키기
			GbookDAO gbookDAO = new GbookDAO();
			gbookDAO.gbookInsert(gbookVO);
			
			//리다이렉트
			response.sendRedirect("http://localhost:8080/guestbook/gbc?action=list");
			
			//응답 (리스트)하기
			// -- dao 시켜서 데이터 가져오기
			/*
			List<GbookVO> gbookList = gbookDAO.gbookSelect();
						
			//1)request 객체에 데이터를 넣어준다
			request.setAttribute("gList", gbookList);

			//2)list.jsp에 request객체와 response객체를 보낸다 
			
			/*포워드
			RequestDispatcher rd = request.getRequestDispatcher("/deleteForm.jsp");
			rd.forward(request, response);	
			*/	
			
			}else if("delete".equals(action)) {
				System.out.println("삭제");
			
				//파라미터에서 no 꺼내온다
				int no = Integer.parseInt(request.getParameter("no"));
				
				//dao를 통해서 no를 주고 삭제
				GbookDAO gbookDAO = new GbookDAO();
				gbookDAO.gbookDelete(no);
				
				
				//리다이렉트 action=list
				response.sendRedirect("http://localhost:8080/guestbook/gbc?action=list");
					
			}else if("mform".equals(action)) {
				System.out.println("수정폼");
				
				//파라미터에서  no 꺼내온다
				int no =  Integer.parseInt(request.getParameter("no"));
				
				//dao를 통해서 no를 주고 삭제
				GbookDAO gbookDAO = new GbookDAO();
				GbookVO gbookVO = gbookDAO.gbookSelectOne(no);
				
				//request객체에 데이터를 넣어준다
				request.setAttribute("gVO", gbookVO);
				
				//포워드
				RequestDispatcher rd = request.getRequestDispatcher("/modifyForm.jsp");
				rd.forward(request, response);
			
			}else if("modify".equals(action)) {
				System.out.println("수정");
				
				//파라미터 4개의 정보를 꺼내온다
				int no =  Integer.parseInt(request.getParameter("no"));
				String name = request.getParameter("name");
				String password =  request.getParameter("password");
				String content = request.getParameter("content");
				
				//데이터를 묶는다
				GbookVO gbookVO = new GbookVO(no, name, password, content,regDate);
				
				//dao를 통해서 no를 주고 삭제
				GbookDAO gbookDAO= new GbookDAO();
				gbookDAO.gbookUpdate(gbookVO);
				
				//리다이렉트 action=list
				response.sendRedirect("http://localhost:8080/guestbook/gbc?action=list");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
											throws ServletException, IOException {
		doGet(request, response);
	}

}
