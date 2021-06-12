package connect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class Logincon
 */
@WebServlet("/loginserv")
public class Logincon extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincon() {
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


        try{
            String jsp;
            PrintWriter pw=response.getWriter();
            //连接数据库
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("数据库连接");
            //得到连接
            Connection ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=MyDatabase","sa","xjava");/*第20行*/
            System.out.println("连接数据库成功");
            //创建Statement , 执行 SQL 查询
            Statement sm=ct.createStatement();
            //查询用户名的密码
            String sql;
            sql ="select count(*) from mytable where name='" + username + "' and paswd='"+userpwd1+"'";
            // 执行查询
            ResultSet rs = sm.executeQuery(sql);
            if(rs.next()) {
                //用户存在
                System.out.println("用户存在");
                int dbpass = rs.getInt(1);
                System.out.println(dbpass);

                if(dbpass>0){
                    //用户合法
                    System.out.println("用户合法");
                    response.sendRedirect("登录成功要跳转的页面");
                    /*request.getRequestDispatcher("/Register.jsp").forward(request, response);*/
                    jsp="/Register.jsp";
                }else {
                    //用户不合法
                    System.out.println("用户不合法");
                    pw.print("<script language='javascript'>alert('用户名或密码错误');window.location.href='Login.jsp';</script>");
                    response.sendRedirect("Login.jsp");
                    /*request.getRequestDispatcher("/Login.jsp").forward(request, response);*/
                    jsp="/Login.jsp";
                }
            }else {
                System.out.println("用户不存在");
                pw.print("<script language='javascript'>alert('用户名或密码错误');window.location.href='Login.jsp';</script>");
                response.sendRedirect("Login.jsp");
                /*request.getRequestDispatcher("/Login.jsp").forward(request, response);*/
                jsp="/Login.jsp";
            }


            ct.close();  //数据库关闭
            System.out.println("数据库关闭");
            /*request.getRequestDispatcher("/Login.jsp").forward(request, response);*/
            request.getRequestDispatcher(jsp).forward(request, response);
        }catch (Exception ex){
            System.out.println("连接失败");
            ex.printStackTrace();
        }

    }

}

