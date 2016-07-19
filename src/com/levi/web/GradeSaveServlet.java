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
import com.levi.util.StringUtil;

public class GradeSaveServlet extends HttpServlet
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
		
		request.setCharacterEncoding("utf-8");
		String gradeName=request.getParameter("gradeName");
		String gradeDesc=request.getParameter("gradeDesc");
		Grade grade=new Grade(gradeName,gradeDesc);
		String id=request.getParameter("id");
		if(StringUtil.isNotEmpty(id))
		{
			grade.setId(Integer.parseInt(id));
		}
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(id))
			{
				saveNums=gradeDao.gradeModify(con, grade);
			}
			else
			{
				saveNums=gradeDao.gradeAdd(con, grade);
			}
			if(saveNums>0)
			{
				result.put("success","true");
				result.put("saveNums", saveNums);
			}
			else
			{
				result.put("success","true");
				result.put("errorMgs","删除失败");
			}
			ResponseUtil.write(response, result);
		}catch(Exception e)
		{
			System.out.println("删除数据出错"+e.getMessage());
		}
	}
	
}
