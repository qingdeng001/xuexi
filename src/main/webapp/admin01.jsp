<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="css/style.css" />
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
                    <a href="#">人员管理系统</a>
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
            <table class="table">
                <td>
                    <input type="button" class="button" value="人员管理" onclick="window.location.href='${pageContext.request.contextPath}/person/select?sectorid=&nianling=&xuanze=&neirong=&permissions=${sessionScope.user.permissions}&pages=1'">
                </td>
                <td>
                    <input type="button" class="button" value="用户管理" onclick="window.location.href='${pageContext.request.contextPath}/user/list'">
                </td>
                <td>
                    <input type="button" class="button" value="部门管理" onclick="window.location.href='${pageContext.request.contextPath}/sector/list03'">
                </td>
                <td>
                    <input type="button" class="button" value="退出" onclick="window.location.href='${pageContext.request.contextPath}/login.jsp'">
                </td>
            </table>


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
