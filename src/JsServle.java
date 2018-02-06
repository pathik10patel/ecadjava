

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
/**
 * Servlet implementation class JsServle
 */
@WebServlet("/JsServle")
public class JsServle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsServle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//String city=request.getParameter("city");
		String eid = null,city1 = null,ename = null,age = null;
		response.setContentType("text/json");
		String sql="select * from employee";
		try {
			ResultSet rs=Dao.select(sql);
			
			
			while(rs.next())
			{	
				eid=rs.getString("eid");
				ename=rs.getString("ename");
				city1=rs.getString("city");
				age=rs.getString("age");
				System.out.println(eid+" "+ename+" "+city1+" "+age );
				response.getWriter().write("employee {\n eid {  "+eid+"\n");

				//response.getWriter().write(eid);
				response.getWriter().write("},\n");
				response.getWriter().write("ename { "+ename+"\n");
//				response.getWriter().write(ename);
				response.getWriter().write("},\n");
				response.getWriter().write("city { "+city1+"\n");
				//response.getWriter().write(city1);
				response.getWriter().write("},\n");
				response.getWriter().write("age {"+age+" \n");
				//response.getWriter().write(age);
				response.getWriter().write("},\n");
				response.getWriter().write("},\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
