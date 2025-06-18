package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.javaex.vo.GbookVO;

public class GbookDAO {
	
	//필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/guestbook_db";
	private String id = "guestbook";
	private String pw = "guestbook";

	//생성자
	public GbookDAO() {	}
	
	//메소드gs
	// DB연결 메소드-공통
	private void connect() { // 메인에서는 사용 못함

		try {
			// 1. JDBC 드라이버 (MySQL) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			this.conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
	
	// 자원정리 메소드-공통
	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}	
	
	// 전체리스트 가져오기
		public List<GbookVO> gbookSelect() {

			//리스트 준비
			List<GbookVO> gbookList = new ArrayList<GbookVO>();
			
			this.connect();

			System.out.println("gbookSelect()");

			try {
				//3. SQL 준비 / 바인딩 / 실행
				//SQL 준비
				String query ="";
				query +=" select no, "; 
				query +="        name, ";      
				query +="        password, ";        
				query +="        content, ";     
				query +="        reg_date ";  
				query +=" from gbook ";  
				query +=" order by no asc ";
	
				// 바인딩
				pstmt = conn.prepareStatement(query);

				//실행
				rs = pstmt.executeQuery();

				//4. 결과처리
				while(rs.next()) { //반복한다

					int no = rs.getInt("no");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String content = rs.getString("content");
					String regDate = rs.getString("reg_date");

					//VO로 묶어준다
					GbookVO gbookVO = new GbookVO(no, name, password,content,regDate);

					//묶여진 VO를 리스트에 추가한다
					gbookList.add(gbookVO);
				}

			} catch (Exception e) {
				System.out.println("error:" + e);

			}
			this.close();
			return gbookList;
		}
		
		//등록
		public int gbookInsert (GbookVO gbookVO) {
			System.out.println(" gbookInsert() ");
			int count = -1;
			
			this.connect();

			try {
				//3. SQL 준비 / 바인딩 / 실행
				//SQL 준비
				String query ="";
				query +=" insert into gbook ";  
				query +=" values(null,?,?,?,?,?)  ";     
				
				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, gbookVO.getName());
				pstmt.setString(2, gbookVO.getPassword());
				pstmt.setString(3, gbookVO.getContent());
				pstmt.setString(4, gbookVO.getRegDate());
				
				//실행
				count = pstmt.executeUpdate();
							
				//4. 결과처리
				System.out.println(count +" 건이 저장되었습니다.");
				
			} catch (SQLException e) {
				System.out.println("error:" + e);
			
			}
			
			this.close();

			return count;
		}

		
		//삭제
		public int gbookDelete (int no) {
			System.out.println("gbookDelete");
			
			int count = -1;
			
			this.connect();

			try {
				//3. SQL 준비 / 바인딩 / 실행
				//SQL 준비
				String query ="";
				query +=" delete from gbook ";
				query +=" where no = ? ";  
				
				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, no);
				
				
				//실행
				count = pstmt.executeUpdate();
							
				//4. 결과처리
				System.out.println(count +" 건이 삭제되었습니다.");
				
			} catch (SQLException e) {
				System.out.println("error:" + e);

			}
			
			this.close();
			
			return count;
		}	
		
		
}
