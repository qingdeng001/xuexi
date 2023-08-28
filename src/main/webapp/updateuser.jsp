<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update Emp</title>
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
						更新员工信息:
					</h1>
					<form action="${pageContext.request.contextPath}/user/updateuser" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									uid:
								</td>
								<td valign="middle" align="left" >
									<input value="${user.uid}" name="uid" readonly />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="uname" value="${user.uname}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="realname" value="${user.realname}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="password" value="${user.password}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									权限:
								</td>
								<td valign="middle" align="left">
									<select name="permissions">

										<option value=系统管理员
												<c:if test="${user.permissions == '系统管理员'}">
													selected
												</c:if>
										>系统管理员</option>

										<option value=管理员
												<c:if test="${user.permissions == '管理员'}">
													selected
												</c:if>
										>管理员</option>
										<option value=游客
												<c:if test="${user.permissions == '游客'}">
													selected
												</c:if>
										>游客</option>

									</select>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									<select name="gender">

										<option value=男
												<c:if test="${user.gender=='男'}">
													selected
												</c:if>
										>男</option>

										<option value=女
												<c:if test="${user.gender=='女'}">
													selected
												</c:if>
										>女</option>

									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="提交" />
						</p>
						<p>
							<input type="button" class="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/user/list'"/>
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
