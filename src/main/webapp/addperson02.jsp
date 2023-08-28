<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
	<title>add Emp</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath}/css/style.css" />
</head>

<body>
<div id="">
	<div id="top_content">
		<div id="header">
			<div id="rightheader">
				<p>
					2009/11/20
					<br />
				</p>
			</div>
			<div id="topheader">
				<h1 id="title">
					<a href="${pageContext.request.contextPath}/admin02.jsp">人员管理系统</a>
				</h1>
			</div>
			<div id="navigation">
			</div>
		</div>
		<div id="content">
			<p id="whereami">
			</p>
			<h1>
				添加员工信息:
			</h1>
			<form action="${pageContext.request.contextPath}/person/addperson01?sectorid=&nianling=&xuanze=&neirong=&permissions=${sessionScope.user.permissions}&pages=1" method="post">
				<table cellpadding="0" cellspacing="0" border="0"
					   class="form_table">
					<tr>
						<td valign="middle" align="right">
							姓名:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="name" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							年龄:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="age" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							生日:
						</td>
						<td valign="middle" align="left">
							<input type="date" class="inputgri" name="birthday" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							电话号码:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="telephone_number" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							邮箱:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="email" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							入职时间:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="onboarding_time" placeholder="年-月-日 时:分:秒"/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							职位:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="post" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							月薪:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="monthly_salary" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							奖金:
						</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="bonus" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							部门id:
						</td>
						<td valign="middle" align="left">
							<select name="sector_id" >
								<c:forEach items="${requestScope.sectors}" var="Sector">
									<option  value="${Sector.id}">${Sector.sector_name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">
							性别:
						</td>
						<td valign="middle" align="left">
							<select name="sex">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</td>
					</tr>
				</table>
				<p>
					<input type="submit" class="button" value="提交" />
				</p>
				<p>
					<input type="button" class="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/person/select?sectorid=&nianling=&xuanze=&neirong=&permissions=${sessionScope.user.permissions}&pages=1'"/>
				</p>
			</form>
		</div>
	</div>
	<div id="footer">
		<div id="footer_bg">
			ABC@126.com
		</div>
	</div>
</div>
</body>
</html>
