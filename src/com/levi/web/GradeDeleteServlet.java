package com.levi.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.levi.dao.GradeDao;
import com.levi.model.Grade;
import com.levi.model.PageBean;
import com.levi.util.DbUtil;
import com.levi.util.JsonUtil;
import com.levi.util.ResponseUtil;

public class GradeDeleteServlet extends HttpServlet
{
	DbUtil dbUtil=new DbUtil();
	GradeDao gradeDao=new GradeDao();

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
		String delIds=request.getParameter("delIds");
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			
			int delNums=gradeDao.gradeDelete(con, delIds);
			if(delNums>0)
			{
				System.out.println("删除了"+delNums+"条数据");
				result.put("success","true");
				result.put("delNums", delNums);
			}
			else
			{
				result.put("errorMgs","删除失败");
			}
			ResponseUtil.write(response, result);
		}catch(Exception e)
		{
			System.out.println("删除数据出错"+e.getMessage());
		}
	}
	
}
