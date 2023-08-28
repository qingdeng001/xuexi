<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>emplist</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
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
					<a href="${pageContext.request.contextPath}/admin01.jsp">人员管理系统</a>
				</h1>
			</div>
			<div id="navigation">
			</div>
		</div>
		<div id="content">
			<p id="whereami">
			</p>
			<h1>
				欢迎  ${sessionScope.user.realname}!
			</h1>
			<form action="${pageContext.request.contextPath}/user/select" method="post">
				<tr>
					<td valign="middle" align="right">
						权限：
						<select name="userpermissions"  >
							<option value="" selected>--请选择--</option>
							<c:forEach items="${requestScope.upermissions}" var="upermission" >
								<option  value="${upermission.permissions}"
										<c:if test="${upermission.permissions == userpermissions}">
											selected
										</c:if>>
										${upermission.permissions}
								</option>
							</c:forEach>
						</select>
					</td>
					<td valign="middle" align="left">
						<select name="xuanze">
							<option value = "" selected>--请选择--</option>
							<option value = uid
									<c:if test="${xuanze == 'uid'}">
										selected
									</c:if>>
								用户id
							</option>
							<option value = uname
									<c:if test="${xuanze == 'uname'}">
										selected
									</c:if>>
								姓名
							</option>
						</select>
						<input type="text" class="inputgri" name="neirong" oninput="if(value.length>30)value=value.slice(0,30)" <c:if test="${neirong==neirong}">value="${neirong}" </c:if> placeholder="请输入搜索内容">
						<input type="submit" class="button" value="搜索" />
						<input type="button" class="button" value="重置" onclick="window.location.href='${pageContext.request.contextPath}/user/list'">
					</td>
				</tr>
			</form>
			<table class="table">
				<tr class="table_header">
					<td>
						<a href="${pageContext.request.contextPath}/user/select?id=uid&userpermissions=${userpermissions}&xuanze=${xuanze}&neirong=${neirong}">uid</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/user/select?id=uname&userpermissions=${userpermissions}&xuanze=${xuanze}&neirong=${neirong}">用户名</a>
					</td>
					<td>
						真实姓名
					</td>
					<td>
						密码
					</td>
					<td>
						性别
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/user/select?id=permissions&userpermissions=${userpermissions}&xuanze=${xuanze}&neirong=${neirong}">权限</a>
					</td>
					<td>
						操作
					</td>
				</tr>
				<c:forEach items="${requestScope.users}" var="user">
					<tr class="row1">
						<td>${user.uid}</td>
						<td>${user.uname}</td>
						<td>${user.realname}</td>
						<td>${user.password}</td>
						<td>${user.gender}</td>
						<td>${user.permissions}</td>
						<td>
							<a href="${pageContext.request.contextPath}/user/delete?uid=${user.uid}">删除</a>
							<a href="${pageContext.request.contextPath}/user/selectbyuid?uid=${user.uid}">更新</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<p>
				<input onclick="window.location.href='${pageContext.request.contextPath}/person/select?sectorid=&nianling=&xuanze=&neirong=&permissions=${sessionScope.user.permissions}&pages=1'" type="button" class="button" value="人员管理">
				<input onclick="window.location.href='${pageContext.request.contextPath}/sector/list03'" type="button" class="button" value="部门信息管理">
			</p>
			<p>
				<input type="button" class="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/admin01.jsp'"/>
			</p>
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
