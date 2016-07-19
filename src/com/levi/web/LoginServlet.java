package com.levi.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.levi.dao.UserDao;
import com.levi.model.User;
import com.levi.util.DbUtil;
import com.levi.util.StringUtil;

public class LoginServlet extends HttpServlet
{
	User user=null;
	User currentUser=null;
	UserDao userDao=new UserDao();
	Connection con=null;
	DbUtil dbUtil=new DbUtil();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		if(StringUtil.isEmpty(userName)||StringUtil.isEmpty(password))
		{
			request.setAttribute("error", "用户名和密码都不能为空!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}	
		try
		{
			
			con=dbUtil.getCon();
			user=new User(userName,password);
			currentUser=userDao.login(con, user);
			if(currentUser==null)
			{
				request.setAttribute("userName", userName);
				request.setAttribute("password", password);
				request.setAttribute("error", "用户名或密码错误");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else
			{
				HttpSession session=request.getSession();
				session.setAttribute("currentUser", currentUser);
				response.sendRedirect("main.jsp");
			}
			
		} catch (Exception e)
		{
			System.out.println("数据库连接错误，22失败!"+e.getMessage());
		}
		
	}
	
}
