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
					<form action="${pageContext.request.contextPath}/person/updateperson?sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&permissions=${sessionScope.user.permissions}&pages=${pages}&uid=${uid}" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left" >
									<input value="${person.id}" name="id" readonly />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${person.name}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${person.age}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									生日:
								</td>
								<td valign="middle" align="left">
									<input type="date" class="inputgri" name="birthday" value="<fmt:formatDate value="${person.birthday}" pattern="yyyy-MM-dd"/>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									电话号码:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="telephone_number"value="${person.telephone_number}" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									邮箱:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="email" value="${person.email}" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									入职时间:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="onboarding_time" value="<fmt:formatDate value="${person.onboarding_time}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									职位:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="post" value="${person.post}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									月薪:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="monthly_salary" value="${person.monthly_salary}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									奖金:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="bonus" value="${person.bonus}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									部门id:
								</td>
								<td valign="middle" align="left">
									<select name="sector_id" >
										<c:forEach items="${requestScope.sectors}" var="Sector">
										<option  value="${Sector.id}"
												<c:if test="${Sector.id == person.sector_id}">
													selected
												</c:if>
											>${Sector.sector_name}</option>
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

										<option value=男
												<c:if test="${person.sex=='男'}">
													selected
												</c:if>
										>男</option>

										<option value=女
												<c:if test="${person.sex=='女'}">
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
							<input type="button" class="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/person/select?sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&permissions=${sessionScope.user.permissions}&pages=${pages}&uid=${uid}'"/>
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
