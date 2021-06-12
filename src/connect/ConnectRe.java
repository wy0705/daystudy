package connect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class ConnectRe
 */
@WebServlet("/loginserv.do")
public class ConnectRe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectRe() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //设置编码
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        doPost(request,response);



    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=utf-8");

        //获取参数
        String username = request.getParameter("username");
        String userpwd1 = request.getParameter("password1");
        String userpwd2 = request.getParameter("password2");

        try{
            PrintWriter pw=response.getWriter();
            //连接数据库
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("数据库连接");
            //得到连接
            Connection ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=MyDatabase","sa","xjava");/*第20行*/
            System.out.println("连接数据库成功");
            //创建Statement
            Statement sm=ct.createStatement();
            //得到结果集
            ResultSet rs=sm.executeQuery("select top 1 * from mytable");
            if(rs.next()){
            	pw.println("hf");
            }
            PreparedStatement ps = ct.prepareStatement("insert into mytable(name,paswd) values(?,?)");  //向数据库存入数据
            ps.setString(1, username);
            ps.setString(2, userpwd1);
            ps.execute();
            ps.close();
            ct.close();  //数据库关闭
            System.out.println("数据库关闭");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }catch (Exception ex){
            System.out.println("连接失败");
            ex.printStackTrace();
        }




    }

}

