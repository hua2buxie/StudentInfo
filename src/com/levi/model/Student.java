package com.levi.model;

import java.util.Date;

public class Student
{
	private int stuId;
	private String stuNo;
	private String stuName;
	private String sex;
	private Date birthday;
	public int getStuId()
	{
		return stuId;
	}
	public void setStuId(int stuId)
	{
		this.stuId = stuId;
	}
	public String getStuNo()
	{
		return stuNo;
	}
	public void setStuNo(String stuNo)
	{
		this.stuNo = stuNo;
	}
	public String getStuName()
	{
		return stuName;
	}
	public void setStuName(String stuName)
	{
		this.stuName = stuName;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public Student(String stuNo, String stuName, String sex, Date birthday,
			int gradeId, String email, String stuDesc)
	{
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.sex = sex;
		this.birthday = birthday;
		this.gradeId = gradeId;
		this.email = email;
		this.stuDesc = stuDesc;
	}
	public Student()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public int getGradeId()
	{
		return gradeId;
	}
	public void setGradeId(int gradeId)
	{
		this.gradeId = gradeId;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getStuDesc()
	{
		return stuDesc;
	}
	public void setStuDesc(String stuDesc)
	{
		this.stuDesc = stuDesc;
	}
	private int gradeId=-1;
	private String email;
	private String stuDesc;
	
}
