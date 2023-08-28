<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				Welcome  ${sessionScope.user.realname}!
			</h1>
			<form action="${pageContext.request.contextPath}/sector/select" method="post">
				<tr>
					<td valign="middle" align="left">
						<select name="xuanze">
							<option value = "" selected>--请选择--</option>
							<option value = id
									<c:if test="${xuanze == 'id'}">
										selected
									</c:if>>
								部门id
							</option>
							<option value = sector_name
									<c:if test="${xuanze == 'sector_name'}">
										selected
									</c:if>>
								部门名称
							</option>
							<option value = sector_address
									<c:if test="${xuanze == 'sector_address'}">
										selected
									</c:if>>
								部门地址
							</option>
						</select>
						<input type="text" class="inputgri" name="neirong" oninput="if(value.length>30)value=value.slice(0,30)" <c:if test="${neirong==neirong}">value="${neirong}" </c:if> placeholder="请输入搜索内容">
						<input type="submit" class="button" value="搜索" />
						<input type="button" class="button" value="重置" onclick="window.location.href='${pageContext.request.contextPath}/sector/list03'">
					</td>
				</tr>
			</form>
			<table class="table">
				<tr class="table_header">
					<td>
						<a href="${pageContext.request.contextPath}/sector/select?uid=id&xuanze=${xuanze}&neirong=${neirong}">部门id</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/sector/select?uid=sector_name&xuanze=${xuanze}&neirong=${neirong}">部门名称</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/sector/select?uid=sector_address&xuanze=${xuanze}&neirong=${neirong}">部门办公室地址</a>

					</td>
					<td>
						操作
					</td>
				</tr>

				<c:forEach items="${requestScope.sectors}" var="sector">
					<tr class="row1">

						<td>${sector.id}</td>
						<td>${sector.sector_name}</td>
						<td>${sector.sector_address}</td>
						<td>
							<a href="${pageContext.request.contextPath}/sector/delete?id=${sector.id}">删除</a>
							<a href="${pageContext.request.contextPath}/sector/selectbyid?id=${sector.id}">更新</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<p>
				<input type="button" class="button" value="添加部门信息" onclick="window.location.href='${pageContext.request.contextPath}/addsector.jsp'"/>
				<input type="button" class="button" value="人员管理" onclick="window.location.href='${pageContext.request.contextPath}/person/select?sectorid=&nianling=&xuanze=&neirong=&permissions=${sessionScope.user.permissions}&pages=1'">
				<input type="button" class="button" value="用户管理" onclick="window.location.href='${pageContext.request.contextPath}/user/list'">
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
