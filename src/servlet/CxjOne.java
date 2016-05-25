package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

public class CxjOne extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CxjOne() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		
//		out.println("hello world !");
		
		String sql = "SELECT * FROM students";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("username");//取得用户名
		String password = request.getParameter("password");//取得密码
		
		
		//加载MYSQL JDBC驱动程序
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//创建连接conn
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spdb","root","");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//创建stmt		
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//创建rs		
			try {
				rs =stmt.executeQuery("SELECT passwd FROM users where username='"+userName
						+"'limit 1");
//				rs = stmt.executeQuery("SELECT * FROM users where username='"+userName
//						+"'and passwd='"+password+"'limit 1");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {				
				if(rs.next()){
					
					String dbpw=rs.getString(1);
					//修改SQL注入漏洞问题	
					if(dbpw.equals(password)){
						request.setAttribute("name_s",userName);
						request.setAttribute("password_s",password);
						request.getRequestDispatcher("../welcom.jsp").forward(request, response);	
					}
				}else{
				request.getRequestDispatcher("../index.jsp").forward(request, response);
			}
				
			//存在SQL注入漏洞	
//				if(rs.next()){
//					request.setAttribute("name_s",userName);
//					request.setAttribute("password_s",password);
//					request.getRequestDispatcher("/welcom.jsp").forward(request, response);
//				}else{
//					request.getRequestDispatcher("/index.jsp").forward(request, response);
//				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				//关闭数据库资源  注意关闭次序
				try {
					if(rs!=null){
						rs.close();							
					}
					if(stmt!=null){
						stmt.close();							
					}
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
				
//		// add some code 2016-5-5
//		if(password.equals("123")){//根据登陆情况，跳转页面
//			request.setAttribute("name_s",userName);
//			request.setAttribute("password_s",password);
//			request.getRequestDispatcher("/welcom.jsp").forward(request, response);
//		}else{
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//		}
		
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
		//out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
