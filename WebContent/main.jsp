<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统主界面</title>
<%
	if(session.getAttribute("currentUser")==null)
	{
		response.sendRedirect("index.jsp");
		return;
	}
%>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		//数据
		var treeData=[{
			text:"功能",
			children:[{
				text:"班级信息管理",
				attributes:{
					url:"gradeInfoManage.jsp"
				}
			},
			{
				text:"学生信息管理",
				attributes:{
					url:"studentInfoManage.jsp"
				}
			}
			]
		
		}];
		//实例化树菜单
		$("#tree").tree({
			data:treeData,
			lines:true,
			onClick:function(node)
			{
				if(node.attributes)
					{
					openTab(node.text,node.attributes.url);
					}
			}
		});
		//新增tab
		function openTab(text,url)
		{
			var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
			if($("#tabs").tabs('exists',text))
			{
				$("#tabs").tabs('select',text);
			}
			else
				$("#tabs").tabs('add',{
					title:text,
					content:content,
					closable:true
				});
		}
	});
</script>
</head>	
<body class="easyui-layout">
	<div region="north" style="height:80px;background-color:#E0EDFF;">
		<div align="left" style="width: 80%;float: left"><img src="images/main.jpg"></div>
		<div style="padding-top: 50px;padding-right: 20px;">当前用户：&nbsp;<font size="5px" color="red" >${currentUser.userName }</font></div>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="flase" id="tabs">
			<div title="首页"><p style="text-align:center;color:red;font-size:3em;">欢迎您使用本系统</p></div>
		</div>
	</div>
	<div region="west" style="width:150px;"title="导航菜单"split="true">
		<ul id="tree"></ul>
	</div>
	<div region="south" style="height:25px;color:red;font-size:1.5em;" align="center">版权所有:<a href="http://qsstudy.top">轻松学习网</a></div>
</body>

</html>