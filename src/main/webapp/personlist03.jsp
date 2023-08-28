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
					<a href="${pageContext.request.contextPath}/admin03.jsp">人员管理系统</a>
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
			<form action="${pageContext.request.contextPath}/person/select?${pageContext.request.contextPath}/person/select?sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&uid=${uid}&permissions=${sessionScope.user.permissions}&pages=1" method="post">
				<tr>

					<td valign="middle" align="right">
						部门：
						<select name="sectorid"  >
							<option value="" selected>--请选择--</option>
							<c:forEach items="${requestScope.sectors}" var="Sector" >
								<option  value="${Sector.id}"
										<c:if test="${Sector.id == sectorid}">
											selected
										</c:if>>
										${Sector.sector_name}
								</option>
							</c:forEach>
						</select>
					</td>
					<td valign="middle" align="right">
						年龄：
						<select name="nianling">
							<option value="" selected>--请选择--</option>
							<option value=" and age<=30"
									<c:if test="${nianling == ' and age<=30'}">
										selected
									</c:if>>
								30岁以下
							</option>
							<option value=" and age<=50"
									<c:if test="${nianling == ' and age<=50'}">
										selected
									</c:if>>
								50岁以下
							</option>
							<option value=" and age<=60"
									<c:if test="${nianling == ' and age<=60'}">
										selected
									</c:if>>
								60岁以下
							</option>
						</select>
					</td>
					<td>
					<td valign="middle" align="left">
						<select name="xuanze">
							<option value = "" selected>--请选择--</option>
							<option value = id
									<c:if test="${xuanze == 'id'}">
										selected
									</c:if>>
								用户id
							</option>
							<option value = name
									<c:if test="${xuanze == 'name'}">
										selected
									</c:if>>
								姓名
							</option>
							<option value = sector_name
									<c:if test="${xuanze == 'sector_name'}">
										selected
									</c:if>>
								部门名称
							</option>
						</select>
						<input type="text" class="inputgri" name="neirong" oninput="if(value.length>30)value=value.slice(0,30)" <c:if test="${neirong==neirong}">value="${neirong}" </c:if> placeholder="请输入搜索内容">
						<input type="submit" class="button" value="搜索" />
						<input type="button" class="button" value="重置" onclick="window.location.href='${pageContext.request.contextPath}/person/select?permissions=${sessionScope.user.permissions}&pages=1&sectorid=&nianling=&xuanze=&neirong='">
					</td>
				</tr>
			</form>
			<table class="table">
				<tr class="table_header">
					<td>
						<a href="${pageContext.request.contextPath}/person/select?uid=id&sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&permissions=${sessionScope.user.permissions}&pages=${pages}">id</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/person/select?uid=name&sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&permissions=${sessionScope.user.permissions}&pages=${pages}">用户姓名</a>
					</td>
					<td>
						<a  href="${pageContext.request.contextPath}/person/select?uid=age&sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&permissions=${sessionScope.user.permissions}&pages=${pages}">年龄</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/person/select?uid=sex&sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&permissions=${sessionScope.user.permissions}&pages=${pages}">性别</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/person/select?uid=birthday&sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&permissions=${sessionScope.user.permissions}&pages=${pages}">生日</a>
					</td>
					<td>
						电话号码
					</td>
					<td>
						邮箱
					</td>
					<td>
						入职时间
					</td>
					<td>
						工作岗位
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/person/select?uid=monthly_salary&sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&permissions=${sessionScope.user.permissions}&pages=${pages}">月薪</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/person/select?uid=bonus&sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&permissions=${sessionScope.user.permissions}&pages=${pages}">年终奖</a>
					</td>
					<td>
						部门
					</td>
				</tr>
				<c:forEach items="${requestScope.persons}" var="Person" varStatus="sta">
					<tr
							<c:if test="${sta.index%2==0}">
								class="row1"
							</c:if>
							<c:if test="${sta.index%2!=0}">
								class="row2"
							</c:if>
					>
						<td>${Person.id}</td>
						<td>${Person.name}</td>
						<td>${Person.age}</td>
						<td>${Person.sex}</td>
						<td><fmt:formatDate value="${Person.birthday}" pattern="yyyy-MM-dd"/></td>
						<td>${Person.telephone_number}</td>
						<td>${Person.email}</td>
						<td><fmt:formatDate value="${Person.onboarding_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${Person.post}</td>
						<td>${Person.monthly_salary}</td>
						<td>${Person.bonus}</td>
						<td>${Person.sector_name}</td>
					</tr>
				</c:forEach>
			</table>
			<p>
			<form action="${pageContext.request.contextPath}/person/select?permissions=${sessionScope.user.permissions}&sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&uid=${uid}" method="post">
				<input value="首页" type="button" class="button" onclick="window.location.href='${pageContext.request.contextPath}/person/select?sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&uid=${uid}&permissions=${sessionScope.user.permissions}&pages=1'">
				<input value="上一页" type="button" class="button" onclick="window.location.href='${pageContext.request.contextPath}/person/select?sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&uid=${uid}&permissions=${sessionScope.user.permissions}&pages=${pages-1}'">
				<input type="number" oninput="if(value>${count})value=${count};if (value<1)value=1" class="inputgri" placeholder="第${pages}页------共${count}页" name="pages">
				<input type="submit" class="button" value="前往" >
				<input value="下一页" type="button" class="button" onclick="window.location.href='${pageContext.request.contextPath}/person/select?sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&uid=${uid}&permissions=${sessionScope.user.permissions}&pages=${pages+1}'">
				<input value="末页" type="button" class="button" onclick="window.location.href='${pageContext.request.contextPath}/person/select?sectorid=${sectorid}&nianling=${nianling}&xuanze=${xuanze}&neirong=${neirong}&uid=${uid}&permissions=${sessionScope.user.permissions}&pages=${count}'">
			</form>
			</p>
			<p>
				<input type="button" class="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath}/admin03.jsp'"/>
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
